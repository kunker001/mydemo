package com.example.kun.mydemo.utils;

import android.content.SharedPreferences;

import com.example.kun.mydemo.MyApp;

public class SpMap {

    //存储token
    public static void setToken(String token){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        sp.edit().putString("token",token).commit();
    }
    //存储过期时间
    public static void setn(long timed){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        sp.edit().putLong("timed",timed).commit();
    }
    //存储身份类型
    public static void setRole(int role){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        sp.edit().putInt("role",role).commit();
    }


    //获取token
    public static String getToken(){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        return sp.getString("token","");
    }
    //存储过期时间
    public static long getTimed(){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        return sp.getLong("timed",0);
    }
    //存储身份类型
    public static int getRole(){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        return sp.getInt("role",-1);
    }

    public static String gEt(String name){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        return sp.getString(name,"");
    }

    public static void sEt(String name,String value){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        sp.edit().putString(name,value).commit();
    }

    public  static void clear(){
        SharedPreferences sp = MyApp.getConText().getSharedPreferences("config",0);
        sp.edit().putString("token","").putLong("timed",0).putInt("role",-1).commit();
    }
}
