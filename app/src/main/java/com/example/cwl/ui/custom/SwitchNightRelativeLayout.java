package com.example.cwl.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.cwl.base.util.ViewCommonUtils;
import com.example.cwl.myapplication.R;

/**
 * author:chengWL
 * Description:切换日夜间模式
 * Date:2019/6/28
 */
public class SwitchNightRelativeLayout extends RelativeLayout {
    private ImageView mImageView;
    private View view;
    private Context mContext;
    public SwitchNightRelativeLayout(Context context) {
        this(context,null);
    }

    public SwitchNightRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public SwitchNightRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext= context;
        view = LayoutInflater.from(getContext()).inflate(R.layout.layout_switch_night, this,true);
        mImageView = (ImageView) view.findViewById(R.id.tv_icon);
    }
    public void setVisibility(int visibility,boolean isNight){
        int id=0;
        if (isNight){
            id=R.drawable.icon_switch_night;
        }else {
            id=R.drawable.icon_switch_day;
        }
        switch (visibility){
            case VISIBLE:
                AnimationSet animationSet=new AnimationSet(true);
                AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
                alphaAnimation.setDuration(300);
                TranslateAnimation translateAnimation=new TranslateAnimation(0,0,
                        ViewCommonUtils.getScreenHeight(getContext())/2,0);
                translateAnimation.setDuration(300);
                int pivotType= Animation.RELATIVE_TO_SELF;
                float pivotX=.5f;
                float pivotY=.5f;
                int rotate=0;
                if (!isNight){
                    rotate=-120;//旋转的结束角度
                }
                RotateAnimation rotateAnimation=new RotateAnimation(0,rotate,pivotType,pivotX,pivotType,pivotY);
                rotateAnimation.setDuration(1000);
                rotateAnimation.setStartOffset(300);//延迟执行
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(rotateAnimation);

                mImageView.setImageResource(id);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                mImageView.startAnimation(animationSet);
                break;
            case GONE:
                setVisibility(GONE);
                break;
            case INVISIBLE:
                setVisibility(INVISIBLE);
                break;
        }
    }

}
