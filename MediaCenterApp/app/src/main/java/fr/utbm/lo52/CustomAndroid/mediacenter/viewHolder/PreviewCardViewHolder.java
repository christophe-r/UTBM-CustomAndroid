package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.MovieDetailsActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;

/**
 * Created by vmars on 03/12/2016.
 */

public class PreviewCardViewHolder extends CardViewHolder {

    private ImageView imagePreviewView;
    private TextView titlePreviewView;
    private final Context context;
    private SharedPreferences sp;


    protected PreviewCardViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        sp = PreferenceManager.getDefaultSharedPreferences(context);

        imagePreviewView = (ImageView) itemView.findViewById(R.id.preview_img);
        titlePreviewView = (TextView) itemView.findViewById(R.id.preview_title);

    }

    @Override
    public void bind(Object data) {
        final Preview preview = (Preview) data;

        titlePreviewView.setText(preview.getTitle());

        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), preview.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            imagePreviewView.setImageBitmap(myBitmap);

        } else {
            Log.e("File Not Found", imgFile.getPath());
        }


        imagePreviewView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               /* Intent movieDetailsIntent = new Intent(context, MovieDetailsActivity.class);
                movieDetailsIntent.putExtra("Movie", movie);
                context.startActivity(movieDetailsIntent);*/
            }

        });
    }
}
