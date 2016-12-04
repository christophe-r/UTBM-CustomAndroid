package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.File;


/**
 * Created by vmars on 02/12/2016.
 */

public abstract class CardViewHolder extends RecyclerView.ViewHolder{

    protected final Context context;
    protected SharedPreferences sp;

    protected CardViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }


    public abstract void bind(Object data);

    protected void setImage(String relativePath, ImageView view){
        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), relativePath);

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            view.setImageBitmap(myBitmap);

        } else {
            Log.e("File Not Found", imgFile.getPath());
        }
    }


}
