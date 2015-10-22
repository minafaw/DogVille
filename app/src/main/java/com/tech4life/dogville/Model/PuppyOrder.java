package com.tech4life.dogville.Model;

/**
 * Created by karma on 24/08/2015.
 */
public class PuppyOrder {

    private String puppyName;
    private String puppyDescription;
    private String puppyImage;
    private String puppyGender;
    private String UserID;

    public String getPuppyName() {
        return puppyName;
    }

    public void setPuppyName(String puppyName) {
        this.puppyName = puppyName;
    }

    public String getPuppyDescription() {
        return puppyDescription;
    }

    public void setPuppyDescription(String puppyDescription) {
        this.puppyDescription = puppyDescription;
    }

    public String getPuppyImage() {
        return puppyImage;
    }

    public void setPuppyImage(String puppyImage) {
        this.puppyImage = puppyImage;
    }

    public String getPuppyGender() {
        return puppyGender;
    }

    public void setPuppyGender(String puppyGender) {
        this.puppyGender = puppyGender;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
