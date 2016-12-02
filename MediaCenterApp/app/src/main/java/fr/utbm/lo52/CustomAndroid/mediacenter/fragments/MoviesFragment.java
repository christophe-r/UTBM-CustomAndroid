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

import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.MoviesData;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.MoviesCardsAdapter;


public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final FragmentActivity c = getActivity();

        View rootView =  inflater.inflate(R.layout.fragment_movies, container, false);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(c);

        MoviesData jsonData = new MoviesData(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), "medias_movies.json");
        jsonData.readMovies();

        List<Movie> movies = jsonData.getListMovies();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
        recyclerView.setAdapter(new MoviesCardsAdapter(movies));

        return rootView;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Movies");
    }
}