package com.tech4life.dogville.webservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by MINA on 10/15/15.
 */
public class MySingleton {
    private static MySingleton mInstance;
    private Context mContext;
    private RequestQueue mResquestQueue;
    private ImageLoader mImageLoader;

    private MySingleton(Context mCtx){
        this.mContext = mCtx;
        mImageLoader = new ImageLoader(mResquestQueue , new ImageLoader.ImageCache(){
            private final LruCache<String , Bitmap> cache = new LruCache<String , Bitmap>(20);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url , bitmap);

            }
        });


    }

    public static synchronized MySingleton getInstance(Context context){
        if(mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;

    }

    public RequestQueue getResquestQueue(){
        if(mResquestQueue == null){
            mResquestQueue= Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mResquestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        mResquestQueue.add(request);
    }

    public ImageLoader getmImageLoader(){
        return mImageLoader;
    }
}
