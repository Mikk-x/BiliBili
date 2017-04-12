package com.mikk.bilibili.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mikk.bilibili.base.BaseFragment;

/**
 * Created by Mikk on 2017/4/10.
 */

public class FenQuFragment extends BaseFragment {


    public static final String MIKK = FenQuFragment.class.getSimpleName();
    private TextView textView;

    @Override
    protected View initView() {
        Log.i(MIKK,"分区Fragment页面被初始化了...");
        // 父类的上下文
        textView = new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.i(MIKK,"分区Fragment页面被初始化了...");
        textView.setText("分区页面");
    }
}
