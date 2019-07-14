package com.example.cwl.ui.custom;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cwl.base.logger.Logger;
import com.example.cwl.base.logger.LoggerUtil;
import com.example.cwl.base.util.ViewCommonUtils;
import com.example.cwl.myapplication.R;

/**
 * author:chengwl
 * Description:吐司布局
 * Date:2019/6/28
 */
public class ToastLayout extends RelativeLayout {

    private static final int  ANIMATION_TIME = 200;
    private TextView mContent;
    private View view;
    private boolean isShow;
    private RelativeLayout mWrapper;
    private ImageView mIcon;
    private int height;

    public ToastLayout(Context context) {
        this(context,null);
    }

    public ToastLayout(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public ToastLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = LayoutInflater.from(getContext()).inflate(R.layout.layout_toast, null);
        addView(view);
        mContent = (TextView) view.findViewById(R.id.tv_content);
        mWrapper=view.findViewById(R.id.rl_toast);
        mIcon=view.findViewById(R.id.iv_icon);
        height=60;
    }

    public void setContent(String content) {
      if (mContent!=null){
          mContent.setText(content);
      }
    }
    public void setTextColor(int color){
        if (mContent!=null){
            mContent.setTextColor(color);
        }
    }
    public void setBgColor(int color){
        if (mWrapper!=null){
            mWrapper.setBackgroundColor(color);
        }
    }
    public void setIcon(int resId){
        mIcon.setImageResource(resId);
    }
    public void setIconVisible(boolean isVisible){
        if (mIcon==null){
            return;
        }
        if (isVisible){
            mIcon.setVisibility(VISIBLE);
        }else {
            mIcon.setVisibility(GONE);
        }
    }
    public void setHeight(final int viewHeight){
       if (mWrapper!=null){
           RelativeLayout.LayoutParams layoutParams= (LayoutParams) mWrapper.getLayoutParams();
           layoutParams.height=dp2px(getContext(),viewHeight);
           height=viewHeight;
           mWrapper.setLayoutParams(layoutParams);
       }
    }
    public void showToast(long time){
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation trans1 = new TranslateAnimation(0, 0 ,-dp2px(getContext(),height) ,0);
        TranslateAnimation trans2 = new TranslateAnimation(0,0 , 0 , -dp2px(getContext(),height));
        trans1.setDuration(ANIMATION_TIME);
        trans2.setStartOffset(ANIMATION_TIME+time);
        trans2.setDuration(ANIMATION_TIME);
        animationSet.addAnimation(trans1);
        animationSet.addAnimation(trans2);
        this.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isShow = true;
                ToastLayout.this.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isShow = false;
                ToastLayout.this.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public boolean isShow() {
        return isShow;
    }

    private int dp2px(Context context,float dipValue){
        float density=context.getResources().getDisplayMetrics().density;
        return (int)(dipValue*density+0.5f);
    }
}
