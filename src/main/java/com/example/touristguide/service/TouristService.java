package com.example.touristguide.service;

import com.example.touristguide.model.TouristAttraction;
import org.springframework.stereotype.Service;
import com.example.touristguide.repository.TouristRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {
    private final TouristRepository repo;
    public TouristService(TouristRepository repo) {this.repo = repo;}

    public List<TouristAttraction> all(){return repo.findAll();}
    public Optional<TouristAttraction> one(String name){return repo.findByName(name);}
    public void save(TouristAttraction a){ repo.save(a); }
    public boolean remove(String name){return repo.deleteByName(name);}

    public List<String> cities(){return repo.getCities();}
    public List<String> tagCatalog(){return repo.getTags();}
}

