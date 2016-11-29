package fr.utbm.lo52.CustomAndroid.mediacenter.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christophe on 2016-11-29.
 */

public class MoviesData extends MediasJsonFile {

    private List<Movie> listMovies = new ArrayList<>();

    public MoviesData(String jsonFile) {
        super(jsonFile);
    }

    public void readMovies(){

        if( jsonObj != null ){

            JSONArray data = null;
            try {
                data = jsonObj.getJSONArray("movies");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    listMovies.add(new Movie(c.getString("title"), c.getString("year"), c.getString("illustrationPath"), c.getString("mediaPath"),
                            c.getString("actors"), c.getString("director"), c.getString("summary")));
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
