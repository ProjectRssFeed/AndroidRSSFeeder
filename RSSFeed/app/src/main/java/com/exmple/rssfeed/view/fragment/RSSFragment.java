package com.exmple.rssfeed.view.fragment;

import android.content.Intent;
import android.databinding.Bindable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.view.AddRssActivity;
import com.exmple.rssfeed.view.RssActivity;
import com.exmple.rssfeed.view.adapter.RSSAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Quentin on 24/01/2017.
 */

public class RSSFragment extends android.support.v4.app.Fragment {

    @Bind(R.id.recycler_stories)
    RecyclerView mRssRecycler;

    @Bind(R.id.FloatingButonAdd)
    FloatingActionButton mButton;

    private RSSAdapter rssAdapter;

    public static RSSFragment newInstance(String user) {
        return new RSSFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        try {
//            File saveList = new File(RSSFeed.getContext().getCacheDir() + "list.data");
//            FileInputStream fd = new FileInputStream(saveList);
//            ObjectInputStream ois = new ObjectInputStream(fd);
//            mRss = (List<ArticleModel>) ois.readObject();
//            ois.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        rssAdapter = new RSSAdapter(getActivity());
    }


    @Override
    public void onResume() {
        super.onResume();
        rssAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_rss, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        try {
//            File saveList = new File(RSSFeed.getContext().getCacheDir() + "list.data");
//            FileOutputStream fd = new FileOutputStream(saveList);
//            ObjectOutputStream os = new ObjectOutputStream(fd);
//            os.writeObject(mRss);
//        } catch (Exception e) {
//            LoggerService.Log("Error writing Data");
//        }
    }

    private void setupRecyclerView() {
        mRssRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRssRecycler.setHasFixedSize(true);
        mRssRecycler.setAdapter(rssAdapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RSSFeed.getContext(), AddRssActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                RSSFeed.getContext().startActivity(i);
            }
        });
    }
}
