package fr.utbm.lo52.CustomAndroid.mediacenter.utils;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by vmars on 07/12/2016.
 */

public class IntentsHelper {

    private static Context appContext;

    public static void setContext(Context context){
        appContext = context;
    }

    public static void startWatchActivity(String title, String videoPath){
        Intent intent = new Intent(appContext, WatchActivity.class);
        intent.putExtra("VIDEO_TITLE", title);
        intent.putExtra("VIDEO_PATH", videoPath);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);

        appContext.startActivity(intent);
    }
    public static String[] getWatchActivityData(Intent i){
        Intent intent = new Intent(appContext, WatchActivity.class);
        return new String[]{i.getStringExtra("VIDEO_TITLE"), i.getStringExtra("VIDEO_PATH")};
    }

    public static void startDetailActivity(Class activity, Serializable data){
        Intent intent = new Intent(appContext, activity);
        intent.putExtra("DETAIL_DATA", data);
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);

        appContext.startActivity(intent);
    }
    public static Object getDetailActivityData(Intent i){
        return i.getSerializableExtra("DETAIL_DATA");
    }

}
