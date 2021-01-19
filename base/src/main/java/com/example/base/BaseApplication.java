package com.example.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 探究Application的生命周期
 * 研究所有activity退出后，application方法执行顺序
 */
public abstract class BaseApplication extends Application implements IBaseApplication {

    protected static final String TAG = "BaseApp";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e(TAG, "----------------------------attachBaseContext: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "----------------------------onCreate: ");
        initComponent();
        initRouter();
    }

    private void initComponent() {
        for (int i = 0; i < ModuleConfig.moduleName.length; i++) {
            try {
                Class component = Class.forName(ModuleConfig.moduleName[i]);
                BaseApplication application = (BaseApplication) component.newInstance();
                application.init();
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "initComponent1: " + e.getMessage());
            } catch (ClassCastException e) {
                Log.e(TAG, "initComponent2: " + e.getMessage());
            } catch (Exception e) {
                Log.e(TAG, "initComponent3: " + e.getMessage());
            }
        }
    }

    private void initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e(TAG, "----------------------------onLowMemory: ");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e(TAG, "----------------------------onTerminate: ");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.e(TAG, "----------------------------onTrimMemory: ");
    }
}
