package com.exmple.rssfeed.Json;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.exmple.rssfeed.RSSFeed;

/**
 * Created by Quentin on 25/01/2017.
 */

public class JsonRequestQueue {
    private static JsonRequestQueue Instance;
    private RequestQueue requestQueue;

    private JsonRequestQueue() {
        requestQueue = getRequestQueue();
    }

    public final static JsonRequestQueue getInstance() {
        if (Instance == null) {
            synchronized(JsonRequestQueue.class) {
                if (Instance == null) {
                    Instance = new JsonRequestQueue();
                }
            }
        }
        return Instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(RSSFeed.getContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
