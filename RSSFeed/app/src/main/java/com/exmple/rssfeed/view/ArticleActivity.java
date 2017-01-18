package com.exmple.rssfeed.view;

import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.databinding.ActivityArticleBinding;
import com.exmple.rssfeed.viewModel.ArticleActivityViewModel;

public class ArticleActivity extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{

    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mListPosts;
    ProgressBar mProgressBar;

    ArticleActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new ArticleActivityViewModel();

        ActivityArticleBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_article);
        bind.setViemodel(vm);
        mProgressBar = (ProgressBar)findViewById(R.id.progress_indicator);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                vm.onRefresh();
            }
        });
        mListPosts =(RecyclerView) findViewById(R.id.recycler_articles);
    }

    @Override
    public void onRefresh() {
        vm.onRefresh();
    }
}
