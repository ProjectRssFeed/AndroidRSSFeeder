package com.exmple.rssfeed.model;

import android.databinding.ObservableArrayList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RssModel implements Serializable {

    public String Link = "";
    public List<ArticleModel> article = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        RssModel am = (RssModel) obj;
        if (!Link.equals(am.Link))
            return false;
        return true;
    }

    public RssModel(String link) {
        this.Link = link;
    }
}
