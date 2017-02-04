package com.nikiizvorski.sugarandroid.app;

import android.app.Application;

import com.orm.SugarContext;

/**
 * The type Sugar app.
 */
public class SugarApp  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}