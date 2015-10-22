package com.tech4life.dogville.View;

import android.app.IntentService;
import android.content.Intent;
import android.os.Message;

import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.Controller.ErrorHandler;
import com.tech4life.dogville.Controller.RequestBuilder;
import com.tech4life.dogville.Model.DogsModel;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.webservice.data.LoginResponse;

import java.util.Vector;

/**
 * Created by karma on 18/05/2015.
 */

public class HomeService extends IntentService {
    Vector<ProductsModel> accessoriesList = new Vector<ProductsModel>();
    Vector<ProductsModel> foodsList = new Vector<ProductsModel>();
    Vector<DogsModel> dogsList = new Vector<DogsModel>();
    LoginResponse response;
    int currentResponse = -1;
    public static int HOME_ACCESSORIES = 1;
    public static int HOME_PUPPIES = 3;
    public static int HOME_FOOD = 2;

    public HomeService()
    {
        super("HomeService");
    }
    public HomeService(String name) {
        super("HomeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try{
            RequestBuilder request = new RequestBuilder();
            currentResponse = HOME_ACCESSORIES;

            if(currentResponse == HOME_ACCESSORIES) {
                accessoriesList = request.getHomeAccessory(AppConstants.HOME_ACCESSORY);
                Message responseMessage = MenuFragment.operationHandler.obtainMessage(1, accessoriesList);
                responseMessage.arg1=HOME_ACCESSORIES;
                MenuFragment.operationHandler.sendMessage(responseMessage);
                currentResponse = HOME_FOOD;

            }
            if(currentResponse == HOME_FOOD) {
                foodsList = request.getHomeFood(AppConstants.HOME_FOOD);
                Message  responseMessage = MenuFragment.operationHandler.obtainMessage(1, foodsList);
                responseMessage.arg1=HOME_FOOD;
                MenuFragment.operationHandler.sendMessage(responseMessage);
                currentResponse = HOME_PUPPIES;

            }

            if(currentResponse == HOME_PUPPIES) {
                dogsList = request.getHomePuppies(AppConstants.HOME_PUPPIES);
                Message responseMessage = MenuFragment.operationHandler.obtainMessage(1, dogsList);
                responseMessage.arg1=HOME_PUPPIES;
                MenuFragment.operationHandler.sendMessage(responseMessage);
            }
        }catch (Exception e){
            Intent intentToSaveRecord = new Intent(HomeService.this,
                    ErrorHandler.class);
            intentToSaveRecord.putExtra(AppConstants.ERROR_LOADING, "Connection Error");
            intentToSaveRecord.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intentToSaveRecord);
        }
    }
}
