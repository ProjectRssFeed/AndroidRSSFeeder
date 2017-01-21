package com.exmple.rssfeed.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.view.fragment.ArticlesFragment;

public class ArticleActivity extends BaseActivity {

    private ArticlesFragment am;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        am = new ArticlesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, am)
                .commit();
    }
}