package com.exmple.rssfeed.Utils;

import android.util.Log;

import java.util.Objects;

/**
 * Created by Quentin on 13/01/2017.
 */

public class LoggerService {

    public static void Log(String type, String msg) {
        Log.d(type, msg);
    }

    public static void Log(String msg) {
        Log.d("LoggerService", msg);
    }
}
