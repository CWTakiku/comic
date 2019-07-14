package com.example.cwl.presenter;

import android.os.Bundle;

import com.example.cwl.mvp.BasePresenter;
import com.example.cwl.ui.view.IBookShelfView;
import com.example.cwl.ui.view.IHomeView;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/9
 */
public class BookShelfPresenter extends BasePresenter<IBookShelfView> {
    @Override
    public void onMvpSaveInstanceState(Bundle savedInstanceState) {

    }


    @Override
    public void onMvpDestroy() {

    }
}
