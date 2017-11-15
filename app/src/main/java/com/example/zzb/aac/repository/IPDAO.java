package com.example.zzb.aac.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by zzb on 2017/11/15.
 */
@Dao
public interface IPDAO {
    @Query("select * from IP")
    LiveData<List<IP>> getIPList();

    @Query("select * from IP where Ip=:ip")
    LiveData<IP> getIPbyid(String ip);
}
