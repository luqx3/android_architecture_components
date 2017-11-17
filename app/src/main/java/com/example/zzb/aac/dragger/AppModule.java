package com.example.zzb.aac.dragger;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.zzb.aac.net.HttpClient;
import com.example.zzb.aac.net.IpAPI;
import com.example.zzb.aac.repository.MyIPDB;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 2017/11/16.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApplication;
    }

    @Provides
    Context applicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    MyIPDB providesMyIPDB(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), MyIPDB.class, "my_ip_db").build();
    }

    @Singleton
    @Provides
    IpAPI provideIpAPI() {
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .baseUrl(HttpClient.BaseIPUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build()
                .create(IpAPI.class);
    }

}
