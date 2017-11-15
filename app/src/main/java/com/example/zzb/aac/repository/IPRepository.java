package com.example.zzb.aac.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.example.zzb.aac.net.HttpClient;
import com.example.zzb.aac.net.IpAPI;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * Created by zzb on 2017/11/15.
 */
@Singleton
public class IPRepository extends HttpClient {
    private final String token="91512cf1f06256d18786aaf33642e415";
    private final String jsonp="jsonp";
    private IpAPI ipAPI;
    private IPDAO ipdao;
    private Executor executor;

    public void init(Context context){
        MyIPDB database = MyIPDB.getInstance(context);
        ipdao=database.ipDao();
    }

    public IPRepository(){

        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        retrofit=new Retrofit.Builder()
                .baseUrl(BaseIPUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        ipAPI=retrofit.create(IpAPI.class);
    }
    public LiveData<IP> getIp(String IP){
        refreshData(IP);
        return ipdao.getIPbyid(IP);
    }
    private void refreshData(String ip){
        boolean isIpExist=false;
        if(!isIpExist){
//            ipAPI.get(ip, jsonp, token).subscribe(new S)
            subscribe(ipAPI.get(ip, jsonp, token), new Subscriber() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    Log.i("OnError",e.toString());
                }

                @Override
                public void onNext(Object o) {
                    Log.i(o.toString(),o.toString());
                }
            });
        }

    }
}
