package com.HUAWEI.pet_assistent;

import android.util.Log;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Utils {
    public static final int DEBUG = android.util.Log.DEBUG;

    public static final int INFO = android.util.Log.INFO;

    public static final int WARN = android.util.Log.WARN;

    public static final int ERROR = android.util.Log.ERROR;

    private static final String TAG = "Utils";

    public static String getApiKey() {
        // get apiKey from AppGallery Connect
        String apiKey = "CgB6e3x9n/fYIjmk+Qlnnwm8Faci5ncjk/YIaC1LmhVjsBfpiaBCbK20H9cOAMuzRVfvuW3Yk2iWFpkx/tsbJx3B";

        // need encodeURI the apiKey
        try {
            String encodedApiKey = URLEncoder.encode(apiKey, "utf-8");
            return encodedApiKey;
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "encode apikey error");
            return null;
        }
    }
    public static class LocationLog {


        public static void d(String tag, String msg, Throwable tr) {
            println(DEBUG, tag, msg, tr);
        }

        public static void d(String tag, String msg) {
            d(tag, msg, null);
        }

        public static void i(String tag, String msg, Throwable tr) {
            println(INFO, tag, msg, tr);
        }

        public static void i(String tag, String msg) {
            i(tag, msg, null);
        }

        public static void w(String tag, String msg, Throwable tr) {
            println(WARN, tag, msg, tr);
        }

        public static void w(String tag, String msg) {
            w(tag, msg, null);
        }

        public static void w(String tag, Throwable tr) {
            w(tag, null, tr);
        }

        public static void e(String tag, String msg, Throwable tr) {
            println(ERROR, tag, msg, tr);
        }

        public static void e(String tag, String msg) {
            e(tag, msg, null);
        }

        public static void println(int priority, String tag, String msg, Throwable tr) {


        }

        public static void println(int priority, String tag, String msg) {

        }

    }
}