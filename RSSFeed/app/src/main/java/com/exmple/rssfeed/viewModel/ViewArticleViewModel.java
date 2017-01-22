package com.exmple.rssfeed.viewModel;

import android.databinding.BaseObservable;
import android.text.Spannable;
import android.text.SpannableString;

import com.exmple.rssfeed.model.ArticleModel;

/**
 * Created by Quentin on 21/01/2017.
 */

public class ViewArticleViewModel extends BaseObservable {

    private ArticleModel model;

    public ViewArticleViewModel(ArticleModel model) {
        this.model = model;
    }

    public Spannable getTitle() {
        return new SpannableString(model.Title);
    }

    public Spannable getText() { return new SpannableString(model.Text);}

    public String getAuthor() { return "Auteur : " + model.Author;}

    public String getDate() { return "Le : " + model.Date;}
}
