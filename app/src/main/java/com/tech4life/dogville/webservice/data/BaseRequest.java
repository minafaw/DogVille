package com.tech4life.dogville.webservice.data;

/**
 * Created by karma on 27/05/2015.
 */
public class BaseRequest {

    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
