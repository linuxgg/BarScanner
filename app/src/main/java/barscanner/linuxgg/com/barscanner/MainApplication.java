package barscanner.linuxgg.com.barscanner;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;
import com.google.zxing.client.android.BuildConfig;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by tom on 2016/8/23.<p>
 * Version 1.0 <p>
 * Desc :    <p>
 */
public class MainApplication extends Application {
    private final static String TAG = MainApplication.class.getSimpleName();
    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();

        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);

        try {
            if (BuildConfig.DEBUG) {
                Log.d(TAG, "FirebaseCrash.isSingletonInitialized():" + FirebaseCrash.isSingletonInitialized());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
