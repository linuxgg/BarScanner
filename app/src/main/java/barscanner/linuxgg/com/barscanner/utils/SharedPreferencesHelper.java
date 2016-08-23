package barscanner.linuxgg.com.barscanner.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import barscanner.linuxgg.com.barscanner.MainApplication;


public class SharedPreferencesHelper {
    public final static String ALREADY_SEND = "ALREADY_SEND";


    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(key, defaultValue);
    }

    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainApplication.getAppContext()).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainApplication.getAppContext()).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    public static String getString(Context context, String key, String defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, defaultValue);
    }


    public static boolean getIsAlreadySend() {
        return PreferenceManager.getDefaultSharedPreferences(MainApplication.getAppContext()).getBoolean(SharedPreferencesHelper.ALREADY_SEND, false);
    }

    public static void setIsAlreadySend(boolean isAlreadySend) {
        putBoolean(SharedPreferencesHelper.ALREADY_SEND, isAlreadySend);
    }


}
