package fr.utbm.lo52.CustomAndroid.mediacenter.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        Intent i = getIntent();
        Movie movie = (Movie) i.getSerializableExtra("Movie");

        setTitle(movie.getTitle());

        ImageView movieIllustration = (ImageView) findViewById(R.id.movie_illustration);
        TextView movieYear = (TextView) findViewById(R.id.movie_year);
        TextView movieDirector = (TextView) findViewById(R.id.movie_director);
        TextView movieActors = (TextView) findViewById(R.id.movie_actors);
        TextView movieSummary = (TextView) findViewById(R.id.movie_summary);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.movie_floatingActionButton_watch);

        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), movie.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            movieIllustration.setImageBitmap(myBitmap);
        }

        movieYear.setText(movie.getYear());
        movieDirector.setText(movie.getDirector());
        movieActors.setText((movie.getActors().equals(""))?"No actors":movie.getActors());
        movieSummary.setText(Html.fromHtml(movie.getSummary()));



        fab.setOnClickListener(new WatchButtonOnClickListener(movie){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WatchActivity.class);

                intent.putExtra("VIDEO_TITLE", movie.getTitle());
                intent.putExtra("VIDEO_PATH", movie.getMediaPath());
                v.getContext().startActivity(intent);
            }

        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
