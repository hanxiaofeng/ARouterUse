package com.xinshiyun.arouterhomedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JumpUrlActivity extends AppCompatActivity {

    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_url);

        initView();
    }

    private void initView() {
        tvShow = findViewById(R.id.tv_show);



    }
}
