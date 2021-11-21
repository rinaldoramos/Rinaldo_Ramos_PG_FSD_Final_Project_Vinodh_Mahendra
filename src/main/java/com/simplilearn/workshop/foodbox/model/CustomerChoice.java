package com.simplilearn.workshop.foodbox.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "selections")
public class CustomerChoice implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    private String imageUrl;
    private String name;
    private String description;
    private String category;
    private double price;
    private boolean state;

    public CustomerChoice() {
    }

    public CustomerChoice(Long id, String imageUrl, String name, String description, double price, String category, boolean state) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String brand) {
        this.description = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", state=" + state +
                '}';
    }
}
