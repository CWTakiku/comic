package com.example.cwl;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.cwl.base.BaseActivity;
import com.example.cwl.base.WeakRefHandler;
import com.example.cwl.base.logger.LoggerUtil;
import com.example.cwl.base.util.Constant;
import com.example.cwl.common.glide.GlideCacheUtil;
import com.example.cwl.constant.Constants;
import com.example.cwl.myapplication.R;
import com.example.cwl.util.IntentJumpUtil;
import com.orhanobut.hawk.Hawk;
import com.qw.soul.permission.SoulPermission;
import com.qw.soul.permission.bean.Permission;
import com.qw.soul.permission.bean.Permissions;
import com.qw.soul.permission.callbcak.CheckRequestPermissionListener;
import com.qw.soul.permission.callbcak.CheckRequestPermissionsListener;

import java.util.Date;




/**
 * author:chengwl
 * Description:
 * Date:2019/6/27
 */
public class WelcomeActivity extends BaseActivity {

    private WeakRefHandler mHandler;
    private Handler.Callback mCallback;
    private Context context;
    @Override
    protected int getLayout() {

        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        context=this;
        mCallback=new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what==1){
                    finish();
                    IntentJumpUtil.gotoMainActivity((Activity) context);
                }
                return true;
            }
        };
        mHandler=new WeakRefHandler(mCallback);
        mHandler.sendEmptyMessageDelayed(1,2000);
        SoulPermission.getInstance().checkAndRequestPermissions(Permissions.build(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), new CheckRequestPermissionsListener() {
            @Override
            public void onAllPermissionOk(Permission[] allPermissions) {
             init();
            }

            @Override
            public void onPermissionDenied(Permission[] refusedPermissions) {
                hint();
            }
        });
    }


        private void hint () {
            LoggerUtil.showToastShort(this, getString(R.string.open_read_permission_hint));
        }




        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
        }
    //缓存处理
    private void init() {
        long lasttime = Hawk.get(Constants.LAST_START_TIME,0L);
        if (lasttime!=0&&(getCurrentTime()-lasttime)>24*60*60*1000*Constants.CACHE_DAYS){
            GlideCacheUtil.getInstance().clearImageAllCache(this);
            LoggerUtil.logInfo("距离上次启动大于一天，清除缓存");
        }else {
            LoggerUtil.logInfo("距离上次启动小于于一天，不清除缓存");
        }
        Hawk.put(Constants.LAST_START_TIME,getCurrentTime());
    }
    private long getCurrentTime(){
        Date date=new Date();
        long time=date.getTime();
        return time;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler=null;
    }
}
