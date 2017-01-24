package com.exmple.rssfeed.model;

import android.databinding.ObservableArrayList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RssModel implements Serializable {

    public String Title;
    public String Text;
    public String Link;
    public List<ArticleModel> article;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        RssModel am = (RssModel) obj;
        if (!Title.equals(am.Title))
            return false;
        if (!Link.equals(am.Link))
            return false;
        if (!Text.equals(am.Text))
            return false;
        return true;
    }

    public RssModel(String title, String text, String link) {
        this.Title = title;
        this.Link = link;
        this.Text = text;
        article = new ArrayList<>();
    }

    public RssModel() {
        Title = "";
        Link = "";
        Text = "";
        article = new ArrayList<>();
    }
}
