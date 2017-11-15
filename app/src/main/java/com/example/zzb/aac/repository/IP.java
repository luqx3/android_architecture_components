package com.example.zzb.aac.repository;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zzb on 2017/11/15.
 */
@Entity
public class IP {
    @PrimaryKey
    private String Ip;
    private String Country;
    private String Provincial;
    private String City;
    private String Operator;

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvincial() {
        return Provincial;
    }

    public void setProvincial(String provincial) {
        Provincial = provincial;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getOperator() {
        return Operator;
    }

    public void setOperator(String operator) {
        Operator = operator;
    }

    //private String Msg="";

}
