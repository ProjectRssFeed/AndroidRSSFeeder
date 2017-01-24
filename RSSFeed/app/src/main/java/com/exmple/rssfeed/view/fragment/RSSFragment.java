package com.exmple.rssfeed.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exmple.rssfeed.R;
import com.exmple.rssfeed.model.RssModel;
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

    private RSSAdapter rssAdapter;
    private List<RssModel> mRss;

    public static RSSFragment newInstance(String user) {
        RSSFragment storiesFragment = new RSSFragment();
        return storiesFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRss = new ArrayList<>();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_article, container, false);
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
        rssAdapter.setItems(mRss);
        mRssRecycler.setAdapter(rssAdapter);
    }
}
