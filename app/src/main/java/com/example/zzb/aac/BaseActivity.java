package com.example.zzb.aac;

import android.app.Application;
import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zzb.aac.dragger.ActivityComponent;
import com.example.zzb.aac.dragger.ActivityModule;
import com.example.zzb.aac.dragger.AppComponent;
import com.example.zzb.aac.dragger.AppModule;
import com.example.zzb.aac.dragger.DaggerActivityComponent;
import com.example.zzb.aac.dragger.DaggerAppComponent;
import com.example.zzb.aac.dragger.DaggerFragmentComponet;
import com.example.zzb.aac.dragger.FragmentComponet;
import com.example.zzb.aac.dragger.FragmentModule;

/**
 * Created by zzb on 2017/11/17.
 */

public class BaseActivity extends LifecycleActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        // Dagger2 依赖注入，放在onCreate()前
//        AndroidInjection.inject(this);
//        super.onCreate(savedInstanceState);
//    }
    protected FragmentComponet fragmentComponet;

    public ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    public AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule((MyApplication) getApplicationContext()))
                .build();
    }
    public FragmentComponet getComponent() {
        return DaggerFragmentComponet.builder()
                .activityModule(getActivityModule())
                .fragmentModule(getFragment())
                .build();
    }
    public FragmentModule getFragment(){
        return new FragmentModule();
    }


}
