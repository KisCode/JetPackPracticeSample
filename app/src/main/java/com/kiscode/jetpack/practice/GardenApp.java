package com.kiscode.jetpack.practice;

import android.app.Application;

import com.kiscode.jetpack.practice.data.AppDatabase;

/**
 * Description: 根据Google sunFlower项目改造
 * Author: keno
 * Date : 2021/3/16 16:37
 **/
public class GardenApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据库
        AppDatabase.init(this);
    }
}