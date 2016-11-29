package fr.utbm.lo52.CustomAndroid.mediacenter.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.Model.Video;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.View.VideoCardsAdapter;


public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Video> movies = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final FragmentActivity c = getActivity();
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView =  inflater.inflate(R.layout.fragment_movies, container, false);


        movies.add(new Video("France","Paris", "movies/big_buck_bunny.jpg"));
        movies.add(new Video("Italy","Roma", "movies/coffee.jpg"));
        movies.add(new Video("UK","London", "movies/big_buck_bunny.jpg"));
        movies.add(new Video("Germany","Berlin", "movies/coffee.jpg"));
        movies.add(new Video("Spain","Madrid", "movies/big_buck_bunny.jpg"));

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewMovies);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(c));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un VideoCardsAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new VideoCardsAdapter(movies));

        return rootView;

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Movies");
    }
}