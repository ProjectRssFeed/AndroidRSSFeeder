package com.exmple.rssfeed.model;

import android.databinding.ObservableArrayList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RssModel implements Serializable {

    public String Title = "";
    public String Text = "";
    public String Id = "";
    public List<ArticleModel> article = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        RssModel am = (RssModel) obj;
        if (!Id.equals(am.Id))
            return false;
        if (!Title.equals(am.Title))
            return false;
        if (!Text.equals(am.Text))
            return false;
        return true;
    }

    public RssModel(String id, String title, String txt) {
        this.Title = title;
        this.Id = id;
        this.Text = txt;
    }
}
