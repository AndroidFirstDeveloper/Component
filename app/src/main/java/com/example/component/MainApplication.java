package com.example.component;

import android.util.Log;

import com.example.base.BaseApplication;

public class MainApplication extends BaseApplication {

    @Override
    public void init() {
        Log.e(TAG, "init: 初始化main组件");
    }
}
