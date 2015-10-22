package com.tech4life.dogville.Controller;

import android.app.IntentService;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tech4life.dogville.Model.DogsModel;
import com.tech4life.dogville.Model.ProductMessage;
import com.tech4life.dogville.Model.ProductsModel;
import com.tech4life.dogville.Model.PuppyOrder;
import com.tech4life.dogville.Model.TipQuestion;
import com.tech4life.dogville.Model.TipsModel;
import com.tech4life.dogville.Model.TypesModel;
import com.tech4life.dogville.Model.UsersModel;
import com.tech4life.dogville.webservice.data.BaseResponse;
import com.tech4life.dogville.webservice.data.LoginResponse;
import com.tech4life.dogville.webservice.data.RegistrationResponse;
import com.tech4life.dogville.Controller.Constants.AppConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;
import java.util.Vector;

/**
 * Created by karma on 17/03/2015.
 */

public class RequestBuilder {

    private JSONObject jsonObject;
    private JSONArray objectArray;
    JSonParser json = new JSonParser();
    HTTPManager request = new HTTPManager();
    Vector<ProductsModel> productsList = new Vector<ProductsModel>();
    Vector<UsersModel> usersList = new Vector<UsersModel>();
    private JSONArray subObjectArray;
    private Vector<DogsModel> puppiesList = new Vector<DogsModel>();
    private BaseResponse response;
    private Vector<TypesModel> types = new Vector<TypesModel>();
    private Vector<TipsModel> tip = new Vector<TipsModel>();
    private Vector<DogsModel> dogsList = new Vector<DogsModel>();

    public Vector<ProductsModel> getProducts(String strJSONMeal) throws Exception {
        objectArray = json.getJSONArrayFromUrl(strJSONMeal);
        for (int i = 0; i < objectArray.length(); i++) {
            ProductsModel productMeal = new ProductsModel();
            productMeal.setProductName(objectArray.getJSONObject(i).getString("ProductName"));
            productMeal.setDescription(objectArray.getJSONObject(i).getString("description"));
            productMeal.setId(objectArray.getJSONObject(i).getString("ProductId"));
            productMeal.setTypeID(objectArray.getJSONObject(i).getString("Typeid"));
            productMeal.setImageURL("http://dogville.somee.com/ProductsImg/"+objectArray.getJSONObject(i).getString("imageURL"));
            URL url = new URL(productMeal.getImageURL());
            Bitmap bimage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            productMeal.setBitmapImage(bimage);
            Drawable drawable = (Drawable) new BitmapDrawable(bimage);
            productMeal.setImage(drawable);
            productMeal.setPrice(objectArray.getJSONObject(i).getString("price"));
            productMeal.setNoOfViews(objectArray.getJSONObject(i).getString("NoOfViews"));
            productsList.add(productMeal);

        }
        return productsList ;
    }

    public Vector<ProductsModel> getHomeFood(String strJSONMeal) throws Exception {
        objectArray = json.getJSONArrayFromUrl(strJSONMeal);

        for (int i = 0; i < objectArray.length(); i++) {

            ProductsModel productMeal = new ProductsModel();
            productMeal.setProductName(objectArray.getJSONObject(i).getString("ProductName"));
            productMeal.setDescription(objectArray.getJSONObject(i).getString("description"));
            productMeal.setId(objectArray.getJSONObject(i).getString("ProductId"));
            productMeal.setTypeID(objectArray.getJSONObject(i).getString("Typeid"));
            productMeal.setImageURL("http://dogville.somee.com/ProductsImg/"+objectArray.getJSONObject(i).getString("imageUrl"));
            URL url = new URL(productMeal.getImageURL());
            Bitmap bimage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            productMeal.setBitmapImage(bimage);
            Drawable drawable = (Drawable) new BitmapDrawable(bimage);
            productMeal.setImage(drawable);
            productMeal.setPrice(objectArray.getJSONObject(i).getString("price"));
            productMeal.setNoOfViews(objectArray.getJSONObject(i).getString("NoOfViews"));
            productsList.add(productMeal);

        }
        return productsList ;
    }

    public Vector<ProductsModel> getHomeAccessory (String strJSONMeal) throws Exception {
        objectArray = json.getJSONArrayFromUrl(strJSONMeal);

        for (int i = 0; i < objectArray.length(); i++) {

            ProductsModel productMeal = new ProductsModel();
            productMeal.setProductName(objectArray.getJSONObject(i).getString("ProductName"));
            productMeal.setDescription(objectArray.getJSONObject(i).getString("description"));
            productMeal.setId(objectArray.getJSONObject(i).getString("ProductId"));
            productMeal.setTypeID(objectArray.getJSONObject(i).getString("Typeid"));
            productMeal.setImageURL("http://dogville.somee.com/ProductsImg/"+objectArray.getJSONObject(i).getString("imageUrl"));
            URL url = new URL(productMeal.getImageURL());
            Bitmap bimage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            productMeal.setBitmapImage(bimage);
            Drawable drawable = (Drawable) new BitmapDrawable(bimage);
            productMeal.setImage(drawable);
            productMeal.setPrice(objectArray.getJSONObject(i).getString("price"));
            productMeal.setNoOfViews(objectArray.getJSONObject(i).getString("NoOfViews"));
            productsList.add(productMeal);

        }
        return productsList ;
    }

    public Vector<DogsModel> getHomePuppies (String Json)throws Exception {
        objectArray = json.getJSONArrayFromUrl(Json);

        for (int i = 0; i < objectArray.length(); i++) {

            DogsModel productMeal = new DogsModel();
            productMeal.setDogid(objectArray.getJSONObject(i).getString("ProductId"));
            productMeal.setDogName(objectArray.getJSONObject(i).getString("ProductName"));
            productMeal.setDescription(objectArray.getJSONObject(i).getString("description"));
            productMeal.setImageurl("http://dogville.somee.com/ProductsImg/"+objectArray.getJSONObject(i).getString("imageUrl"));
            productMeal.setPrice(objectArray.getJSONObject(i).getString("price"));
            URL url = new URL(productMeal.getImageurl());
            Bitmap bimage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            productMeal.setBitmapImage(bimage);
            Drawable drawable = (Drawable) new BitmapDrawable(bimage);
            productMeal.setImage(drawable);
            productMeal.setGenderId("1");
            productMeal.setNoOfViews(objectArray.getJSONObject(i).getString("NoOfViews"));
            dogsList.add(productMeal);
        }
        return dogsList;
    }

    public Vector<ProductsModel> getProductsByTypes(String Json)throws  Exception {

        objectArray = json.getJSONArrayFromUrl(Json);

        for (int i = 0; i < objectArray.length(); i++) {

            ProductsModel productMeal = new ProductsModel();
            productMeal.setProductName(objectArray.getJSONObject(i).getString("ProductName"));
            productMeal.setDescription(objectArray.getJSONObject(i).getString("description"));
            productMeal.setId(objectArray.getJSONObject(i).getString("ProductId"));
            productMeal.setTypeID(objectArray.getJSONObject(i).getString("Typeid"));
            productMeal.setImageURL("http://dogville.somee.com/ProductsImg/"+objectArray.getJSONObject(i).getString("imageURL"));
            URL url = new URL(productMeal.getImageURL());
            Bitmap bimage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            productMeal.setBitmapImage(bimage);
            Drawable drawable = (Drawable) new BitmapDrawable(bimage);
            productMeal.setImage(drawable);
            productMeal.setPrice(objectArray.getJSONObject(i).getString("price"));
            productMeal.setNoOfViews(objectArray.getJSONObject(i).getString("NoOfViews"));
            productsList.add(productMeal);

        }
        return productsList ;
    }

    public TipsModel getTip(String Json) throws Exception{

        objectArray = json.getJSONArrayFromUrl(Json);
        TipsModel tip = new TipsModel();
        tip.setTipId(objectArray.getJSONObject(0).getString("TipId"));
        tip.setTiptext(objectArray.getJSONObject(0).getString("Tiptext"));
        return tip;
    }

    public Vector<DogsModel> getAllPuppies(String Json)throws Exception {
        objectArray = json.getJSONArrayFromUrl(Json);

        for (int i = 0; i < objectArray.length(); i++) {

            DogsModel productMeal = new DogsModel();
            productMeal.setDogid(objectArray.getJSONObject(i).getString("ProductId"));
            productMeal.setDogName(objectArray.getJSONObject(i).getString("ProductName"));
            productMeal.setDescription(objectArray.getJSONObject(i).getString("description"));
            productMeal.setImageurl("http://dogville.somee.com/DogsImg/"+objectArray.getJSONObject(i).getString("imageUrl"));
            productMeal.setPrice(objectArray.getJSONObject(i).getString("price"));
            URL url = new URL(productMeal.getImageurl());
            Bitmap bimage = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            productMeal.setBitmapImage(bimage);
            Drawable drawable = (Drawable) new BitmapDrawable(bimage);
            productMeal.setImage(drawable);
 //         productMeal.setGenderId(objectArray.getJSONObject(i).getString("genderId"));
            productMeal.setNoOfViews(objectArray.getJSONObject(i).getString("NoOfViews"));
            dogsList.add(productMeal);
        }
        return dogsList;
    }

    public LoginResponse doLogin(String userName,String password,String url) throws Exception{

        jsonObject = new JSONObject();
        jsonObject.put(AppConstants.PASSWORD,password);
        jsonObject.put(AppConstants.USERNAME,userName);
       JSONObject s = json.requestService(url,jsonObject);
        LoginResponse response = new LoginResponse();
        response.setIsSuccessful(Boolean.parseBoolean(s.getString("isSuccessful")));
        response.setResultString(s.getString("resultMessage"));

        return response;
    }

    public BaseResponse doPuppyOrder(String Json,PuppyOrder order,String url) throws Exception{
        jsonObject = new JSONObject();
        jsonObject.put(AppConstants.PUPPY_NAME,order.getPuppyName());
        jsonObject.put(AppConstants.PUPPY_DESCRIPTION,order.getPuppyDescription());
        jsonObject.put(AppConstants.PUPPY_IMAGE,order.getPuppyImage());
        jsonObject.put(AppConstants.PUPPY_GENDER,order.getPuppyGender());
        jsonObject.put(AppConstants.PUPPY_USERID,order.getUserID());
        JSONObject s = json.requestService(url,jsonObject);
        LoginResponse response = new LoginResponse();
        response.setIsSuccessful(Boolean.parseBoolean(s.getString("isSuccessful")));
        response.setResultString(s.getString("resultMessage"));

        return response;
    }

    public BaseResponse doProductMessage(String Json,ProductMessage productMessage,String url)throws Exception{
        jsonObject = new JSONObject();
        jsonObject.put(AppConstants.PRODUCT_MESSAGE,productMessage.getProductMessage());
        jsonObject.put(AppConstants.PRODUCT_ID,productMessage.getProductid());
        jsonObject.put(AppConstants.USER_ID,productMessage.getUserid());

        JSONObject s = json.requestService(url,jsonObject);
        LoginResponse response = new LoginResponse();
        response.setIsSuccessful(Boolean.parseBoolean(s.getString("isSuccessful")));
        response.setResultString(s.getString("resultMessage"));

        return response;
    }


    public RegistrationResponse doRegister(String userName,String password,String phone,String Email,String url) throws Exception{

        jsonObject = new JSONObject();
        jsonObject.put(AppConstants.USERNAME,userName);
        jsonObject.put(AppConstants.PASSWORD,password);
        jsonObject.put(AppConstants.REGISTRATION_PHONE,phone);
        jsonObject.put(AppConstants.REGISTRATION_EMAIL,Email);
        JSONObject s = json.requestService(url,jsonObject);
        RegistrationResponse response = new RegistrationResponse();
        response.setIsSuccessful(Boolean.parseBoolean(s.getString("isSuccessful")));
        response.setResultString(s.getString("resultMessage"));

        return response;
    }

    public BaseResponse doTipQuestion(String Json,TipQuestion question)throws Exception{
        jsonObject = new JSONObject();
        jsonObject.put(AppConstants.TIP_QUESTION,question.getQuestion());
        jsonObject.put(AppConstants.USERID,question.getUserID());

        JSONObject s = json.requestService(Json,jsonObject);
        BaseResponse response = new BaseResponse();
        response.setIsSuccessful(Boolean.parseBoolean(s.getString("isSuccessful")));
        response.setResultString(s.getString("resultMessage"));

        return response;
    }

    public BaseResponse doOrder(){return response;}

    // Extra Web Services not needed

    public Vector<UsersModel> getUsers (String strJSONMeal ,IntentService service ) throws Exception {

        objectArray = json.getJSONArrayFromUrl(strJSONMeal);
//        Iterator x = jsonObject.keys();
//        while (x.hasNext()){
//            String key = (String) x.next();
//            objectArray.put(jsonObject.get(key));
//        }

        for (int i = 0; i < objectArray.length(); i++) {

            UsersModel user = new UsersModel();

            user.setFirstName(objectArray.getJSONObject(i).getString("firstName"));
            user.setLastName(objectArray.getJSONObject(i).getString("phone"));
            user.setPhone(objectArray.getJSONObject(i).getString("lastName"));
            user.setEmail(objectArray.getJSONObject(i).getString("email"));

            usersList.add(user);
        }
        return usersList ;
    }

    public Vector<TypesModel> getProductTypes(){

        return types;
    }

}