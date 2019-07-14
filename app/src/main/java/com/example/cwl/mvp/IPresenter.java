package com.example.cwl.mvp;

import android.os.Bundle;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/5
 */
public interface IPresenter<V extends IBaseView> {
    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpSaveInstanceState(Bundle savedInstanceState);

    void onMvpDetachView(boolean retainInstance);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpDestroy();
}
