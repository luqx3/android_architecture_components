package com.example.zzb.aac.common;

import android.content.Context;

import com.example.zzb.aac.repository.LocalIpDataSource;
import com.example.zzb.aac.repository.MyIPDB;

/**
 * Created by zzb on 2017/11/17.
 */

public class Injection {
    public static IpDataSource provideIpDataSource(Context context){
        MyIPDB ipDB=MyIPDB.getInstance(context);
        return new LocalIpDataSource(ipDB.ipDao());

    }
}
