package com.example.zzb.aac.net;

import com.example.zzb.aac.common.HttpResult;
import com.example.zzb.aac.common.IPData;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zzb on 2017/11/15.
 */

public interface IpAPI {
    //http://api.ip138.com/query/?ip=8.8.8.8&datatype=jsonp&token=91512cf1f06256d18786aaf33642e415
    @Headers("Cache-Control:public ,max-age=2592000")
    @GET("query/")
    Observable<HttpResult<IPData>> get(@Query("ip") String ip, @Query("datatype") String datatype, @Query("token") String token);
}
