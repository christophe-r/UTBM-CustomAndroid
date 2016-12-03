package fr.utbm.lo52.CustomAndroid.mediacenter;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.MoviesData;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.PreviewData;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.SeriesData;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.Factory;

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

    }

    public void loadDataFromJson(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String path = sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/");
        Factory.set("Data-movies", new MoviesData(path, "medias_movies.json"));
        Factory.set("Data-series", new SeriesData(path, "medias_series.json"));
        Factory.set("Data-music", new Object());

        Factory.set("Preview-movies", new PreviewData(path, "medias_movies.json", "movies" ));
        Factory.set("Preview-series", new PreviewData(path, "medias_series.json", "series" ));
        Factory.set("Preview-music", new PreviewData(path, "medias_music.json", "music" ));

    }
}
