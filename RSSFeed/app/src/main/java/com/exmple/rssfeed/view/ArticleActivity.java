package com.exmple.rssfeed.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.view.fragment.ArticlesFragment;

public class ArticleActivity extends BaseActivity {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        addStoriesFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    private void addStoriesFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new ArticlesFragment())
                .commit();
    }
}