package com.example.zzb.aac;

import android.app.Application;

import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.AppModule;
import com.example.zzb.aac.dragger.DaggerAppComponent;


/**
 * Created by HP on 2017/11/16.
 */

public class MyAppliaction extends Application {


    AppComponent appComponent = null;
//    @Inject
//    AnalyticsManager analyticsManager;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

