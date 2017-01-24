package com.exmple.rssfeed.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.RssActivity;
import com.exmple.rssfeed.view.ViewArticleActivity;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RssViewModel extends BaseObservable {

    private Context context;
    private RssModel post;
    public RssViewModel(Context context, RssModel post) {
        this.context = context;
        this.post = post;
    }

    public String getName() {
        return post.Title;
    }

    public String getText() {
        int i;
        String next = "";
        if (post.Text.length() > 140) {
            i = 140;
            next = "...";
        }
        else
            i = post.Text.length();
        return post.Text.substring(0, i) + next;
    }

    public View.OnClickListener onClickPost() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RSSFeed.getContext(), ArticleActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                RSSFeed.getContext().startActivity(ArticleActivity.getStartIntent(context, post));
            }
        };
    }
}
