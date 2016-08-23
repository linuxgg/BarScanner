package barscanner.linuxgg.com.barscanner;

import android.app.Application;
import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by tom on 2016/8/23.<p>
 * Version 1.0 <p>
 * Desc :    <p>
 */
public class MainApplication extends Application {

    private static Context sAppContext;

    public static Context getAppContext() {
        return sAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();

        MobclickAgent.setScenarioType(MainApplication.this, MobclickAgent.EScenarioType.E_UM_NORMAL);

    }
}
