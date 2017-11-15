package com.example.zzb.aac.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

/**
 * Created by zzb on 2017/11/15.
 */
@Database(entities = {IP.class},version = 1)
public abstract class MyIPDB extends RoomDatabase {
    private static final String DB_NAME = "lexing-db";
    private static volatile MyIPDB INSTANCE;
    public abstract IPDAO ipDao();
    public static MyIPDB getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyIPDB.class) {
                if (INSTANCE == null) {
                    Log.e("Vehicle", "start init database");
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyIPDB.class, DB_NAME)
                            .build();
                    Log.e("Vehicle", "init database success");
                }
            }
        }
        return INSTANCE;
    }
}
