package com.tech4life.dogville.View;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;

import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.Controller.ErrorHandler;
import com.tech4life.dogville.Controller.RequestBuilder;
import com.tech4life.dogville.Model.DogsModel;

import java.util.Vector;

/**
 * Created by karma on 20/05/2015.
 */
public class PuppyService extends IntentService {

    Vector<DogsModel> dogsList = new Vector<DogsModel>();

    public PuppyService(String name) {
        super(name);
    }
    public PuppyService() {
        super("PuppyService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try{
            RequestBuilder request = new RequestBuilder();
                dogsList = request.getAllPuppies(AppConstants.Dogs_URL);
                Message responseMessage = PuppyFragment.operationHandler.obtainMessage(1, dogsList);
                PuppyFragment.operationHandler.sendMessage(responseMessage);
        }catch (Exception e){
            Intent intentToSaveRecord = new Intent(PuppyService.this,
                    ErrorHandler.class);
            intentToSaveRecord.putExtra(AppConstants.ERROR_LOADING, "Connection Error");
            intentToSaveRecord.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentToSaveRecord);
        }
    }
}
