package com.exmple.rssfeed.viewModel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

import com.exmple.rssfeed.model.ArticleModel;

import java.util.List;

/**
 * Created by Quentin on 21/01/2017.
 */

public class ArticleFragmentViewModel extends BaseObservable {

    public ObservableArrayList<ArticleModel> article;

    public ArticleFragmentViewModel() {
        article = new ObservableArrayList<>();
    }

    public void addItem(ArticleModel m) {
        article.add(0, m);
        notifyChange();
    }
}
