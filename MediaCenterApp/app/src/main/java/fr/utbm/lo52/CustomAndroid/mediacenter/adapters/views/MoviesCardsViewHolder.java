package fr.utbm.lo52.CustomAndroid.mediacenter.adapters.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by Christophe on 2016-11-29.
 */

public class MoviesCardsViewHolder extends CardsViewHolder {

    private TextView videoTitleView;
    private TextView videoYearView;
    private ImageView videoImageView;
    private Button videoButtonWatch;
    private Button videoButtonMoreDetail;
    private final Context context;
    private SharedPreferences sp;

    public MoviesCardsViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();

        sp = PreferenceManager.getDefaultSharedPreferences(context);

        videoTitleView = (TextView) itemView.findViewById(R.id.movie_title);
        videoYearView = (TextView) itemView.findViewById(R.id.movie_year);
        videoImageView = (ImageView) itemView.findViewById(R.id.movie_image);
        videoButtonWatch = (Button) itemView.findViewById(R.id.movie_button_watch);
        videoButtonMoreDetail = (Button) itemView.findViewById(R.id.movie_button_more_details);

    }

    @Override
    public void bind(Object data) {
        Movie movie = (Movie) data;
        videoTitleView.setText(movie.getTitle());
        videoYearView.setText(movie.getYear());

        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), movie.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            videoImageView.setImageBitmap(myBitmap);

        } else {
            Log.e("File Not Found", imgFile.getPath());
        }

        videoButtonWatch.setOnClickListener(new WatchButtonOnClickListener(movie){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WatchActivity.class);

                intent.putExtra("VIDEO_TITLE", movie.getTitle());
                intent.putExtra("VIDEO_PATH", movie.getMediaPath());
                v.getContext().startActivity(intent);
            }

        });
        videoButtonMoreDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("message").setTitle("titre");
                AlertDialog dialog = builder.create();
                dialog.show();
                // TODO Create a activity to display the detail of a movie
            }

        });

    }


    public class WatchButtonOnClickListener implements View.OnClickListener{

        Movie movie;

        public WatchButtonOnClickListener(Movie movie) {
            this.movie = movie;
        }

        @Override
        public void onClick(View v){}

    };


}

