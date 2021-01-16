package com.example.base;

import com.alibaba.android.arouter.facade.template.IProvider;


/**
 * 组件间通信功能接口(在具体的组件中进行实现，其它组件通过路由可以进行访问)
 */
public interface ILoginDataProvider extends IProvider {
    String TAG = "ILoginDataProvider";

    String getLoginAccountId();

    void setLoginAccountId(String accountId);
}
