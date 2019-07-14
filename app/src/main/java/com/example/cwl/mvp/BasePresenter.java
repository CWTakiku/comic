package com.example.cwl.mvp;

import android.os.Bundle;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    //View接口类型的软引用
    protected Reference<V> mViewRef;

    public void attachView(V view){
        mViewRef=new SoftReference<V>(view);
    }
    protected V getView(){
        return mViewRef.get();
    }
    public boolean isViewAttached(){
        return mViewRef!=null&&mViewRef.get()!=null;
    }
    public void detachView(){
        if (mViewRef!=null){
            mViewRef.clear();
        }
    }
    @Override
    public void onMvpAttachView(V view, Bundle savedInstanceState) {
      attachView(view);
    }
    @Override
    public void onMvpStart() {

    }

    @Override
    public void onMvpDetachView(boolean retainInstance) {
        detachView();
    }

    @Override
    public void onMvpResume() {

    }

    @Override
    public void onMvpPause() {

    }

    @Override
    public void onMvpStop() {

    }
}
