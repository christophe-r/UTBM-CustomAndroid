package fr.utbm.lo52.CustomAndroid.mediacenter.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Season;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;
import fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder.SeasonsCardViewHolder;

public class SeasonActivity  extends AppCompatActivity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        final Serie serie = (Serie) IntentsHelper.getDetailActivityData(getIntent());

        setTitle(serie.getTitle());

        RecyclerView listRecyclerView = (RecyclerView) findViewById(R.id.seasonRecyclerView);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        listRecyclerView.setAdapter(new CardsListAdapter<Season>(serie.getSeasons(), SeasonsCardViewHolder.class, R.layout.cell_card_big));

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
