package com.exmple.rssfeed.model;

import android.databinding.ObservableArrayList;

/**
 * Created by Quentin on 24/01/2017.
 */

public final class Data {

    private static volatile Data instance = null;

    public ObservableArrayList<RssModel> Rss;

    private Data() {
        Rss = new ObservableArrayList<RssModel>();
    }

    public final static Data getInstance() {
        if (Data.instance == null) {
            synchronized(Data.class) {
                if (Data.instance == null) {
                    Data.instance = new Data();
                }
            }
        }
        return Data.instance;
    }
}
