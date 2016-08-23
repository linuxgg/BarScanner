package barscanner.linuxgg.com.barscanner;

import android.content.Context;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.zxing.client.android.BuildConfig;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by tom on 2016/8/23.<p>
 * Version 1.0 <p>
 * Desc :    <p>
 */
public class MyHttphelper {

    public final static String TAG = MyHttphelper.class.getSimpleName();

    public static void sendDetail(final Context context, final Camera.Parameters parameters) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                postAddPhones(context, parameters);
                return null;
            }
        }.execute();

    }

    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("text/x-markdown; charset=utf-8");
    public static final MediaType MEDIATYPE_JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void postAddPhones(Context context, Camera.Parameters params) {
        if (BuildConfig.DEBUG) {
//            Log.d(TAG, new Gson().toJson(params));
            Log.d(TAG, "start request");

        }

        PhoneDetail phoneDetail = new PhoneDetail();

        phoneDetail.setUuid(System.currentTimeMillis() + "");
        phoneDetail.setBrand(Build.BRAND);
        phoneDetail.setModel(Build.MODEL);
        phoneDetail.setOs(Build.FINGERPRINT);
        phoneDetail.setOs(Build.VERSION.CODENAME + " " + Build.VERSION.RELEASE);


        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        phoneDetail.setImei(tm.getDeviceId());


        phoneDetail.setDetails(System.currentTimeMillis() + "");
//        phoneDetail.setDetails(new Gson().toJson(params));

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(MEDIATYPE_JSON, new Gson().toJson(phoneDetail));
        Log.d(TAG, "send JSON:" + new Gson().toJson(phoneDetail));
        Request request = new Request.Builder()
                .url(HttpConstants.url + "/addPhones")
                .post(body)
                .build();
//        Request request = new Request.Builder()
//                .url(HttpConstants.url)
//                .get()
//                .build();

        try {

            Response response = okHttpClient.newCall(request).execute();
            Log.d(TAG, "----get result:");
            Log.d(TAG, response.code() + "   string().length()::" + response.body().string().length());
            Log.d(TAG, response.code() + "   contentLength " + response.body().contentLength());
            Log.d(TAG, response.code() + "  contentType()  " + response.body().contentType());
            Log.d(TAG, response.code() + "  isSuccessful():: " + response.isSuccessful());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
