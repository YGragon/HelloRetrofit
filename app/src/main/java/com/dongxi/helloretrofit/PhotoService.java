package com.dongxi.helloretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface PhotoService {
    @GET("tnfs/api/news")
    Call<Tngou> getResult() ;

//    @GET("api/data/{Type}/10/1")//网址下面的子目录，Android表示分类，因为子目录只有一点不一样
//    Call<PhotoResult> getResult(@Path("Type") String type) ;
}
