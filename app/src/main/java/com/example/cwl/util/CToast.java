package com.example.cwl.util;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.cwl.base.logger.LoggerUtil;
import com.example.cwl.base.util.ViewCommonUtils;
import com.example.cwl.myapplication.R;
import com.example.cwl.ui.custom.ToastLayout;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/28
 */
public class CToast  {
    private Activity mActivity;
    private RelativeLayout mToastLayout;
    private ToastLayout mToast;
    private ViewGroup mView;
    private String text;
    private long times;
    private static CToast mToastInstance;

    private static int iconResID;
    private static int textColor;
    private static int bgColor;
    private static boolean isShowIcon;
    private static int height=60;

    public CToast(Activity mActivity,String text,long times){
        this.mActivity = mActivity;
        this.text = text;
        this.times = times;
    }

    public CToast(ViewGroup mView,String text,long times){
        this.mView = mView;
        this.text = text;
        this.times = times;
    }

    public static CToast makeText(Activity mActivity,String text,long times){
        mToastInstance = new CToast(mActivity,text,times);
        return mToastInstance;
    }

    public static CToast makeText(ViewGroup mView,String text,long times){
        mToastInstance = new CToast(mView,text,times);
        return mToastInstance;
    }

    /**
     *
     * @param BgColor 背景颜色
     * @param TextColor 文字颜色
     * @param isIcon 是否展示icon
     * @param iconResId icon ID
     * @param height 高度
     */
       public static void init(int BgColor, int TextColor, boolean isIcon,int iconResId,int height){
              CToast.bgColor = BgColor;
              CToast.textColor = TextColor;
              CToast.isShowIcon = isIcon;
              CToast.height = height;
              CToast.iconResID = iconResId;
       }


    public static void setIcon(int resId){
        iconResID=resId;
    }
    public static void setTextColor(int color){
        textColor=color;
    }
    public static void setBgColor(int color){
        bgColor=color;
    }
    public static void setIsShowIcon(boolean isShow){
        isShowIcon=isShow;
    }
    public static void setHeight(int height_dp){
           CToast.height=height_dp;
    }

    public void show(){
        if(mActivity!=null){
            mToastLayout = (RelativeLayout) mActivity.findViewById(R.id.rl_toast);
            if(mToastLayout==null){//判断是否已经添加进母VIEW里，没有则添加进去
                mToast = new ToastLayout(mActivity);
                mActivity.addContentView(mToast,new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewCommonUtils.dipToPx(mActivity,height)));
            }else{//如果有，则直接取出
                mToast = (ToastLayout) mToastLayout.getParent();
            }
            applyConfig(mToast);
            mToast.setContent(text);
            mToast.showToast(times);
            return;
        }else if(mView!=null){
            mToastLayout = (RelativeLayout) mView.findViewById(R.id.rl_toast);
            if(mToastLayout==null){
                mToast = new ToastLayout(mView.getContext());
                mView.addView(mToast,new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewCommonUtils.dipToPx(mView.getContext(),height)));
            }else{
                mToast = (ToastLayout) mToastLayout.getParent();
            }
            applyConfig(mToast);
            mToast.setContent(text);
            mToast.showToast(times);
        }

    }
    private void applyConfig(ToastLayout toastLayout){
        if (bgColor!=0){
            toastLayout.setBgColor(bgColor);
        }
        if (textColor!=0){
            toastLayout.setTextColor(textColor);
        }
        if (iconResID!=0){
            toastLayout.setIcon(iconResID);
        }
        if (height!=60){
            toastLayout.setHeight(height);
        }
       toastLayout.setIconVisible(isShowIcon);

    }
    public static boolean isShowToast(){
        if(mToastInstance==null||mToastInstance.mToast == null){
            return false;
        }
        return  mToastInstance.mToast.isShow();
    }
    //用于程序退出时清空吐司
    public static void clearToast(){
        if (mToastInstance!=null){
            mToastInstance=null;
        }
    }
}
