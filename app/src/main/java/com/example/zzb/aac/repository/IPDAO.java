package com.example.zzb.aac.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by zzb on 2017/11/15.
 */
@Dao
public interface IPDAO {
    @Query("select * from IP")
    LiveData<List<IP>> getIPList();

    @Query("select * from IP where Ip=:ip")
    LiveData<IP> getIPbyid(String ip);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIP(IP ip);

    @Query("select exists(select * from IP where Ip=:ip);")
    int findIP(String ip);

    @Query("select count(*) from IP ")
    int getSize();
}
