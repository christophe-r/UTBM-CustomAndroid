package fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.JsonFileReader;

/**
 * Created by vmars on 03/12/2016.
 */

public class PreviewData extends JsonFileReader {

    private List<Preview> listPreview = new ArrayList<>();
    private String dataKey;

    public PreviewData(String path, String jsonFile, String dataKey) {
        super(path, jsonFile);
        this.dataKey = dataKey;
        this.parse();
    }

    public void parse(){

        if( jsonObj != null ){

            JSONArray data = null;
            try {

                data = jsonObj.getJSONArray(dataKey);

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);

                    Iterator<String> iter = c.keys();
                    while (iter.hasNext()) {
                        String key = iter.next();
                        if(key.contains("title")){
                            listPreview.add(new Preview(c.getString(key),
                                    c.getString("illustrationPath")));
                            break;
                        }
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Preview> getPreviewData(){
        return listPreview;
    }

}
