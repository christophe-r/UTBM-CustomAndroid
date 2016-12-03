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
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.views.SeriesCardsViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.dataStorage.SeriesData;


public class SeriesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FragmentActivity c = getActivity();

        View rootView =  inflater.inflate(R.layout.fragment_movies, container, false);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(c);

        SeriesData jsonData = new SeriesData(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), "medias_series.json");
        jsonData.readSeries();

        List<Serie> series = jsonData.getListSeries();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewMovies);
        //recyclerView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
        recyclerView.setAdapter(new CardsListAdapter<Serie>(series, SeriesCardsViewHolder.class, R.layout.cell_card_serie));

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Series");
    }
}