package com.mikk.bilibili.common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Mikk on 2017/4/12.
 */

public class MyApplication extends Application {

    //在整个应用执行过程中，需要提供的变量
    public static Context mContext;//需要使用的上下文对象
    public static Handler mMainHandler;//需要使用的handler
    public static Thread mMainThread;//提供主线程对象
    public static int mMainThreadId;//提供主线程对象的id

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Handler getMainHandler() {
        return mMainHandler;
    }

    public static Context getContext() {
        return mContext;
    }

    public static int getMainThreadId(){
        return mMainThreadId;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this.getApplicationContext();
        mMainHandler = new Handler();
        mMainThread = Thread.currentThread();//实例化当前Application的线程即为主线程
        mMainThreadId = android.os.Process.myTid();//获取当前线程的id

    }

}
