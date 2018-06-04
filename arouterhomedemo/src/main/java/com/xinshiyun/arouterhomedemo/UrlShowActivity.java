package com.xinshiyun.arouterhomedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 浏览器启动本地appActivity，schema跳转
 */

@Route(path = "/url/showActivity")
public class UrlShowActivity extends AppCompatActivity {

    private TextView tvShow;

    @Autowired
    String name;

    @Autowired
    int age;

    @Autowired
    String obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_show);
        ARouter.getInstance().inject(this);
        tvShow = (TextView) findViewById(R.id.tv_url_show);

        //解析参数
        Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString("name");

        Log.e("obj","obj = "+obj);

        if(null != obj){
            tvShow.setText("参数是： " + "name: " + name + " age =" + age
                    + " name1: " + name1 + " obj: " + obj.toString());
        }

    }
}
