package com.example.cwl.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.cwl.MainActivity;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/27
 */
public class IntentJumpUtil {
    public static void gotoMainActivity(Activity context){
        Intent intent=new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
