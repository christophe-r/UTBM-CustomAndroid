package fr.utbm.lo52.CustomAndroid.mediacenter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.utils.MediasJsonFile;

/**
 * Created by Christophe on 2016-11-29.
 */

public class MoviesData extends MediasJsonFile {

    private List<Movie> listMovies = new ArrayList<>();

    public MoviesData(String path, String jsonFile) {
        super(path, jsonFile);
    }

    public void readMovies(){

        if( jsonObj != null ){

            JSONArray data = null;
            try {
                data = jsonObj.getJSONArray("movies");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    listMovies.add(new Movie(c.getString("title"),
                                             c.getString("year"),
                                             c.getString("illustrationPath"),
                                             c.getString("mediaPath"),
                                             c.getString("actors"),
                                             c.getString("director"),
                                             c.getString("summary")));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Movie> getListMovies(){
        return listMovies;
    }


}
