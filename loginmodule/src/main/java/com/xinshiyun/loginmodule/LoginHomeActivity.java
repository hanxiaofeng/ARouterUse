package com.xinshiyun.loginmodule;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.xinshiyun.base.BaseActivity;

@Route(path = "/login/login", group = "login")
public class LoginHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_home);

        initView();
    }

    private void initView() {
        findViewById(R.id.login_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.login_go_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/message/message")
                        .navigation();
            }
        });

        ((TextView) findViewById(R.id.tv_show_extra)).setText("I am " + LoginHomeActivity.class.getName());
        String extra = getIntent().getStringExtra("extra");
        if (!TextUtils.isEmpty(extra)) {
            ((TextView) findViewById(R.id.tv_show_extra)).setText(extra);
        }
    }
}
