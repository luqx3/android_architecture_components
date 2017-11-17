package com.example.zzb.aac.dragger;

import android.app.Activity;
import android.arch.lifecycle.LiveData;

import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPDAO;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HP on 2017/11/16.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity activity() {
        return this.activity;
    }

//    @Provides
//    IPDAO provideIpDao(){
//        return providesMyIPDB();
//    }
}
