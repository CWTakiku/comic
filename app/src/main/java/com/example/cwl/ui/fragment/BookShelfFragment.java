package com.example.cwl.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.cwl.mvp.BaseMvpFragment;
import com.example.cwl.myapplication.R;
import com.example.cwl.presenter.BookShelfPresenter;
import com.example.cwl.ui.view.IBookShelfView;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/9
 */
public class BookShelfFragment extends BaseMvpFragment<BookShelfPresenter> implements IBookShelfView {
    @Override
    protected void initPresenter() {
    mPresenter=new BookShelfPresenter();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book;
    }
}
