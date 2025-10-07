package com.example.touristguide.repository;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {

    private final JdbcTemplate jdbc;

    public TouristRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final RowMapper<TouristAttraction> MAPPER = (rs, n) ->
            new TouristAttraction(
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("city"),
                    new ArrayList<>()
            );

    public List<TouristAttraction> findAll() {
        var list = jdbc.query(
                "SELECT name, description, city FROM attraction ORDER BY name",
                MAPPER
        );
        for (var a : list) a.setTags(findTags(a.getName()));
        return list;
    }

    public Optional<TouristAttraction> findByName(String name) {
        var rows = jdbc.query(
                "SELECT name, description, city FROM attraction WHERE name = ?",
                MAPPER, name
        );
        if (rows.isEmpty()) return Optional.empty();
        var a = rows.get(0);
        a.setTags(findTags(name));
        return Optional.of(a);
    }

    private List<String> findTags(String attractionName) {
        return jdbc.query("""
            SELECT t.name
            FROM tag t
            JOIN attraction_tag at ON at.tag_id = t.id
            JOIN attraction a ON a.id = at.attraction_id
            WHERE a.name = ?
            ORDER BY t.name
            """, (rs, n) -> rs.getString(1), attractionName);
    }

    public void save(TouristAttraction a) {
        // Upsert på name (unik constraint i schema.sql)
        jdbc.update("""
            INSERT INTO attraction(name, description, city)
            VALUES (?, ?, ?)
            ON DUPLICATE KEY UPDATE description = VALUES(description),
                                    city = VALUES(city)
            """, a.getName(), a.getDescription(), a.getCity());

        Integer attractionId = jdbc.queryForObject(
                "SELECT id FROM attraction WHERE name = ?",
                Integer.class, a.getName()
        );

        jdbc.update("DELETE FROM attraction_tag WHERE attraction_id = ?", attractionId);

        if (a.getTags() != null) {
            for (String tag : a.getTags()) {
                Integer tagId = jdbc.queryForObject(
                        "SELECT id FROM tag WHERE name = ?",
                        Integer.class, tag
                );
                jdbc.update(
                        "INSERT INTO attraction_tag(attraction_id, tag_id) VALUES (?, ?)",
                        attractionId, tagId
                );
            }
        }
    }

    public boolean deleteByName(String name) {
        return jdbc.update("DELETE FROM attraction WHERE name = ?", name) > 0;
    }

    public List<String> getCities() {
        return jdbc.query("SELECT name FROM city ORDER BY name", (rs, n) -> rs.getString(1));
    }

    public List<String> getTags() {
        return jdbc.query("SELECT name FROM tag ORDER BY name", (rs, n) -> rs.getString(1));
    }
}
