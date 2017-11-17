package com.example.zzb.aac.dragger;

import android.app.Application;
import android.content.Context;

import com.example.zzb.aac.MainActivity;
import com.example.zzb.aac.MyAppliaction;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by HP on 2017/11/16.
 */
@Singleton
@Component(modules = {
        AppModule.class})
public interface AppComponent {
//    Context getContext();
    void inject(MyAppliaction app);
//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        Builder application(Application application);
//        AppComponent build();
//    }
//    Context context();  // 提供Applicaiton的Context
//
//    ThreadPoolExecutor threadPoolExecutor();
//
//    Application getApplication();

//    ApiService getService();
//
}
