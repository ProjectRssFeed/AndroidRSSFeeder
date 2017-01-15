package com.exmple.rssfeed.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.exmple.rssfeed.databinding.ItemArticleBinding;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.viewModel.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 14/01/2017.
 */

class BindingHolder extends RecyclerView.ViewHolder {
    public ItemArticleBinding binding;

    public BindingHolder(ItemArticleBinding binding) {
        super(binding.cardView);
        this.binding = binding;
    }
}

public class ArticleAdapter extends RecyclerView.Adapter<BindingHolder> {

    private List<ArticleModel> articles;

    public ArticleAdapter() {
        articles = new ArrayList<>();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        ItemArticleBinding articleBinding = holder.binding;
        articleBinding.setViewModel(new ArticleViewModel(articles.get(position)));
    }

    public List<ArticleModel> getItem() {
        return articles;
    }

    public void setArticles(List<ArticleModel> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public void addItem(ArticleModel article) {
        articles.add(0, article);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
