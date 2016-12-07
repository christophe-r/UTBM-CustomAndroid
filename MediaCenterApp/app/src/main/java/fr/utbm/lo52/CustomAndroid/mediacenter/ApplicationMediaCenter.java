package fr.utbm.lo52.CustomAndroid.mediacenter;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.MoviesData;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.MusicsData;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.SeriesData;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.Factory;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

/**
 * Created by vmars on 04/12/2016.
 */

public class ApplicationMediaCenter extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Application startup code

        // Load data inside the factory
        loadDataFromJson();

        //Save the context for intents
        IntentsHelper.setContext(getBaseContext());
    }

    public void loadDataFromJson(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String path = sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/");
        Factory.set("JsonData-movies", new MoviesData(path, "medias_movies.json"));
        Factory.set("JsonData-series", new SeriesData(path, "medias_series.json"));
        Factory.set("JsonData-music", new MusicsData(path, "medias_music.json"));

    }
}
