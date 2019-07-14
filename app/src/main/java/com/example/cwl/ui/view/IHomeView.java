package com.example.cwl.ui.view;

import com.example.cwl.entity.BaseBean;
import com.example.cwl.mvp.IBaseView;

import java.util.List;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/9
 */
public interface IHomeView<T extends BaseBean> extends IBaseView {
    /**
     * 添加更多数据（用于刷新）
     * @param data
     */
    void appendMoreDataToView(List<T> data);

    /**
     * 没有更多
     */
    void hasNoMoreData();

    void showErrorView(String throwable);

    void fillData(List<T> data);

    void getDataFinish();

    void onRefreshFinish();

    void fillBanner(List<T> data);

    void fillRecent(String str);
}
