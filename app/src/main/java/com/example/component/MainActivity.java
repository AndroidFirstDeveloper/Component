package com.example.component;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.BaseActivity;
import com.example.base.ILoginDataProvider;
import com.example.base.RouterPaths;
import com.example.base.model.UserInfo;

import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpShare(View view) {
        ILoginDataProvider provider = (ILoginDataProvider) ARouter.getInstance().build(RouterPaths.LOGIN_PROVIDER).navigation();
        if (provider != null) {
            if (provider.getLoginAccountId() != null) {
                Log.e(TAG, "jumpShare: 账号ID=" + provider.getLoginAccountId());
                ARouter.getInstance().build(RouterPaths.SHARE_ACTIVITY).withParcelable("userInfo", userInfo).navigation();
                return;
            }
        }
        ARouter.getInstance().build(RouterPaths.LOGIN_ACTIVITY).navigation(this, 1);
    }

    private UserInfo userInfo;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                this.userInfo = data.getParcelableExtra("data");
            }
        }
    }
}