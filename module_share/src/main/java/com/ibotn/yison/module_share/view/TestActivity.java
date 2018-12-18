package com.ibotn.yison.module_share.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.ibotn.yison.module_share.R;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_color);
        ImmersionBar.with(TestActivity.this)
                .navigationBarEnable(true)
                .navigationBarWithKitkatEnable(true)
                .statusBarView(R.id.top_view)
                .statusBarColor(R.color.share_colorPrimary)
                .navigationBarColor(R.color.share_blue)
                .init();

    }


}
