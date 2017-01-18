package com.exmple.rssfeed.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v4.widget.SwipeRefreshLayout;

import com.exmple.rssfeed.view.ArticleActivity;

/**
 * Created by Quentin on 17/01/2017.
 */

public class ArticleActivityViewModel extends BaseObservable implements SwipeRefreshLayout.OnRefreshListener {

    @Bindable
    public ObservableArrayList<ArticleViewModel> list;

    public ArticleActivityViewModel() {
        list = new ObservableArrayList<>();
    }

    @Bindable
    public String getLogin() {
        return "";
    }

    @Override
    public void onRefresh() {

    }
}
