package com.mikk.bilibili.module.entry;

import android.os.Bundle;

import com.mikk.bilibili.R;
import com.mikk.bilibili.base.RxLazyFragment;

/**
 * Created by Mikk on 2017/5/12.
 */

public class IFavoritesFragment extends RxLazyFragment {


    public static IFavoritesFragment newInstance() {
        return new IFavoritesFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    public void finishCreateView(Bundle state) {

    }
}
