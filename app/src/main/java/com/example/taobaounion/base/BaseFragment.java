package com.example.taobaounion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taobaounion.R;

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int viewId = getRootViewId ();
        initPresenter();
        loadData();

        return  inflater.inflate(viewId,container,false);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        release();
    }

    protected void release() {
    }

    protected void initPresenter() {
    }

    protected  void loadData(){

    };

    protected abstract int getRootViewId();

}
