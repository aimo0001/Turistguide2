package com.example.touristguide.repository;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> storeAttractions = new ArrayList<>(List.of(new TouristAttraction("SMK", "Museum for Kunst", "København", List.of("Kunst", "Museum")),
            new TouristAttraction("Odense Zoo", "Europas bedste zoo", "Odense", List.of("Børnevenlig")),
            new TouristAttraction("Dyrehaven", "Naturpark med skovområder", "Kongens Lyngby", List.of("Natur", "Gratis")),
            new TouristAttraction("Tivoli", "Forlystelsespark i København centrum", "København", List.of("Børnevenlig"))
    ));

    public List<TouristAttraction> findAll() {return new ArrayList<>(storeAttractions);}

    public Optional<TouristAttraction> findByName(String name) {
        return storeAttractions.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst();
    }

    public TouristAttraction save(TouristAttraction a){
        deleteByName(a.getName());
        storeAttractions.add(a);
        return a;
    }

    public boolean deleteByName(String name) {
        return storeAttractions.removeIf(a -> a.getName().equalsIgnoreCase(name));
    }

    public List<String> getCities() {
        return List.of("København", "Aarhus", "Odense", "Aalborg", "Kongens Lyngby");
    }
    public List<String> getTags() {
        return List.of("Kunst", "Museum", "Børnevenlig", "Natur", "Gratis");
    }
}
