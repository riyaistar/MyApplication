package com.example.myapplication.expandableListView;

public class ProductAsset {
    private String assetUrl;
    private String assetType;
    private String assetName;

    public ProductAsset() {
    }

    public ProductAsset(String assetUrl, String assetType, String assetName) {
        super();
        this.assetUrl = assetUrl;
        this.assetType = assetType;
        this.assetName = assetName;
    }

    public String getAssetUrl() {
        return assetUrl;
    }

    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

}
