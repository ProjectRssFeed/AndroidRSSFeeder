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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.exmple.rssfeed.Json.JsonRequestQueue;
import com.exmple.rssfeed.R;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.ArticleModel;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.adapter.ArticleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        mPostAdapter = new ArticleAdapter(getActivity(), model);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_article, container, false);
        ButterKnife.bind(this, fragmentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setupRecyclerView();
        refreshData();
        if (Data.getInstance().Rss.get(model).article.size() > 0)
            hideLoadingViews();
        return fragmentView;
    }

    @Override
    public void onRefresh() {
        refreshData();
        hideLoadingViews();
    }

    private void setupRecyclerView() {
        mListPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListPosts.setHasFixedSize(true);
        mListPosts.setAdapter(mPostAdapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest json = new JsonObjectRequest(Request.Method.DELETE, RSSFeed.getContext().getString(R.string.serverLink) + "/" + Data.getInstance().Rss.get(model).Id, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        LoggerService.Log("Failed to Delete RSS via JSON");
                    }
                });
                JsonRequestQueue.getInstance().addToRequestQueue(json);
                pactivity.finish();
            }
        });
    }

    private void hideLoadingViews() {
        mProgressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void refreshData() {
        JsonArrayRequest json = new JsonArrayRequest(Request.Method.GET, RSSFeed.getContext().getString(R.string.serverLink) + "/" + Data.getInstance().Rss.get(model).Id, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject flux = (JSONObject)response.get(i);
                        ArticleModel rss = new ArticleModel(flux.getString("Title"), flux.getString("Description"), flux.getString("Link"));
                        if (!Data.getInstance().Rss.get(model).article.contains(rss))
                            Data.getInstance().Rss.get(model).article.add(0, rss);
                    }

                } catch (JSONException e) {

                }
                mPostAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                LoggerService.Log("Failed to Get RSS data via JSON");
            }
        });
    }
}
