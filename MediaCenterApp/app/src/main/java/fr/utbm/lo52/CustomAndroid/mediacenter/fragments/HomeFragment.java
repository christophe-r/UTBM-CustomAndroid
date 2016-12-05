package fr.utbm.lo52.CustomAndroid.mediacenter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.PreviewData;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.Factory;
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

        PreviewData moviesPreviewData = (PreviewData) Factory.get("Preview-movies");
        PreviewData seriesPreviewData = (PreviewData) Factory.get("Preview-series");
        PreviewData musicsPreviewData = (PreviewData) Factory.get("Preview-music");

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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getString(R.string.title_home));
    }
}
