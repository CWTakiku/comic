package com.example.cwl.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cwl.MainActivity;
import com.example.cwl.common.view.ZElasticRefreshScrollView;
import com.example.cwl.mvp.BaseMvpFragment;
import com.example.cwl.myapplication.R;
import com.example.cwl.presenter.HomePresenter;
import com.example.cwl.ui.custom.NoScrollGridLayoutManager;
import com.example.cwl.ui.view.IHomeView;
import com.example.cwl.util.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/9
 */
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements IHomeView {
    @Bind(R.id.iv_loading_top)
    ImageView ivLoadingTop;
    @Bind(R.id.tv_loading)
    TextView tvLoading;
    @Bind(R.id.rl_loading)
    RelativeLayout rlLoading;
    @Bind(R.id.ll_category1)
    LinearLayout llCategory1;
    @Bind(R.id.ll_category2)
    LinearLayout llCategory2;
    @Bind(R.id.ll_category3)
    LinearLayout llCategory3;
    @Bind(R.id.ly_meun)
    LinearLayout lyMeun;
    @Bind(R.id.recycle_view)
    RecyclerView mRecycleView;
    @Bind(R.id.B_banner)
    Banner mBanner;
    @Bind(R.id.tv_recent)
    TextView tvRecent;
    @Bind(R.id.iv_recent)
    ImageView ivRecent;
    @Bind(R.id.rl_recent)
    RelativeLayout rlRecent;
    @Bind(R.id.sv_comic)
    ZElasticRefreshScrollView svComic;
    @Bind(R.id.v_actionbar_bg)
    View vActionbarBg;
    @Bind(R.id.tv_hometitle1)
    TextView tvHometitle1;
    @Bind(R.id.tv_hometitle2)
    TextView tvHometitle2;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.rl_actionbar)
    RelativeLayout rlActionbar;
    @Bind(R.id.iv_error_bg)
    ImageView ivErrorBg;
    @Bind(R.id.iv_error)
    ImageView ivError;
    @Bind(R.id.rl_error_view)
    RelativeLayout rlErrorView;

    private MainActivity activity;

    @Override
    protected void initPresenter() {
        mPresenter = new HomePresenter();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        activity= (MainActivity) getActivity();
        mBanner.setImageLoader(new GlideImageLoader());
        NoScrollGridLayoutManager layoutManager = new NoScrollGridLayoutManager(getActivity(),6);
        layoutManager.setScrollEnabled(false);
        mRecycleView.setLayoutManager(layoutManager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void appendMoreDataToView(List data) {

    }

    @Override
    public void hasNoMoreData() {

    }

    @Override
    public void showErrorView(String throwable) {

    }

    @Override
    public void fillData(List data) {

    }

    @Override
    public void getDataFinish() {

    }

    @Override
    public void onRefreshFinish() {

    }

    @Override
    public void fillBanner(List data) {

    }

    @Override
    public void fillRecent(String str) {

    }
}
