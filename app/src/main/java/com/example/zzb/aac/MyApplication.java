package com.example.zzb.aac;

import android.app.Application;

import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.AppModule;
import com.example.zzb.aac.dragger.DaggerAppComponent;

/**
 * Created by zzb on 2017/11/17.
 */

public class MyApplication extends Application {


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

//    public AppComponent getAppComponent(){
//        return DaggerAppComponent.builder()
//                .appModule(new AppModule((MyApplication) getApplicationContext()))
//                .build();
//    }
}
