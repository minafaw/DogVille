package com.tech4life.dogville.Controller;

import com.tech4life.dogville.webservice.data.LoginRequest;
import com.tech4life.dogville.webservice.data.RegistrationRequest;
import com.tech4life.dogville.Controller.Constants.AppConstants;

/**
 * Created by karma on 09/06/2015.
 */
public class RequestParamBuilder {

    public static String[][] getLoginRequestParam(LoginRequest request) {

        String requestParam[][] = {
                {AppConstants.USERNAME,request.getUserName()},
                {AppConstants.PASSWORD,request.getPassword()}
        };
        return requestParam;
    }

    public static String[] [] getRegistrationRequestParam(RegistrationRequest request){
        String requestParam [] [] = {
                {AppConstants.REGISTRATION_FIRST_NAME,request.getFirstName()},
                {AppConstants.REGISTRATION_LAST_NAME,request.getPassword()},
                {AppConstants.REGISTRATION_EMAIL,request.getEmail()},
                {AppConstants.REGISTRATION_PHONE,request.getMobileNumber()},
                {AppConstants.REGISTRATION_PASSWORD,request.getPassword()}
        };
        return requestParam;
    }

}
