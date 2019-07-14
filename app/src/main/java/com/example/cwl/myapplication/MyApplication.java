package com.example.cwl.myapplication;

import android.app.Application;

import com.example.cwl.db.manager.DaoManager;
import com.orhanobut.hawk.Hawk;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/6
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
        //初始化数据库
        DaoManager.getInstance(this.getApplicationContext());
    }
}
