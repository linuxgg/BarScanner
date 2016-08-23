package barscanner.linuxgg.com.barscanner;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by tom on 2016/8/23.<p>
 * Version 1.0 <p>
 * Desc :    <p>
 */
public class MainApplication extends Application {
    private final static String TAG = MainApplication.class.getSimpleName();
    private static Context sAppContext;
    private FirebaseAnalytics mFirebaseAnalytics;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();
        try {
            // Obtain the FirebaseAnalytics instance.
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "name");
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);

    }
}
