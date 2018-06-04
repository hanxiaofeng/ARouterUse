package com.xinshiyun.arouterhomedemo.interceptor;

/**
 * author: 王可可
 * Created on 2018/6/4.
 * description: 摇摇摆摆又是一年
 */

import android.os.Handler;
import android.os.Looper;

public class MainLooper extends Handler {
    private static MainLooper instance = new MainLooper(Looper.getMainLooper());

    protected MainLooper(Looper looper) {
        super(looper);
    }

    public static MainLooper getInstance() {
        return instance;
    }

    public static void runOnUiThread(Runnable runnable) {
        if(Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            instance.post(runnable);
        }

    }
}
