package com.exmple.rssfeed.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.databinding.ItemArticleBinding;
import com.exmple.rssfeed.databinding.ItemRssBinding;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.viewModel.ArticleViewModel;
import com.exmple.rssfeed.viewModel.RssViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RSSAdapter extends RecyclerView.Adapter<RSSAdapter.BindingHolder>{

    private Context mContext;

    public RSSAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RSSAdapter.BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRssBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_rss,
                parent,
                false);
        return new RSSAdapter.BindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(RSSAdapter.BindingHolder holder, int position) {
        ItemRssBinding postBinding = holder.binding;
        postBinding.setViewModel(new RssViewModel(mContext, Data.getInstance().Rss.get(position)));
    }

    @Override
    public int getItemCount() {
        return Data.getInstance().Rss.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ItemRssBinding binding;

        public BindingHolder(ItemRssBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }
}