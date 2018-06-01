package com.xinshiyun.arouterhomedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/test/loading")
public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        initView();
    }

    private void initView() {

        String param = getIntent().getStringExtra("param");
        if (!TextUtils.isEmpty(param)) {
            Toast.makeText(this, "param = " + param, Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data", "我是loadingActivity的值");
                setResult(101, intent);
                finish();
            }
        });
    }
}
