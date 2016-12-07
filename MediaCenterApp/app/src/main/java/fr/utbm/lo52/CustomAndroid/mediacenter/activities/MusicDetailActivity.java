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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Album;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Track;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;
import fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder.TrackCardViewHolder;

/**
 * Created by vmars on 07/12/2016.
 */

public class MusicDetailActivity extends AppCompatActivity {

    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_music);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        final Album album = (Album) IntentsHelper.getDetailActivityData(getIntent());

        setTitle(album.getTitle());

        ((TextView) findViewById(R.id.music_year)).setText(album.getYear());
        ((TextView) findViewById(R.id.music_autor)).setText(album.getAuthor());

        ImageView movieIllustration = (ImageView) findViewById(R.id.music_illustration);
        RecyclerView subRecyclerView = (RecyclerView) findViewById(R.id.music_detail_sub_recycler_view);

        subRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        //subRecyclerView.setNestedScrollingEnabled(false);
        subRecyclerView.setAdapter(new CardsListAdapter<Track>(album.getTracks(), TrackCardViewHolder.class, R.layout.cell_card_small));


        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), album.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            movieIllustration.setImageBitmap(myBitmap);
        }

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
