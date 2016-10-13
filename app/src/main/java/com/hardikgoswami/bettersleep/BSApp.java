package com.hardikgoswami.bettersleep;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by geniushkg on 10/13/2016.
 */

public class BSApp extends Application {
    public void onCreate() {
        super.onCreate();

        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this));
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(getApplicationContext()));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }
}
