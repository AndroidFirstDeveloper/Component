package com.example.share;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.base.BaseActivity;
import com.example.base.RouterPaths;

@Route(path = RouterPaths.SHARE_ACTIVITY)
public class ShareActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_share_layout);
    }

    public void share(View view) {
        Toast.makeText(this, "分享成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
