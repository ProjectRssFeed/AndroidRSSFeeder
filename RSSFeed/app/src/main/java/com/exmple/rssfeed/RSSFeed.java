package com.exmple.rssfeed;

import android.app.Application;
import android.content.Context;

/**
 * Created by Quentin on 14/01/2017.
 */

public class RSSFeed extends Application {

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        RSSFeed.context = getApplicationContext();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static Context getContext() {
        return RSSFeed.context;
    }
}
