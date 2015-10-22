package com.tech4life.dogville.Controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 *
 * @author lamiaa
 *This class helps getting a drawable image from a url
 */



public class ImageUtils {

    public static synchronized Drawable getImage(String url) throws IOException {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {

            URL connectionURL = new URL(url);
            connection = (HttpURLConnection) connectionURL.openConnection();
            connection.setDoOutput(true);
            connection.connect();
            inputStream = connection.getInputStream();

            return Drawable.createFromStream(inputStream, "map");
        }
        catch (Exception ex)
        {
            System.out.println("EXCEPTION:" + ex);
            ex.toString();
            throw new IOException(ex.getMessage());
        }
        finally {
            try {
                inputStream.close();
                inputStream = null;
                connection.disconnect();
                connection = null;
            }
            catch(Exception e){}
        }
    }


    public static synchronized Bitmap getBitmapImage(String url) throws IOException {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedInputStream bis = null;
        Bitmap bm = null;
        try {
            URL connectionURL = new URL(url);
            connection = (HttpURLConnection) connectionURL.openConnection();
            connection.setDoInput(true);
            connection.connect();

            inputStream = connection.getInputStream();

            bis = new BufferedInputStream(inputStream);
            bm = BitmapFactory.decodeStream(bis);

            System.out.println("in Connection");
            return bm;

        }
        catch (Exception ex)
        {
            System.out.println("EXCEPTION:" + ex);
            ex.toString();
            throw new IOException(ex.getMessage());
        }
        finally {
            try {
                bis.close();
                inputStream.close();
                inputStream = null;
                connection.disconnect();
                connection = null;
            }
            catch(Exception e){}
        }
    }



}
