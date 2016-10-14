package com.dongxi.helloretrofit;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/14.
 */

public class BaseApplication extends Application {
    private static BaseApplication application;
    public static Context getApplication() {
        return application;
    }
}
