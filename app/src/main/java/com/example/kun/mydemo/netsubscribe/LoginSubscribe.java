package com.example.kun.mydemo.netsubscribe;

import com.example.kun.mydemo.model.ContentBean;

import com.example.kun.mydemo.model.ResultContent;
import com.example.kun.mydemo.model.TokenBean;
import com.example.kun.mydemo.model.UserBean;
import com.example.kun.mydemo.model.UserInfo;
import com.example.kun.mydemo.model.req.DataReqBean;
import com.example.kun.mydemo.model.req.NewRepairBean;
import com.example.kun.mydemo.model.req.UpdateBean;
import com.example.kun.mydemo.netutils.RetrofitFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Body;

/**
 * Created by 眼神 on 2018/3/27.
 * 建议：把功能模块来分别存放不同的请求方法，比如登录注册类LoginSubscribe、电影类MovieSubscribe、天气类WeatherSubscribe
 */

public class LoginSubscribe {

    /**
     * @Query
     */
    public static void loginQueryData(UserBean user, DisposableObserver<TokenBean> subscriber) {
        Observable<TokenBean> observable =  RetrofitFactory.getInstance().getHttpApi().login(user);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }
    /*
    获取用户信息
     */
    public static void getUserInfo(String sno,DisposableObserver<UserInfo> subscriber){
        Observable<UserInfo> observable =  RetrofitFactory.getInstance().getHttpApi().getInfoForSno(sno);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }
    /*
    获取全部维修信息
     */
    public static void getDataList(int page, DataReqBean dq, DisposableObserver<ResultContent> subscriber){
        Observable<ResultContent> observable =  RetrofitFactory.getInstance().getHttpApi().getDataList(page,dq);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

    /*
    更新
     */
    public static void updateData(UpdateBean ub, DisposableObserver<ResponseBody> subscriber){
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().updateData(ub);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

    /*
    添加
     */
    public static void newRepair(String uid ,  NewRepairBean nr , DisposableObserver<ResponseBody> subscriber){
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().newRepair(uid,nr);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

}
