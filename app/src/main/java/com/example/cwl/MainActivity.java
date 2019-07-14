package com.example.cwl;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.cwl.base.BaseActivity;
import com.example.cwl.base.BaseFragmentActivity;
import com.example.cwl.myapplication.R;
import com.example.cwl.ui.custom.SwitchNightRelativeLayout;
import com.example.cwl.ui.fragment.BookShelfFragment;
import com.example.cwl.util.CToast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseFragmentActivity {
    @Bind(R.id.btn_home)
    Button mHome;
    @Bind(R.id.btn_bookshelf)
    Button mBookShelf;
    @Bind(R.id.btn_mine)
    Button mMine;
    @Bind(R.id.rl_switch_night)
    SwitchNightRelativeLayout mSwitchNight;

    BookShelfFragment bookShelfFragment;

    @Override
    protected void initView() {
        mHome.setBackgroundResource(R.drawable.homepage_press);
        fragments = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        bookShelfFragment= (BookShelfFragment) fragmentManager.findFragmentById(R.id.fm_bookshelf);
        fragments.add (fragmentManager.findFragmentById(R.id.fm_home));
        fragments.add (bookShelfFragment);
        fragments.add (fragmentManager.findFragmentById(R.id.fm_mine));
//        mEditBottom.setListener(new FloatEditLayout.onClickListener() {
//            @Override
//            public void OnClickSelect() {
//                bookShelfFragment.OnClickSelect();
//            }
//
//            @Override
//            public void OnDelete() {
//                bookShelfFragment.OnClickDelete();
//            }
//        });
        selectTab(0);

        CheckVersion();

    }

    private void CheckVersion() {
    }
    @OnClick(R.id.btn_home)
    public void toHomeFragment(View view){
        selectTab(0);
        resetBottomBtn();
        mHome.setBackgroundResource(R.drawable.homepage_press);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initStatusBar(true);
        }
    }

    @OnClick(R.id.btn_bookshelf)
    public void toBookShelfFragment(View view){
        selectTab(1);
        resetBottomBtn();
        mBookShelf.setBackgroundResource(R.drawable.bookshelf_press);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initStatusBar(false);
        }
    }

    @OnClick(R.id.btn_mine)
    public void toMineFragment(View view){
        selectTab(2);
        resetBottomBtn();
        mMine.setBackgroundResource(R.drawable.mine_press);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initStatusBar(false);
        }
    }
    private void resetBottomBtn(){
        mHome.setBackgroundResource(R.drawable.homepage);
        mMine.setBackgroundResource(R.drawable.mine);
        mBookShelf.setBackgroundResource(R.drawable.bookshelf);
    }
    public void setSwitchNightVisible(int visible,boolean isNight){
        mSwitchNight.setVisibility(visible,isNight);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (CToast.isShowToast()){
                CToast.clearToast();  //在程序退出前需要清空吐司 防止CToast占用的内存还未释放
                return super.onKeyDown(keyCode, event);
            }else {
                CToast.makeText(MainActivity.this,getString(R.string.press_exit),1000).show();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
