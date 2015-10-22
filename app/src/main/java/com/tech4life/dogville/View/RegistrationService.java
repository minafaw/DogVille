package com.tech4life.dogville.View;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;

import com.tech4life.dogville.Controller.ErrorHandler;
import com.tech4life.dogville.Controller.RequestBuilder;
import com.tech4life.dogville.webservice.data.RegistrationResponse;
import com.tech4life.dogville.Controller.Constants.AppConstants;


public class RegistrationService extends IntentService {


    public RegistrationService() {
        super("RegistrationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String username = intent.getExtras().getString(AppConstants.USERNAME);
            String password = intent.getExtras().getString(AppConstants.PASSWORD);
            String phone = intent.getExtras().getString(AppConstants.REGISTRATION_PHONE);
            String email = intent.getExtras().getString(AppConstants.REGISTRATION_EMAIL);

            try{
                RequestBuilder request = new RequestBuilder();
                RegistrationResponse response = request.doRegister(username, password,phone,email, AppConstants.SINGUP_URL);
                Message responseMessage = SignUpActivity.operationHandler.obtainMessage(1, response);
                SignUpActivity.operationHandler.sendMessage(responseMessage);

            }catch (Exception e){
                Intent intentToSaveRecord = new Intent(RegistrationService.this,
                        ErrorHandler.class);
                intentToSaveRecord.putExtra(AppConstants.ERROR_LOADING, "Connection Error");
                intentToSaveRecord.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentToSaveRecord);
            }
            }
        }
    }