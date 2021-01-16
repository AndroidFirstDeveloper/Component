package com.example.login;

import android.util.Log;

import com.example.base.BaseApplication;

public class LoginApplication extends BaseApplication {
    @Override
    public void init() {
        Log.e(TAG, "init: login 组件初始化");
    }
}
