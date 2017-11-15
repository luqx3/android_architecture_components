package com.example.zzb.aac.net;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zzb on 2017/11/15.
 */

public interface DouBanAPI {
    /**
     * 获取图书信息
     * */
    @GET("/v2/book/:{id}")
    Observable<String> getBookById(@Query("id") String id);
    /**
     * 搜索图书
     * */
    @GET("/v2/book/search")
    Observable<String> booksearch(@Query("q") String q,
                           @Query("tag") String tag,
                           @Query("start") String start,
                           @Query("count") String count);
    /**
     * 取某个图书中标记最多的标签
     * */
    @GET("/v2/book/:{id}/tags")
    Observable<String> getBookTags(@Query("id") String id);
}
