package fr.utbm.lo52.CustomAndroid.mediacenter.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.MoviesData;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.PreviewData;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder.MoviesCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder.PreviewCardViewHolder;

/**
 * Created by vmars on 03/12/2016.
 */

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewHomeMovies;
    private RecyclerView recyclerViewHomeSeries;
    private RecyclerView recyclerViewHomeMusics;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final FragmentActivity c = getActivity();

        View rootView =  inflater.inflate(R.layout.fragment_home, container, false);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(c);
        String path = sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/");

        PreviewData moviesPreviewData = new PreviewData(path, "medias_movies.json", "movies");
        PreviewData seriesPreviewData = new PreviewData(path, "medias_series.json", "series");
        PreviewData musicsPreviewData = new PreviewData(path, "medias_music.json", "music");


        recyclerViewHomeMovies = (RecyclerView) rootView.findViewById(R.id.recyclerViewHomeMovies);
        recyclerViewHomeMovies.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHomeMovies.setAdapter(new CardsListAdapter<Preview>(moviesPreviewData.getPreviewData(), PreviewCardViewHolder.class, R.layout.cell_card_preview));

        recyclerViewHomeSeries = (RecyclerView) rootView.findViewById(R.id.recyclerViewHomeSeries);
        recyclerViewHomeSeries.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHomeSeries.setAdapter(new CardsListAdapter<Preview>(seriesPreviewData.getPreviewData(), PreviewCardViewHolder.class, R.layout.cell_card_preview));

        recyclerViewHomeMusics = (RecyclerView) rootView.findViewById(R.id.recyclerViewHomeMusics);
        recyclerViewHomeMusics.setLayoutManager(new LinearLayoutManager(c, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHomeMusics.setAdapter(new CardsListAdapter<Preview>(musicsPreviewData.getPreviewData(), PreviewCardViewHolder.class, R.layout.cell_card_preview));

        return rootView;

    }

    public void configureRecyclerView(){

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Movies");
    }
}
