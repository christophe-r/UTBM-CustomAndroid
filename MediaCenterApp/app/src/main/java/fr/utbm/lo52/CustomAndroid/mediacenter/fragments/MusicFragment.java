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
import fr.utbm.lo52.CustomAndroid.mediacenter.dataStorage.MusicsData;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Album;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.Factory;
import fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder.MusicCardViewHolder;


public class MusicFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final FragmentActivity c = getActivity();

        View rootView =  inflater.inflate(R.layout.fragment_list, container, false);

        MusicsData musicsData = (MusicsData) Factory.get("JsonData-music");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewListCards);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
        recyclerView.setAdapter(new CardsListAdapter<Album>(musicsData.getList(), MusicCardViewHolder.class, R.layout.cell_card_big));

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getString(R.string.title_music));
    }
}