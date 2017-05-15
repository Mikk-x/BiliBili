package com.mikk.bilibili;

import android.app.Application;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.facebook.stetho.Stetho;
import com.mikk.bilibili.utils.ThemeHelper;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Mikk on 2017/4/12.
 */

public class MyApplication extends Application implements ThemeUtils.switchColor {

    public static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        init();
    }

    private void init() {
        // 初始化主题切换
        ThemeUtils.setSwitchColor(this);

        // 初始化Leak内存泄漏检测工具
        LeakCanary.install(this);

        // 初始化stetho调试工具
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }

    public static MyApplication getInstance() {

        return mInstance;
    }

    public int replaceColorById(Context context, @ColorRes int colorId) {

        if (ThemeHelper.isDefaultTheme(context)) {
            return context.getResources().getColor(colorId);
        }
        String theme = getTheme(context);
        if (theme != null) {
            colorId = getThemeColorId(context, colorId, theme);
        }
        return context.getResources().getColor(colorId);
    }


    public int replaceColor(Context context, @ColorInt int color) {

        if (ThemeHelper.isDefaultTheme(context)) {
            return color;
        }
        String theme = getTheme(context);
        int colorId = -1;

        if (theme != null) {
            colorId = getThemeColor(context, color, theme);
        }
        return colorId != -1 ? getResources().getColor(colorId) : color;
    }


    private String getTheme(Context context) {

        if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_STORM) {
            return "blue";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_HOPE) {
            return "purple";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_WOOD) {
            return "green";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_LIGHT) {
            return "green_light";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_THUNDER) {
            return "yellow";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_SAND) {
            return "orange";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_FIREY) {
            return "red";
        }
        return null;
    }


    private
    @ColorRes
    int getThemeColorId(Context context, int colorId, String theme) {

        switch (colorId) {
            case R.color.theme_color_primary:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case R.color.theme_color_primary_dark:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case R.color.theme_color_primary_trans:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return colorId;
    }


    private
    @ColorRes
    int getThemeColor(Context context, int color, String theme) {

        switch (color) {
            case 0xfffb7299:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case 0xffb85671:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case 0x99f0486c:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return -1;
    }


}
