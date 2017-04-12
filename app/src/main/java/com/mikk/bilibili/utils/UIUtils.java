package com.mikk.bilibili.utils;

import android.content.Context;
import android.content.res.Resources;

import com.mikk.bilibili.common.MyApplication;

/**
 * Created by Mikk on 2017/4/12.
 */

public class UIUtils {

    public static Context getContext() {
        return MyApplication.getContext();
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

}
