package com.example.share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.BaseActivity;
import com.example.base.RouterPaths;
import com.example.base.model.UserInfo;

@Route(path = RouterPaths.SHARE_ACTIVITY)
public class ShareActivity extends BaseActivity {

    @Autowired
    UserInfo userInfo;
    private TextView share_activity_share_layout_tv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_share_layout);
        ARouter.getInstance().inject(this);
        share_activity_share_layout_tv = findViewById(R.id.share_activity_share_layout_tv);
        if (userInfo != null) {
            share_activity_share_layout_tv.setText(userInfo.getName());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (userInfo != null) {
            share_activity_share_layout_tv.setText(userInfo.getName());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (userInfo != null) {
            share_activity_share_layout_tv.setText(userInfo.getName());
        }
    }

    public void share(View view) {
        Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
