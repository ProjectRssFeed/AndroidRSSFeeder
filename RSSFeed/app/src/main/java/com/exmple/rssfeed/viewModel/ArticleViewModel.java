package com.exmple.rssfeed.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.ViewArticleActivity;

public class ArticleViewModel extends BaseObservable {

    private Context context;
    private ArticleModel post;
    public ArticleViewModel(Context context, ArticleModel post) {
        this.context = context;
        this.post = post;
    }

    public String getPostTitle() {
        return post.Title;
    }

    public String getPostDate() {
        return post.Date;
    }

    public String getPostText() {
        int i = 0;
        String next = "";
        if (post.Text.length() > 140) {
            i = 140;
            next = "...";
        }
        else
            i = post.Text.length();
        return post.Text.substring(0, i) + next;
    }

    public String getPostAuthor() {
        return "Par : " + post.Author;
    }

    public View.OnClickListener onClickPost() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(ViewArticleActivity.getStartIntent(context, post));
            }
        };
    }

    public View.OnClickListener onClickAuthor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                context.startActivity(UserActivity.getStartIntent(context, post.by));
//            }
            }
        };
    }
}
