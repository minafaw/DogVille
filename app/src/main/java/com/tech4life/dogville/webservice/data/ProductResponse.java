package com.tech4life.dogville.webservice.data;

/**
 * Created by karma on 27/05/2015.
 */

public class ProductResponse extends BaseResponse {

    private String name;
    private String kind ;
    private String description;
    private String description2 ;
    private String description3;
    private String description4 ;
    private String imageURL;
    private String price;
    private String MostView;
    private String id;


    public String getName() {
        return name;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


    public ProductResponse() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMostView() {
        return MostView;
    }

    public void setMostView(String mostView) {
        MostView = mostView;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
