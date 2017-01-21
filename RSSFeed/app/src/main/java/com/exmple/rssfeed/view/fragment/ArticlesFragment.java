package com.exmple.rssfeed.view.fragment;

import android.os.Bundle;
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
import com.exmple.rssfeed.view.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;
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

    public static final String ARG_USER = "ARG_USER";

    private ArticleAdapter mPostAdapter;
    private List<ArticleModel> mArticles;

    public static ArticlesFragment newInstance(String user) {
        ArticlesFragment storiesFragment = new ArticlesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER, user);
        storiesFragment.setArguments(args);
        return storiesFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArticles = new ArrayList<>();
        Bundle bundle = getArguments();
        mPostAdapter = new ArticleAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, fragmentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRefresh() {
        if (mPostAdapter != null) mPostAdapter.setItems(new ArrayList<ArticleModel>());
        ArticleModel tmp = new ArticleModel();
        int i = ((new Random()).nextInt(80 -65 ) + 65);
        tmp.Author = "Quentin " + i;
        tmp.Date = "Today";
        tmp.Text = "fzioerjvipuvghreiuhsiuerhviufdsiuvhfdiuvdfuihvfduisvs";
        tmp.Title = "Android c'est de la merde";
        mArticles.add(0, tmp);
        mPostAdapter.setItems(mArticles);
        hideLoadingViews();
    }

    private void setupRecyclerView() {
        mListPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListPosts.setHasFixedSize(true);
        mPostAdapter.setItems(mArticles);
        mListPosts.setAdapter(mPostAdapter);
    }

    private void hideLoadingViews() {
        mProgressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void showHideOfflineLayout(boolean isOffline) {
        mListPosts.setVisibility(isOffline ? View.GONE : View.VISIBLE);
        mProgressBar.setVisibility(isOffline ? View.GONE : View.VISIBLE);
    }

}
