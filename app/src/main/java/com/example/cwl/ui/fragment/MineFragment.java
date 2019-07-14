package com.example.cwl.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.cwl.mvp.BaseMvpFragment;
import com.example.cwl.myapplication.R;
import com.example.cwl.presenter.MinePresenter;
import com.example.cwl.ui.view.IMineView;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/9
 */
public class MineFragment extends BaseMvpFragment<MinePresenter> implements IMineView {
    @Override
    protected void initPresenter() {
           mPresenter=new MinePresenter();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
