package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.MovieDetailsActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by Christophe on 2016-11-29.
 */

public class MoviesCardsViewHolder extends RecyclerView.ViewHolder{

    private CardView movieCardView;
    private TextView movieTitleView;
    private TextView movieYearView;
    private ImageView movieImageView;

    private Button movieButtonWatch;
    private final Context context;
    private SharedPreferences sp;

    public MoviesCardsViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();

        sp = PreferenceManager.getDefaultSharedPreferences(context);

        movieCardView = (CardView) itemView.findViewById(R.id.movie_cardview);
        movieTitleView = (TextView) itemView.findViewById(R.id.movie_title);
        movieYearView = (TextView) itemView.findViewById(R.id.movie_year);
        movieImageView = (ImageView) itemView.findViewById(R.id.movie_image);
        movieButtonWatch = (Button) itemView.findViewById(R.id.movie_button_watch);


    }

    public void bind(Movie movie){
        movieTitleView.setText(movie.getTitle());
        movieYearView.setText(movie.getYear());

        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), movie.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            movieImageView.setImageBitmap(myBitmap);

        } else {
            Log.e("File Not Found", imgFile.getPath());
        }

        movieButtonWatch.setOnClickListener(new WatchButtonOnClickListener(movie){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WatchActivity.class);

                intent.putExtra("VIDEO_TITLE", movie.getTitle());
                intent.putExtra("VIDEO_PATH", movie.getMediaPath());
                v.getContext().startActivity(intent);
            }

        });

        movieCardView.setOnClickListener(new WatchButtonOnClickListener(movie) {
            @Override
            public void onClick(View v) {
                Intent movieDetailsIntent = new Intent(context, MovieDetailsActivity.class);
                movieDetailsIntent.putExtra("Movie", movie);
                context.startActivity(movieDetailsIntent);
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

