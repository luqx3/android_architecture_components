package com.example.zzb.aac.dragger;

import com.example.zzb.aac.MainActivity;

import dagger.Component;

/**
 * Created by HP on 2017/11/16.
 */
//@ActivityScope
@Component(modules = ActivityModule.class)
public abstract class MainActivityComponent {
    private static MainActivityComponent sComponent;
    abstract void inject(MainActivity activity);

    public static MainActivityComponent getInstance(){
        if (sComponent == null){
            sComponent = DaggerMainActivityComponent.builder().build();
        }
        return sComponent;
    }


//    MainActivityHelper getMainActivityHelper();
//
//    TestDao getTestDao();
}
