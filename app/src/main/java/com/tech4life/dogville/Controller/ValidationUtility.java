package com.tech4life.dogville.Controller;

/**
 * Created by karma on 28/06/2015.
 */
public class ValidationUtility {

    public static boolean isEmpty(String value) {
        if (value != null && value.trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

}
