package com.xinshiyun.arouterhomedemo;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author: 王可可
 * Created on 2018/5/31.
 * description: 摇摇摆摆又是一年
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initArouter();
    }

    private void initArouter() {
        if (isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public boolean isDebug() {
        boolean isDebug = this.getApplicationInfo() != null &&
                (this.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        return isDebug;
    }
}
