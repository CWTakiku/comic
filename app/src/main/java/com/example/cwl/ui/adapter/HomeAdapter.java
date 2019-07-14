package com.example.cwl.ui.adapter;

import android.content.Context;

import com.example.cwl.entity.Comic;
import com.example.cwl.ui.adapter.base.BaseRecyclerAdapter;
import com.example.cwl.ui.adapter.base.BaseRecyclerHolder;

import java.util.List;

/**
 * author:chengwl
 * Description:
 * Date:2019/7/3
 */
public class HomeAdapter extends BaseRecyclerAdapter<Comic> {

    public HomeAdapter(Context context, int itemLayoutId) {
        super(context, itemLayoutId);
    }


    @Override
    public void convert(BaseRecyclerHolder holder, Comic item, int position) {

    }
}
