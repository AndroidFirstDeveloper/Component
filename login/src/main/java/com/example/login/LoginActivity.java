package com.example.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.BaseActivity;
import com.example.base.ILoginDataProvider;
import com.example.base.RouterPaths;

@Route(path = RouterPaths.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login_layout);
    }

    public void login(View view) {
        ILoginDataProvider provider = (ILoginDataProvider) ARouter.getInstance().build(RouterPaths.LOGIN_PROVIDER).navigation();
        if (provider != null) {
            provider.setLoginAccountId("sugarman");
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
