package fr.utbm.lo52.CustomAndroid.mediacenter.models.dataStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.JsonFileReader;

/**
 * Created by vmars on 03/12/2016.
 */

public class SeriesData extends JsonFileReader {

    private List<Serie> listSeries = new ArrayList<>();

    public SeriesData(String path, String jsonFile) {
        super(path, jsonFile);
    }

    public void readSeries(){

        if( jsonObj != null ){

            JSONArray data = null;
            try {
                data = jsonObj.getJSONArray("series");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    Serie serie = new Serie(c.getString("titleSerie"),
                            c.getString("year"),
                            c.getString("illustrationPath"),
                            c.getString("actors"),
                            c.getString("season"));

                    listSeries.add(serie);

                    JSONArray episode = null;
                    episode = c.getJSONArray("episodes");
                    for (int j = 0; j < episode.length(); j++) {
                        JSONObject d = episode.getJSONObject(j);
                        serie.addEpisode(new Episode(d.getString("summary"), d.getString("mediaPath"), d.getString("episodeNb"), d.getString("titleEpisode")));

                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Serie> getListSeries(){
        return listSeries;
    }


}