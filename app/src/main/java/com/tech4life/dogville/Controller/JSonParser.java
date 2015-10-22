package com.tech4life.dogville.Controller;

import android.util.Log;

import com.tech4life.dogville.Controller.Constants.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * @author Mina
 * @version 1.0
 */

class JSonParser {

    private String ERROR_MESSAGE = "Error parsing data";
    final String TAG = "JSONParser";
    final String GET = "GET";
    static JSONObject jObj = null;
    static JSONArray jArray = null;
    String data = "";

    /**
     * getJSONFromUrl
     * get JSONObject  with required data from  url
     *
     * @return JSONObject
     * @author Mina
     */

    public JSONObject getJSONFromUrl(String urlString) throws JSONException {
        try {
            MainControl.CONNECT = true;
            if (MainControl.CONNECT) {
                URL url = new URL(urlString);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(10000 /* milliseconds */);
                conn.setRequestMethod(GET);
                conn.setDoInput(true);

                // Starts the query
                conn.connect();
                InputStream stream = conn.getInputStream();
                data = convertStreamToString(stream);
                stream.close();
            } else {
                if (urlString.equals(AppConstants.MEAL_URL)) {
//                    path = UIConstants.MEALS_PATH;
//                    data = new Scanner(new File(path), "UTF-8").next();
                    jObj = new JSONObject(AppConstants.PRODUCTS_JSON);
                }

            }
            try {
                jObj = new JSONObject(data);
            } catch (JSONException e) {
                Log.e(TAG, ERROR_MESSAGE + e.toString());
            }
        } catch (Exception e) {
            Log.e(TAG, ERROR_MESSAGE, e);

        }

        return jObj;
    }

    /**
     * convertStreamToString
     * convert InputStream  to a string
     *
     * @param
     * @return String
     * @author Mina
     */

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public JSONArray getJSONArrayFromUrl(String urlString) throws JSONException {
        try {
            MainControl.CONNECT = true;
            if (MainControl.CONNECT) {
                URL url = new URL(urlString);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(10000 /* milliseconds */);
                conn.setRequestMethod(GET);
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                InputStream stream = conn.getInputStream();
                data = convertStreamToString(stream);
                stream.close();
            } else {
                if (urlString.equals(AppConstants.MEAL_URL)) {
//                    path = UIConstants.MEALS_PATH;
//                    data = new Scanner(new File(path), "UTF-8").next();
                    jObj = new JSONObject(AppConstants.PRODUCTS_JSON);
                }
//                else if (urlString.equals(UIConstants.DISEASES_URL)) {
////                    path = UIConstants.DISEASES_PATH;
////                    data = new Scanner(new File(path), "UTF-8").next();
//                    jObj = new JSONObject(UIConstants.DISEASES_JSON);
//                } else if (urlString.equals(UIConstants.DOCTOR_URL)) {
////                    path = UIConstants.DOCTORS_PATH;
////                    data = new Scanner(new File(path), "UTF-8").next();
//                    jObj = new JSONObject(UIConstants.DOCTORS_JSON);
//                }
            }
            try {
                jArray = new JSONArray(data);
            } catch (JSONException e) {
                Log.e(TAG, ERROR_MESSAGE + e.toString());
            }
        } catch (Exception e) {
            Log.e(TAG, ERROR_MESSAGE, e);

        }

        return jArray;
    }

    public JSONObject requestService(String url,JSONObject jsonRequest) {
        try {
            String  responseText = "";
            MainControl.CONNECT = true;
            if (MainControl.CONNECT) {

//                DefaultHttpClient httpClient = new DefaultHttpClient();
//                HttpPost httpPost = new HttpPost();
//                StringEntity entity = new StringEntity(jsonRequest.toString(),
//                        "UTF-8");
//                URI urlstring = new URI(url);
//                httpPost.setEntity(entity);
//                httpPost.setHeader("content-type", "application/json");
//                httpPost.setURI(urlstring);
//                HttpResponse httpResponse = httpClient.execute(httpPost);
//                StatusLine sl = httpResponse.getStatusLine();
//                 responseText = EntityUtils.toString(httpResponse.getEntity());
             } else {

            }
            try {
                jObj = new JSONObject(responseText);
            } catch (JSONException e) {
                Log.e(TAG, ERROR_MESSAGE + e.toString());
            }
        } catch (Exception e) {
            Log.e(TAG, ERROR_MESSAGE, e);
        }
        return jObj;
    }
}
