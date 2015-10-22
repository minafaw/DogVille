package com.tech4life.dogville.View;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;

import com.tech4life.dogville.Controller.ErrorHandler;
import com.tech4life.dogville.Controller.RequestBuilder;
import com.tech4life.dogville.webservice.data.LoginResponse;
import com.tech4life.dogville.Controller.Constants.AppConstants;


public class LoginService extends IntentService {


    public LoginService() {
        super("LoginService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String username = intent.getExtras().getString(AppConstants.USERNAME);
            String password = intent.getExtras().getString(AppConstants.PASSWORD);

            try{
                RequestBuilder request = new RequestBuilder();
                LoginResponse response = request.doLogin(username, password, AppConstants.BASE_URL + AppConstants.LOGIN_URL  );
                Message responseMessage = LoginActivity.operationHandler.obtainMessage(1, response);
                LoginActivity.operationHandler.sendMessage(responseMessage);

            }catch (Exception e){
                Intent intentToSaveRecord = new Intent(LoginService.this,
                        ErrorHandler.class);
                intentToSaveRecord.putExtra(AppConstants.ERROR_LOADING, "Connection Error");
                intentToSaveRecord.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentToSaveRecord);
            }
            }
        }
    }