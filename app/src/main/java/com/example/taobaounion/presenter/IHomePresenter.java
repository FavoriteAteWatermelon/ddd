package com.example.taobaounion.presenter;

import com.example.taobaounion.view.IHomeCallback;

public interface IHomePresenter {
//    获取商品分类
    void getCategories();
    void  registerCallback(IHomeCallback callBack);
    void  unregisterCallback(IHomeCallback callBack);
}
