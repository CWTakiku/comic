package com.example.cwl.ui.custom;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/**
 * author:chengwl
 * Description:
 * Date:2019/6/29
 */
public class NoScrollGridLayoutManager extends GridLayoutManager{
    private boolean isScrollEnabled = true;
    public NoScrollGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }
 public void setScrollEnabled(boolean flag){
        isScrollEnabled=false;
 }
    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled&&super.canScrollVertically();
    }
}
