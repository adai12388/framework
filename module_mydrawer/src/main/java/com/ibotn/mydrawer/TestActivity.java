package com.ibotn.mydrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity_color);

        ImmersionBar.with(this)
                .statusBarView(R.id.top_view)
                .statusBarColor(R.color.colorPrimary)
                .navigationBarColor(R.color.design_default_color_primary)
                .init();
    }
}
