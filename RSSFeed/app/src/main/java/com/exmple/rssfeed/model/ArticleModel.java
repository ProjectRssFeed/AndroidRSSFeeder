package com.exmple.rssfeed.model;

import android.os.Parcelable;

/**
 * Created by Quentin on 14/01/2017.
 */

public class ArticleModel {

    public String Title;
    public String Author;
    public String Date;
    public String Text;

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        ArticleModel am = (ArticleModel)obj;
        if (!Title.equals(am.Title))
            return false;
        if (!Author.equals(am.Author))
            return false;
        if (!Date.equals(am.Date))
            return false;
        if (!Text.equals(am.Text))
            return false;
        return true;
    }

    public ArticleModel() {
        Title = "";
        Author = "";
        Date = "";
        Text = "";
    }
}
