package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.BaseActivity;
import com.example.base.ILoginDataProvider;
import com.example.base.RouterPaths;
import com.example.base.model.UserInfo;

@Route(path = RouterPaths.LOGIN_ACTIVITY)
public class LoginActivity extends BaseActivity {

    private EditText login_activity_login_layout_et1;
    private EditText login_activity_login_layout_et2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_login_layout);
        login_activity_login_layout_et1 = findViewById(R.id.login_activity_login_layout_et1);
        login_activity_login_layout_et2 = findViewById(R.id.login_activity_login_layout_et2);
    }

    public void login(View view) {
        String name = login_activity_login_layout_et1.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "用户名不允许为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String accountId = login_activity_login_layout_et2.getText().toString();
        if (TextUtils.isEmpty(accountId)) {
            Toast.makeText(this, "密码不允许为空", Toast.LENGTH_SHORT).show();
            return;
        }
        ILoginDataProvider provider = (ILoginDataProvider) ARouter.getInstance().build(RouterPaths.LOGIN_PROVIDER).navigation();
        if (provider != null) {
            provider.setLoginAccountId(name);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("data", new UserInfo(name, accountId, System.currentTimeMillis()));
            setResult(1, intent);
            finish();
        }
    }
}
