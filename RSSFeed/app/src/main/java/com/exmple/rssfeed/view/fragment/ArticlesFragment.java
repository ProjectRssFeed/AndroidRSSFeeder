package com.exmple.rssfeed.view.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ArticlesFragment extends Fragment implements OnRefreshListener {

    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycler_stories)
    RecyclerView mListPosts;

    @Bind(R.id.progress_indicator)
    ProgressBar mProgressBar;

    @Bind(R.id.FloatingButonRemove)
    FloatingActionButton mButton;

    public static final String ARG_USER = "ARG_USER";

    private ArticleAdapter mPostAdapter;
    private int model;
    private ArticleActivity pactivity;

    public ArticlesFragment(int mod, ArticleActivity activity) {
        model = mod;
        this.pactivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPostAdapter = new ArticleAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, fragmentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setupRecyclerView();
        if (Data.getInstance().Rss.get(model).article.size() > 0)
            hideLoadingViews();
        return fragmentView;
    }

    @Override
    public void onRefresh() {
        if (mPostAdapter != null) mPostAdapter.setItems(new ArrayList<ArticleModel>());
        ArticleModel tmp = new ArticleModel();
        int i = ((new Random()).nextInt(80 -65 ) + 65);
        tmp.Text = "fzioerjvipuvghreiuhsiuerhviufdsiuvhfdiuvdfuigzregerzrgzergrezgggggggggggggggggggggggggggggggggggggggggggggggggggfdsgrfsgfddsgfsdgfsdgfdsgfsdgfdsgfsdgfdgfdgfdgsdfgfdsgfdsgfdsgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdsgfdsgfdhvfduisvs";
        tmp.Title = "Android c'est de la merde " + i;
        tmp.Link = "http://v,ojoerifoerifroijeroifoierefjo";
        Data.getInstance().Rss.get(model).article.add(0, tmp);
        mPostAdapter.setItems(Data.getInstance().Rss.get(model).article);
        hideLoadingViews();
    }

    private void setupRecyclerView() {
        mListPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListPosts.setHasFixedSize(true);
        mPostAdapter.setItems(Data.getInstance().Rss.get(model).article);
        mListPosts.setAdapter(mPostAdapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoggerService.Log("Remove");
                Data.getInstance().Rss.remove(model);
                pactivity.finish();
            }
        });
    }

    private void hideLoadingViews() {
        mProgressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
