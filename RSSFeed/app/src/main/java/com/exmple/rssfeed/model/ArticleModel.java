package com.exmple.rssfeed.model;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Quentin on 14/01/2017.
 */

public class ArticleModel implements Serializable{

    public String Title;
    public String Text;
    public String Link;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        ArticleModel am = (ArticleModel)obj;
        if (!Title.equals(am.Title))
            return false;
        if (!Link.equals(am.Link))
            return false;
        if (!Text.equals(am.Text))
            return false;
        return true;
    }

    public ArticleModel() {
        Title = "";
        Link = "";
        Text = "";
    }
}
