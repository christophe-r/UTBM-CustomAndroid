package fr.utbm.lo52.CustomAndroid.mediacenter.fragments;

import android.os.Bundle;
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
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.Factory;
import fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder.SeriesCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.SeriesData;


public class SeriesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FragmentActivity c = getActivity();

        View rootView =  inflater.inflate(R.layout.fragment_list, container, false);

        SeriesData seriesData = (SeriesData) Factory.get("Data-series");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewListCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
        recyclerView.setAdapter(new CardsListAdapter<Serie>(seriesData.getList(), SeriesCardViewHolder.class, R.layout.cell_card_serie));

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Series");
    }
}