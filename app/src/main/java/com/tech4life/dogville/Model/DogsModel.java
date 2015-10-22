package com.tech4life.dogville.Model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by karma on 23/08/2015.
 */
public class DogsModel implements Serializable {


    private String dogid;
    private String DogName;
    private Drawable image;
    private String Price;
    private Bitmap bitmapImage;
    private String Description;
    private String Imageurl;
    private String genderId;
    private String NoOfViews;
    private String dogLoc;
    private String dog_age;
    private String dog_color;

    public String getDogLoc() {
        return dogLoc;
    }

    public void setDogLoc(String dogLoc) {
        this.dogLoc = dogLoc;
    }

    public String getDog_age() {
        return dog_age;
    }

    public void setDog_age(String dog_age) {
        this.dog_age = dog_age;
    }

    public String getDog_color() {
        return dog_color;
    }

    public void setDog_color(String dog_color) {
        this.dog_color = dog_color;
    }

    public String getDogid() {
        return dogid;
    }

    public Bitmap getBitmapImage() {
        return bitmapImage;
    }

    public void setBitmapImage(Bitmap bitmapImage) {
        this.bitmapImage = bitmapImage;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }


    public void setDogid(String dogid) {
        this.dogid = dogid;
    }

    public String getDogName() {
        return DogName;
    }

    public void setDogName(String dogName) {
        DogName = dogName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getNoOfViews() {
        return NoOfViews;
    }

    public void setNoOfViews(String noOfViews) {
        NoOfViews = noOfViews;
    }
}
