package com.example.cwl.mvp;

import android.os.Bundle;

import com.example.cwl.base.BaseActivity;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/5
 */
public abstract class BaseMvpActivity<P extends IPresenter> extends BaseActivity implements IBaseView {
    protected P mPresenter;

    protected abstract P createPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        mPresenter.onMvpAttachView(this, savedInstanceState);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null) {
            mPresenter.onMvpStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onMvpResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onMvpPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null) {
            mPresenter.onMvpStop();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.onMvpSaveInstanceState(outState);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onMvpDetachView(false);
            mPresenter.onMvpDestroy();
        }
    }
}
