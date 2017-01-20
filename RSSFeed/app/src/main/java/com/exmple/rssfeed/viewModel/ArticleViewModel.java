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
import com.exmple.rssfeed.model.ArticleModel;

public class ArticleViewModel extends BaseObservable {

    private Context context;
    private ArticleModel post;
    public ArticleViewModel(Context context, ArticleModel post) {
        this.context = context;
        this.post = post;
    }

    public String getPostScore() {
        return String.valueOf(post.Author);
    }

    public String getPostTitle() {
        return post.Date;
    }

    public Spannable getPostAuthor() {
        String author = post.Author;
        SpannableString content = new SpannableString(author);
        return content;
    }

    public View.OnClickListener onClickPost() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Post.PostType postType = post.postType;
//                if (postType == Post.PostType.JOB || postType == Post.PostType.STORY) {
//                    launchStoryActivity();
//                } else if (postType == Post.PostType.ASK) {
//                    launchCommentsActivity();
//                }
//            }
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

    public View.OnClickListener onClickComments() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        };
    }
}
