package com.android.berry;

import android.app.Application;

import com.android.berry.engine.Engine;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by xuxinying on 15-10-20.
 */
public class BaseApp extends Application {
    private static BaseApp sInstance;
    private Engine mEngine;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        mEngine = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/bingoogolapple/BGABanner-Android/server/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);

        Fresco.initialize(this);
    }


    public static BaseApp getInstance() {
        return sInstance;
    }

    public Engine getEngine() {
        return mEngine;
    }
}
