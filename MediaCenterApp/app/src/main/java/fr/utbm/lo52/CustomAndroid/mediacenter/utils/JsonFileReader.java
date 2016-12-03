package fr.utbm.lo52.CustomAndroid.mediacenter.utils;

import android.util.Log;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by Christophe on 2016-11-29.
 */

public class JsonFileReader {

    private File jsonFile = null;
    protected JSONObject jsonObj = null;


    public JsonFileReader(String path, String jsonFile){

        this.jsonFile = new File(path, jsonFile);
        if( this.jsonFile.exists() ){
            Log.v("JSON File Found", this.jsonFile.getPath());
            jsonObj = readJsonFile();
        } else {
            Log.e("JSON File Not Found", this.jsonFile.getPath());
            this.jsonFile = null;
        }


    }

    public JSONObject readJsonFile(){

        try {
            FileInputStream stream = new FileInputStream(jsonFile);

            String jsonStr = null;
            try {
                FileChannel fc = stream.getChannel();
                MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

                jsonStr = Charset.defaultCharset().decode(bb).toString();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally {
                stream.close();
            }

            return (new JSONObject(jsonStr));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public JSONObject getJsonObj() {
        return jsonObj;
    }

}

