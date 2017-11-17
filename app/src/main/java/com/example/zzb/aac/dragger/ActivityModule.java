package com.example.zzb.aac.dragger;

import android.app.Activity;
import android.arch.lifecycle.LiveData;

import com.example.zzb.aac.BaseActivity;
import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPDAO;
import com.example.zzb.aac.repository.MyIPDB;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HP on 2017/11/16.
 */
@Module
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    BaseActivity activity() {
        return this.activity;
    }
//    @Provides
//    @ActivityScope
//    AppComponent appComponent(){
//        return activity.getAppComponent();
//    };
//    IPDAO getIpDao(){
//        return activity;
//    }
//    MyIPDB getmyIPDB();

//    @Provides
//    IPDAO provideIpDao(){
//        return providesMyIPDB();
//    }
}
