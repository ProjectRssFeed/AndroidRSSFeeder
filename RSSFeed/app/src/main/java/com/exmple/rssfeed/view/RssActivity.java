package com.exmple.rssfeed.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.view.fragment.RSSFragment;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RssActivity extends BaseActivity {

    private RSSFragment rssFragment;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Data.getInstance().SaveData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);
        rssFragment = new RSSFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.rssframe, rssFragment)
                .commit();
    }
}
