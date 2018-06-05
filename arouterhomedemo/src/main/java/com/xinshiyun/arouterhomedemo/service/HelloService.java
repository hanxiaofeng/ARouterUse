package com.xinshiyun.arouterhomedemo.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * author: 王可可
 * Created on 2018/6/5.
 * description: 摇摇摆摆又是一年
 */

public interface HelloService extends IProvider{
    void saySomething(String name);
}
