package com.example.kun.mydemo.netapi;

import com.example.kun.mydemo.model.BaseRequestBean;

import com.example.kun.mydemo.model.ResultContent;
import com.example.kun.mydemo.model.TokenBean;
import com.example.kun.mydemo.model.UserBean;
import com.example.kun.mydemo.model.UserInfo;
import com.example.kun.mydemo.model.req.DataReqBean;
import com.example.kun.mydemo.model.req.NewRepairBean;
import com.example.kun.mydemo.model.req.UpdateBean;


import io.reactivex.Observable;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 眼神 on 2018/3/27.
 * <p>
 * 存放所有的Api
 */

public interface HttpApi {

    //post 必须加上 @FormUrlEncoded标签，否则会抛异常。
    @Headers("Content-Type: application/json")
    @POST("login")
    Observable<TokenBean> login(@Body UserBean uinfo);

    @GET("user/queryBySno")
    Observable<UserInfo> getInfoForSno(@Query("sno") String sno);

    @Headers("Content-Type: application/json")
    @POST("repair/querylist")
    Observable<ResultContent> getDataList(@Query("page") int page , @Body DataReqBean dq);
    @POST("repair/update")
    Observable<ResponseBody> updateData( @Body UpdateBean ub);

    @POST("repair/create")
    Observable<ResponseBody> newRepair( @Query("userId") String uid , @Body NewRepairBean nr);

    @GET("api")
    Observable<ResponseBody> getWeatherDataForQuery(@Query("version") String version, @Query("city") String city);

    @GET("api")
    Observable<ResponseBody> getWeatherDataForMap(@QueryMap Map<String, String> map);


//
//    /**
//     * 文件下载
//     */
//    @GET()
//    @Streaming//使用Streaming 方式 Retrofit 不会一次性将ResponseBody 读取进入内存，否则文件很多容易OOM
//    Call<ResponseBody> downloadFile(@Url String fileUrl);//返回值使用 ResponseBody 之后会对ResponseBody 进行读取
}
