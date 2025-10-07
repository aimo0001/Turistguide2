package com.example.touristguide.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int cityId;
    private int categoryId;


    private String city;
    private List<String> tags = new ArrayList<>();

    public TouristAttraction() {}
    public TouristAttraction(String name, String description, String city, List<String> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        if (tags != null) {this.tags = tags;}
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}
    public List<String> getTags() {return tags;}
    public void setTags(List<String> tags) {this.tags = tags;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getCategoryId() {return categoryId;}
    public void setCategoryId(int categoryId) {this.categoryId = categoryId;}
    public int getCityId() {return cityId;}
    public void setCityId(int cityId) {this.cityId = cityId;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}

}
