package com.exmple.rssfeed.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.databinding.ActivityViewArticleBinding;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.viewModel.ViewArticleViewModel;

public class ViewArticleActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context, ArticleModel post) {
        Intent intent = new Intent(context, ViewArticleActivity.class);
        LoggerService.Log(post.Author);
        intent.putExtra("Article", post);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        ArticleModel m = (ArticleModel) bundle.getSerializable("Article");
        ActivityViewArticleBinding bind = DataBindingUtil.setContentView(this, R.layout.activity_view_article);
        ViewArticleViewModel vm = new ViewArticleViewModel(m);
        bind.setViewModel(vm);
    }
}
