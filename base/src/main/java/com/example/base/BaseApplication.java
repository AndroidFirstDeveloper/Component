package com.example.base;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseApplication extends Application implements IBaseApplication {

    protected static final String TAG = "BaseApp";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
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

}
