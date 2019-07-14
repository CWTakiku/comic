package com.example.cwl.db.manager;

import android.content.Context;

import com.example.cwl.constant.Constants;
import com.example.cwlgd.greendao.DaoMaster;
import com.example.cwlgd.greendao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * author:chengwl
 * Description:
 * Date:2019/7/3
 */
public class DaoManager {
    private static volatile DaoManager manager;
    private static DaoMaster.DevOpenHelper helper;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private Context mContext;

    private DaoManager(Context context){
        this.mContext=context.getApplicationContext();
    }
    public static DaoManager getInstance(Context context){
        if (manager==null){
            synchronized (DaoManager.class){
                if (manager==null){
                    manager=new DaoManager(context);
                }
            }
        }
        return manager;
    }

    public DaoMaster getDaoMaster(){
        if (daoMaster==null){
            helper=new DaoMaster.DevOpenHelper(mContext, Constants.DB_NAME,null);
            daoMaster=new DaoMaster(helper.getWritableDb());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
       if (daoSession==null){
           if (daoMaster==null){
               daoMaster=getDaoMaster();
           }
           daoSession=daoMaster.newSession();
       }
       return daoSession;
    }
    //输出日志
    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
    public void close() {
        closeHelper();
        closeSession();
    }
    public void closeHelper() {
        if (helper != null) {
            helper.close();
            helper = null;
        }
    }
    //关闭session
    public void closeSession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }
}
