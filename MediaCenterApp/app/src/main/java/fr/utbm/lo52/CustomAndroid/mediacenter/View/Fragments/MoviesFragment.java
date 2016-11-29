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

import fr.utbm.lo52.CustomAndroid.mediacenter.Model.MediasJsonFile;
import fr.utbm.lo52.CustomAndroid.mediacenter.Model.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.Model.MoviesData;
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

        MoviesData jsonData = new MoviesData("medias_movies.json");
        jsonData.readMovies();

        List<Movie> moviesList = jsonData.getListMovies();

        for (int i = 0; i < moviesList.size(); i++) {
            movies.add(new Video(moviesList.get(i).getTitle(), moviesList.get(i).getYear(), moviesList.get(i).getIllustrationPath()));
        }

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewMovies);
        recyclerView.setLayoutManager(new LinearLayoutManager(c));
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