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
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.adapter.ArticleAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    @Bind(R.id.FloatingButonRemove)
    FloatingActionButton mButton;

    public static final String ARG_USER = "ARG_USER";

    private ArticleAdapter mPostAdapter;
    private RssModel model;
    private ArticleActivity pactivity;

//    public static ArticlesFragment newInstance(String user) {
//        ArticlesFragment storiesFragment = new ArticlesFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_USER, user);
//        storiesFragment.setArguments(args);
//        return storiesFragment;
//    }

    public ArticlesFragment(RssModel mod, ArticleActivity activity) {
        model = mod;
        this.pactivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        try {
            File saveList = new File(RSSFeed.getContext().getCacheDir() + "list.data");
            FileInputStream fd = new FileInputStream(saveList);
            ObjectInputStream ois = new ObjectInputStream(fd);
            mArticles = (List<ArticleModel>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        mPostAdapter = new ArticleAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, fragmentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setupRecyclerView();
        if (model.article.size() > 0)
            hideLoadingViews();
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
/*
        try {
            File saveList = new File(RSSFeed.getContext().getCacheDir() + "list.data");
            FileOutputStream fd = new FileOutputStream(saveList);
            ObjectOutputStream os = new ObjectOutputStream(fd);
            os.writeObject(mArticles);
        } catch (Exception e) {
            LoggerService.Log("Error writing Data");
        }
*/
    }

    @Override
    public void onRefresh() {
        if (mPostAdapter != null) mPostAdapter.setItems(new ArrayList<ArticleModel>());
        ArticleModel tmp = new ArticleModel();
        int i = ((new Random()).nextInt(80 -65 ) + 65);
        tmp.Text = "fzioerjvipuvghreiuhsiuerhviufdsiuvhfdiuvdfuigzregerzrgzergrezgggggggggggggggggggggggggggggggggggggggggggggggggggfdsgrfsgfddsgfsdgfsdgfdsgfsdgfdsgfsdgfdgfdgfdgsdfgfdsgfdsgfdsgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdgfdsgfdsgfdhvfduisvs";
        tmp.Title = "Android c'est de la merde " + i;
        tmp.Link = "http://v,ojoerifoerifroijeroifoierefjo";
        model.article.add(0, tmp);
        mPostAdapter.setItems(model.article);
        hideLoadingViews();
    }

    private void setupRecyclerView() {
        mListPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListPosts.setHasFixedSize(true);
        mPostAdapter.setItems(model.article);
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
