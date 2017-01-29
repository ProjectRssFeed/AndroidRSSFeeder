package com.exmple.rssfeed.viewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.exmple.rssfeed.BR;
import com.exmple.rssfeed.Json.JsonRequestQueue;
import com.exmple.rssfeed.Json.SubJsonObjectRequest;
import com.exmple.rssfeed.R;
import com.exmple.rssfeed.RSSFeed;
import com.exmple.rssfeed.Utils.LoggerService;
import com.exmple.rssfeed.model.Data;
import com.exmple.rssfeed.model.RssModel;
import com.exmple.rssfeed.view.AddRssActivity;
import com.exmple.rssfeed.view.ArticleActivity;
import com.exmple.rssfeed.view.RssActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static com.android.volley.Request.*;

/**
 * Created by Quentin on 24/01/2017.
 */

public class AddRssActivityViewModel extends BaseObservable {

    private String Url = "";

    private AddRssActivity activity;

    public AddRssActivityViewModel(AddRssActivity ada) {
        activity = ada;
    }

    @Bindable
    public String getLink() {
        return this.Url;
    }

    public void setLink(String url) {
        this.Url = url;
        notifyPropertyChanged(BR.link);
    }

    public synchronized void onClickAdd(View view) {
        try {
            SubJsonObjectRequest json = new SubJsonObjectRequest(Method.POST, Data.getInstance().Address, new JSONObject("{\"Link\":\"" + getLink() + "\"}"),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(RSSFeed.getContext(), "Add RSS flux", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RSSFeed.getContext(), "Failed to add RSS flux", Toast.LENGTH_SHORT).show();
                }
            });
            JsonRequestQueue.getInstance().addToRequestQueue(json);
            activity.finish();
        } catch (Exception e) {
            Toast.makeText(activity, "Failed to parse url", Toast.LENGTH_SHORT).show();
        }
    }
}
