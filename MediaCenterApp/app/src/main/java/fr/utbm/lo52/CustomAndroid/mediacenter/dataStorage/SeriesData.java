package fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.SeasonActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Season;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.JsonFileReader;

/**
 * Created by vmars on 03/12/2016.
 */

public class SeriesData extends JsonFileReader implements PreviewableData{

    private Map<String, Serie> mapSeries = new HashMap<>();
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

                    Season season = new Season(c.getString("titleSerie"),
                            c.getString("year"),
                            c.getString("illustrationPath"),
                            c.getString("actors"),
                            c.getString("season"));

                    if(mapSeries.containsKey(c.getString("titleSerie"))) {
                        mapSeries.get(c.getString("titleSerie")).addSeason(season);

                    }else{
                        Serie serie = new Serie(c.getString("titleSerie"), c.getString("illustrationPath"));
                        mapSeries.put(c.getString("titleSerie"), serie);
                        serie.addSeason(season);
                    }



                    JSONArray episode = null;
                    episode = c.getJSONArray("episodes");
                    for (int j = 0; j < episode.length(); j++) {
                        JSONObject d = episode.getJSONObject(j);
                        season.addEpisode(new Episode(d.getString("summary"), d.getString("mediaPath"), d.getString("episodeNb"), d.getString("titleEpisode")));
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            listSeries = new ArrayList<Serie>(mapSeries.values());

            for (Serie serie : listSeries)
                listSeriesPreview.add(new Preview(serie.getTitle(),  serie.getIllustrationPath(), serie, SeasonActivity.class));
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