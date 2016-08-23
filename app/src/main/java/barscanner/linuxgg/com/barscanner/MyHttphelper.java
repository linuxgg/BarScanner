package barscanner.linuxgg.com.barscanner;

import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by tom on 2016/8/23.<p>
 * Version 1.0 <p>
 * Desc :    <p>
 */
public class MyHttphelper {

    public final static String TAG = MyHttphelper.class.getSimpleName();

    public static void sendDetail(final Camera.Parameters parameters) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                postAddPhones(parameters);
                return null;
            }
        }.execute();

    }

    public static void postAddPhones(Camera.Parameters params) {
        Log.d(TAG, new Gson().toJson(params));
    }
}
