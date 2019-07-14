package com.example.cwl.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cwl.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/9
 */
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment {
    protected P mPresenter;
    protected abstract void initPresenter();
    protected abstract void initView(View view, Bundle savedInstanceState);

    //获取布局文件ID
    protected abstract int getLayoutId();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initPresenter();
        checkPresenterIsNull();
        initView(view, savedInstanceState);
        return view;
    }
    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter!=null){
            mPresenter.onMvpDetachView(false);
        }
    }


}
