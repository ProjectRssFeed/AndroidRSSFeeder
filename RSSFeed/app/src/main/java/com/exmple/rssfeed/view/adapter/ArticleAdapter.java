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
import com.exmple.rssfeed.viewModel.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.BindingHolder> {
    private List<ArticleModel> mPosts;
    private Context mContext;

    public ArticleAdapter(Context context) {
        mContext = context;
        mPosts = new ArrayList<>();
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
        postBinding.setViewModel(new ArticleViewModel(mContext, mPosts.get(position)));
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void setItems(List<ArticleModel> posts) {
        mPosts = posts;
        notifyDataSetChanged();
    }

    public void addItem(ArticleModel post) {
        mPosts.add(post);
        notifyItemInserted(mPosts.size() - 1);
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemArticleBinding binding;

        public BindingHolder(ItemArticleBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }
}