package com.example.taobaounion.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.presenter.IHomePresenter;
import com.example.taobaounion.presenter.implement.HomePresenterImpl;
import com.example.taobaounion.view.IHomeCallback;


public class HomeFragment extends BaseFragment implements IHomeCallback {
    private HomePresenterImpl homePresenter;
    @Override
    protected int getRootViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPresenter() {
        homePresenter = new HomePresenterImpl();
        homePresenter.registerCallback(this);

    }

    @Override
    protected void loadData() {
        super.loadData();
        homePresenter.getCategories();

    }

    @Override
    protected void release() {
        if (homePresenter != null) {
            homePresenter.unregisterCallback(this);
        }
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }
}
