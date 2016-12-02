package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by Christophe on 2016-11-29.
 */

public class MoviesCardsAdapter extends RecyclerView.Adapter<MoviesCardsViewHolder> {

    List<Movie> list;

    public MoviesCardsAdapter(List<Movie> list) {
        this.list = list;
    }

    @Override
    public MoviesCardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_cell_card, viewGroup, false);
        return new MoviesCardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesCardsViewHolder moviesCardsViewHolder, int position) {
        Movie movie = list.get(position);
        moviesCardsViewHolder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}