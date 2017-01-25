package com.exmple.rssfeed.viewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.view.textservice.TextInfo;

import com.exmple.rssfeed.BR;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.view.AddRssActivity;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.RssActivity;

/**
 * Created by Quentin on 24/01/2017.
 */

public class AddRssActivityViewModel extends BaseObservable {

    private String Title = "";
    private String Description = "";
    private String Url = "";

    private AddRssActivity activity;

    public AddRssActivityViewModel(AddRssActivity ada) {
        activity = ada;
    }

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
        Data.getInstance().Rss.add(0,new RssModel(Title, Description, Url));
        activity.finish();
    }
}
