package com.example.zzb.aac.dragger;

import android.app.Activity;

import com.example.zzb.aac.MainActivity;
import com.example.zzb.aac.repository.IPDAO;

import dagger.Component;

/**
 * Created by zzb on 2017/11/17.
 */
@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

//    public static MainActivityComponent getInstance(){
//        if (sComponent == null){
//            sComponent = DaggerMainActivityComponent.builder().build();
//        }
//        return sComponent;
//    }

    Activity activity();
//    IPDAO provideIpDao();
}
