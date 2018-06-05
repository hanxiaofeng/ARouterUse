package com.xinshiyun.arouterhomedemo.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * author: 王可可
 * Created on 2018/6/5.
 * description: 摇摇摆摆又是一年
 */

@Route(path = "/service/saySomething")
public class HelloServiceImp implements HelloService {

    Context mContext;

    @Override
    public void saySomething(String name) {
        Toast.makeText(mContext, "name:"+name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
