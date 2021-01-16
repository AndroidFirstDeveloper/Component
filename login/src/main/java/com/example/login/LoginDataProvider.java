package com.example.login;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.ILoginDataProvider;
import com.example.base.RouterPaths;

@Route(path = RouterPaths.LOGIN_PROVIDER)
public class LoginDataProvider implements ILoginDataProvider {

    private String accountId;
    @Override
    public String getLoginAccountId() {
        return accountId;
    }

    @Override
    public void setLoginAccountId(String accountId) {
        this.accountId=accountId;
    }

    @Override
    public void init(Context context) {
        Log.e(TAG, "init: 初始化login组件的provider");
    }
}
