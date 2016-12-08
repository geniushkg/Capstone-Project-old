package com.hardikgoswami.githubmetrics;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by geniushkg on 12/7/2016.
 */

public class GithubMetricsApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
