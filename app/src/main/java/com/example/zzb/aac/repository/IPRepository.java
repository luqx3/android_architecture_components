package com.example.zzb.aac.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.example.zzb.aac.MainActivity;
import com.example.zzb.aac.common.IPData;
import com.example.zzb.aac.net.BaseSubscriber;
import com.example.zzb.aac.net.HttpClient;
import com.example.zzb.aac.net.IpAPI;
import com.example.zzb.aac.net.OnSubscriberListener;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by zzb on 2017/11/15.
 */
@Singleton
public class IPRepository extends HttpClient {
    private final String token="91512cf1f06256d18786aaf33642e415";
    private final String jsonp="jsonp";
    private IpAPI ipAPI;
    private static IPDAO ipdao;
    private Executor executor;
    private static IPRepository sInstance;

    public void init(Context context){
        MyIPDB database = MyIPDB.getInstance(context);
        ipdao=database.ipDao();
    }

    private IPRepository(Context context){

        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        retrofit=new Retrofit.Builder()
                .baseUrl(BaseIPUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient)
                .build();
        ipAPI=retrofit.create(IpAPI.class);
        ipdao=MyIPDB.getInstance(context).ipDao();
    }
    public static IPRepository getInstance(Context context){
        if (sInstance == null) {
            synchronized (IPRepository.class) {
                if (sInstance == null) {
                    sInstance = new IPRepository(context);

                }
            }
        }
        return sInstance;

    }
    public LiveData<IP> getIp(String IP){
        refreshData(IP);
        return ipdao.getIPbyid(IP);
    }
    public LiveData<List<IP>> getAllFromDB(){
        return ipdao.getIPList();
    }
    private void refreshData(final String ip){
        int isIpExist=0;
        if(isIpExist==0){
            BaseSubscriber<IPData> subscriber2=new BaseSubscriber<>(new OnSubscriberListener<IPData>() {
                @Override
                public void onSuccess(IPData data) {
                    if(data.getData()!=null){
                        DatabaseManager.getInstance().insertIP(ipdao,new IP(ip,data.getData()));
                    }
                }
                @Override
                public void onChanged(String status) {
                    Log.i("status",status);

                }
            });
            subscribe(ipAPI.get(ip,jsonp,token),subscriber2);
        }


    }
}
