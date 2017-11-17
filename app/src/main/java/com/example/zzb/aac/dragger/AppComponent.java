package com.example.zzb.aac.dragger;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.zzb.aac.MyApplication;
import com.example.zzb.aac.net.IpAPI;
import com.example.zzb.aac.repository.MyIPDB;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

/**
 * Created by HP on 2017/11/16.
 */
@Singleton
@Component(modules = {
        AppModule.class})
public interface AppComponent {
    Context getContext();
    void inject(MyApplication app);



    IpAPI  getIpAPI();

    MyIPDB getMyIPDB();
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
