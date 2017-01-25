package com.exmple.rssfeed.model;

import android.databinding.ObservableArrayList;

import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Created by Quentin on 24/01/2017.
 */

public final class Data {

    private static volatile Data instance = null;

    public ObservableArrayList<RssModel> Rss;

    private Data() {
        Rss = new ObservableArrayList<RssModel>();
        try {
            File saveList = new File(RSSFeed.getContext().getCacheDir() + "list.data");
            FileInputStream fd = new FileInputStream(saveList);
            ObjectInputStream ois = new ObjectInputStream(fd);
            Rss = (ObservableArrayList<RssModel>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final static Data getInstance() {
        if (Data.instance == null) {
            synchronized(Data.class) {
                if (Data.instance == null) {
                    Data.instance = new Data();
                }
            }
        }
        return Data.instance;
    }

    public void SaveData() {
        try {
            File saveList = new File(RSSFeed.getContext().getCacheDir() + "list.data");
            FileOutputStream fd = new FileOutputStream(saveList);
            ObjectOutputStream os = new ObjectOutputStream(fd);
            os.writeObject(Rss);
        } catch (Exception e) {
            LoggerService.Log("Error during write");
        }
    }
}
