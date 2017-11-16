package com.example.zzb.aac.viewmodle;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.example.zzb.aac.repository.IP;
import com.example.zzb.aac.repository.IPRepository;

import java.util.List;

/**
 * Created by zzb on 2017/11/16.
 */

public class IPViewModle extends ViewModel {
    Context context;
    LiveData<IP> ip;
    public ObservableField<String> ipString = new ObservableField<>();
    public ObservableField<String> ipinfo = new ObservableField<>();
    public IPViewModle(){
    }
    public void setContext(Context context){
        this.context=context;
        ipinfo.set("1.1.1.1");
        ipString.set("");
    }
    public IPViewModle(Context context){
        this.context=context;
        ipinfo.set("");
        ipString.set("");
    }
    public LiveData<IP> searchbyIP(String ipS){
        ip=IPRepository.getInstance(context).getIp(ipS);
        return ip;
    }

    public LiveData<List<IP>> searchall(){
        return IPRepository.getInstance(context).getAllFromDB();
    }

    public LiveData<IP> getip(){
//        if(ip==null){
            ip=IPRepository.getInstance(context).getIp(ipString.get());
            if(ip==null&&ip.getValue()!=null){
                ipinfo.set(ip.getValue().getCountry()==null?"null":ip.getValue().getCountry());
            }
//        }
        return ip;
    }

    public void setIP(View view){
        getip();
    }

}