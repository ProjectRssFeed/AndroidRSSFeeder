package com.exmple.rssfeed.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.view.fragment.ArticlesFragment;

public class ArticleActivity extends BaseActivity {

    private ArticlesFragment am;

    public static Intent getStartIntent(Context context, RssModel id) {
        Intent i =  new Intent(context, ArticleActivity.class);
        i.putExtra("RssModel", id);
        return i;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Bundle bundle = getIntent().getExtras();
        RssModel m = (RssModel) bundle.getSerializable("RssModel");
        am = new ArticlesFragment(m, this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, am)
                .commit();
    }
}