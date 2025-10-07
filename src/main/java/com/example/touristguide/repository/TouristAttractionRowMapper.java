package com.example.touristguide.repository;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TouristAttractionRowMapper implements RowMapper<TouristAttraction> {
    @Override
    public TouristAttraction mapRow(ResultSet rs, int rowNum) throws SQLException{
        TouristAttraction touristAttraction = new TouristAttraction();


                touristAttraction.setId(rs.getInt("id"));
                touristAttraction.setName(rs.getString("name"));
                touristAttraction.setDescription(rs.getString("description"));
                touristAttraction.setPrice(rs.getBigDecimal("price"));
                touristAttraction.setCityId(rs.getInt("city_id"));
                touristAttraction.setCategoryId(rs.getInt("category_id"));
        return touristAttraction;
    }

}
