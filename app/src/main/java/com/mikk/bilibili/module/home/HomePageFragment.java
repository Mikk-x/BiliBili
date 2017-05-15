package com.mikk.bilibili.module.home;

import android.os.Bundle;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mikk.bilibili.R;
import com.mikk.bilibili.base.RxLazyFragment;

import butterknife.BindView;

/**
 * Created by Mikk on 2017/5/12.
 */

public class HomePageFragment extends RxLazyFragment {

    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    public void finishCreateView(Bundle state) {

    }

    public boolean isOpenSearchView() {

        return mSearchView.isSearchOpen();
    }


    public void closeSearchView() {

        mSearchView.closeSearch();
    }
}
