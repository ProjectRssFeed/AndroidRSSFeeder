package com.exmple.rssfeed.viewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.exmple.rssfeed.BR;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.view.ArticleActivity;

/**
 * Created by Quentin on 24/01/2017.
 */

public class AddRssActivityViewModel extends BaseObservable {

    private String Title;
    private String Description;
    private String Url;

    @Bindable
    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getText() {
        return this.Description;
    }

    public void setText(String txt) {
        this.Description = txt;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public String getLink() {
        return this.Url;
    }

    public void setLink(String url) {
        this.Url = url;
        notifyPropertyChanged(BR.link);
    }

    public synchronized void onClickAdd(View view) {
        LoggerService.Log(this.getClass().getName(), "Click on Add");
    }
}
