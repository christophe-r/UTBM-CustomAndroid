package fr.utbm.lo52.CustomAndroid.mediacenter.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.Model.Video;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by Christophe on 2016-11-29.
 */

public class VideoCardsViewHolder extends RecyclerView.ViewHolder{

    private TextView videoTitleView;
    private TextView videoYearView;
    private ImageView videoImageView;

    //itemView est la vue correspondante à 1 cellule
    public VideoCardsViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        videoTitleView = (TextView) itemView.findViewById(R.id.video_title);
        videoYearView = (TextView) itemView.findViewById(R.id.video_year);
        videoImageView = (ImageView) itemView.findViewById(R.id.video_image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un Video
    public void bind(Video video){
        videoTitleView.setText(video.getTitle());
        videoYearView.setText(video.getYear());

        File imgFile = new File(Environment.getExternalStorageDirectory()+"/MediaCenter/", video.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            videoImageView.setImageBitmap(myBitmap);

        } else {
            Log.e("File Not Found", imgFile.getPath());
        }

    }
}