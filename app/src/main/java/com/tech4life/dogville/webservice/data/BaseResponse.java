package com.tech4life.dogville.webservice.data;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * Created by karma on 27/05/2015.
 */
public class BaseResponse implements Serializable {

    private boolean isSuccessful;
    private String resultString;

    public boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }


    public BaseResponse() {
    }

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

}


