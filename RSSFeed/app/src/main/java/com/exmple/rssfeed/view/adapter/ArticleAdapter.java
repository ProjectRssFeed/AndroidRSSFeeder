package com.exmple.rssfeed.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.databinding.ItemArticleBinding;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.viewModel.ArticleViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder> {
    private int mPosts;
    private Context mContext;

    public ArticleAdapter(Context context, int model) {
        mContext = context;
        mPosts = model;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemArticleBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_article,
                parent,
                false);
        return new BindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ItemArticleBinding postBinding = holder.binding;
        postBinding.setViewModel(new ArticleViewModel(mContext, Data.getInstance().Rss.get(mPosts).article.get(position)));
    }

    @Override
    public int getItemCount() {
        if (!(mPosts < Data.getInstance().Rss.size()))
            return 0;
        return Data.getInstance().Rss.get(mPosts).article.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemArticleBinding binding;

        public BindingHolder(ItemArticleBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }
}