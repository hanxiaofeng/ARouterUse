package com.xinshiyun.arouterhomedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumpActivityTest();
    }

    private void jumpActivityTest() {

        findViewById(R.id.btn_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/test/loading").navigation();
            }
        });

        findViewById(R.id.btn_loading_param).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/test/loading")
                        .withString("param", "我是上个页面传过来的值")
                        .navigation(MainActivity.this, new NavigationCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("arouter", "找到了");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("arouter", "找不到了");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.e("arouter", "跳转完了");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("arouter", "被拦截了");
                            }
                        });
            }
        });

        findViewById(R.id.btn_loading_forresult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 转场动画(API16+)
                ActivityOptionsCompat compat = ActivityOptionsCompat.
                        makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);

                ARouter.getInstance().build("/test/loading")
                        .withString("param", "我是上个页面传过来的值")
                        .withOptionsCompat(compat)
                        .navigation(MainActivity.this, 100);
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ARouter.getInstance().build("/login/login","login")
                        .navigation();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100 && resultCode == 101) {
            String resultData = data.getStringExtra("data");
            Toast.makeText(this, "onActivityResult：" + resultData, Toast.LENGTH_SHORT).show();
        }

    }
}
