package fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.MusicDetailActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Album;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Track;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.JsonFileReader;

/**
 * Created by vmars on 04/12/2016.
 */

public class MusicsData  extends JsonFileReader implements PreviewableData{

    private List<Album> listAlbum = new ArrayList<>();
    private List<Preview> listAlbumPreview = new ArrayList<>();

    public MusicsData(String path, String jsonFile) {
        super(path, jsonFile);
        this.parse();
    }

    public void parse(){

        if( jsonObj != null ){

            JSONArray data = null;
            try {
                data = jsonObj.getJSONArray("music");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    Album album = new Album(c.getString("titleAlbum"),
                            c.getString("author"),
                            c.getString("illustrationPath"),
                            c.getString("year"));

                    listAlbum.add(album);
                    listAlbumPreview.add(new Preview(c.getString("titleAlbum"), c.getString("illustrationPath"), album, MusicDetailActivity.class));

                    JSONArray track = null;
                    track = c.getJSONArray("tracks");
                    for (int j = 0; j < track.length(); j++) {
                        JSONObject d = track.getJSONObject(j);
                        album.addTrack(new Track(d.getString("trackNb"), d.getString("titleTrack"), d.getString("mediaPath")));

                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Album> getList(){
        return listAlbum;
    }


    @Override
    public List<Preview> getPreview() {
        return listAlbumPreview;
    }
}
