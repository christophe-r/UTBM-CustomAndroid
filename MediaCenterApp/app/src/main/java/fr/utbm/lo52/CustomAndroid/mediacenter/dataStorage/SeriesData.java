package fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.MovieDetailsActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.JsonFileReader;

/**
 * Created by vmars on 03/12/2016.
 */

public class SeriesData extends JsonFileReader implements PreviewableData{

    private List<Serie> listSeries = new ArrayList<>();
    private List<Preview> listSeriesPreview = new ArrayList<>();

    public SeriesData(String path, String jsonFile) {
        super(path, jsonFile);
        this.parse();
    }

    public void parse(){

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
                    listSeriesPreview.add(new Preview(c.getString("titleSerie"),  c.getString("illustrationPath"), serie, Object.class)); // TODO create a series detail activity

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

    public List<Serie> getList(){
        return listSeries;
    }


    @Override
    public List<Preview> getPreview() {
        return listSeriesPreview;
    }
}