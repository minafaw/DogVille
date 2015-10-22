package com.tech4life.dogville.webservice;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;
import com.tech4life.dogville.Controller.Constants.AppConstants;
import com.tech4life.dogville.Interfaces.VolleyResponeCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by NT on 10/15/15.
 */
public class VolleyRequestHandler implements Response.ErrorListener, Response.Listener {

    public static final int LOGIN_INT = 0;
    public static final int SINGUP_INT = 1;
    public static final int ALLDIESEAS_INT = 2;


    private String URl = null;
    private JsonObject jsonObject;
    private Context _Context;
    private int con_type;
    private VolleyResponeCallBack callback;
    private JsonParsing parser;

    private static int  TIME_OUT = 5000;
    private static int  MAX_RETRIES = 2;


    public VolleyRequestHandler(Context _context) {
        this._Context = _context;
        parser = new JsonParsing();

    }

    private String getURl(int type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.BASE_URL );

        switch (type) {

            case LOGIN_INT:
                stringBuilder.append(AppConstants.LOGIN_URL);
                break;

            case SINGUP_INT:
                stringBuilder.append(AppConstants.SINGUP_URL);
                break;

            case ALLDIESEAS_INT:
                //stringBuilder.append(AppConstants.ALLDIEASES);
        }

        return stringBuilder.toString();
    }

    private Object ResponseParser(Object responseObj, int parser_type) {

        Object res = null;
        switch (parser_type) {
            case LOGIN_INT:
                //res = parser.getUserDataObject((JSONObject) responseObj);
                break;

            case SINGUP_INT:
                //res = AppConstants.TRUE;
                break;

            case ALLDIESEAS_INT:
                //res = parser.GetDisesInfo((JSONObject) responseObj);
                break;
        }

        return res;
    }

    public void HandleRequests(int type, Map<String, String> params, VolleyResponeCallBack callBack) {
        this.con_type = type;
        this.callback = callBack;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, getURl(type), new JSONObject(params), this, this);
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT , MAX_RETRIES ,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(_Context.getApplicationContext()).getResquestQueue().add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        String error_msg = VolleyErrorHelper.getMessage(error, _Context);
        //Toast.makeText(_Context, VolleyErrorHelper.getMessage(error, _Context), Toast.LENGTH_LONG).show();
        callback.RequestFailed(error_msg);

    }

    @Override
    public void onResponse(Object response) {
        JSONObject jsonRespone = null;
        try {
            jsonRespone = (JSONObject) response;
            if (true) {

                //TODO CHANGE METHOD
                //callback.RequestSuccess(ResponseParser(jsonRespone.get(AppConstants.DATA), con_type));
                callback.RequestSuccess(response);

            } else {
                callback.RequestFailed((String) jsonRespone.get(AppConstants.MESSAGE));
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
            callback.RequestFailed(ex.getMessage().toString());
        }

    }
}
