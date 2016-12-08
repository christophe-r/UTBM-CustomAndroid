package fr.utbm.lo52.CustomAndroid.mediacenter.activities;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

public class MovieDetailsActivity extends AppCompatActivity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        final Movie movie = (Movie) IntentsHelper.getDetailActivityData(getIntent());

        setTitle(movie.getTitle());

        ((TextView) findViewById(R.id.movie_year)).setText(movie.getYear());
        ((TextView) findViewById(R.id.movie_director)).setText(movie.getDirector());
        ((TextView) findViewById(R.id.movie_actors)).setText((movie.getActors().equals(""))?"No actors":movie.getActors());
        ((TextView) findViewById(R.id.movie_summary)).setText(Html.fromHtml(movie.getSummary()));

        ImageView movieIllustration = (ImageView) findViewById(R.id.movie_illustration);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.movie_floatingActionButton_watch);

        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), movie.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            movieIllustration.setImageBitmap(myBitmap);
        }


        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                IntentsHelper.startWatchActivity(movie.getTitle(),  movie.getMediaPath());
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
}
