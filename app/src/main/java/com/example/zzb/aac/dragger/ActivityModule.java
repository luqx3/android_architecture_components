package com.example.zzb.aac.dragger;

import android.app.Activity;

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
//    @ActivityScope
    Activity activity() {
        return this.activity;
    }
//    @Provides
//    @PerActivity
//    ILoginActivity provideILoginActivity() {
//        return (LoginActivity) this.activity;
//    }
}
