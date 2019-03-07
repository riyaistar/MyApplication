package com.example.myapplication.expandableListView;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    int id;
    String name;
    String description;
    String imageURL;
    List<ProductAsset> productAssets;
    private Boolean selected;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return this.name;            // What to display in the Spinner list.
    }

    public List<ProductAsset> getProductAssets() {
        return productAssets;
    }

    public void setProductAssets(List<ProductAsset> productAssets) {
        this.productAssets = productAssets;
    }
}