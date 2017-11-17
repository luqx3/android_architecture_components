package com.example.zzb.aac.repository;

import android.content.Context;

import com.example.zzb.aac.common.IpDataSource;

/**
 * Created by zzb on 2017/11/17.
 */

public class LocalIpDataSource implements IpDataSource {
    private final IPDAO ipdao;
    public LocalIpDataSource(IPDAO ipdao){
        this.ipdao=ipdao;

    }
    @Override
    public void insertOrUpdate(IP ip) {

    }
}
