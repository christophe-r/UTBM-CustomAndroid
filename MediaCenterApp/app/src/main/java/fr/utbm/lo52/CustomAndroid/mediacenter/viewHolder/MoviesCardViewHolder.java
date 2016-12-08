package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.view.View;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.MovieDetailsActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.BigCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

/**
 * Created by Christophe on 2016-11-29.
 */

public class MoviesCardViewHolder extends BigCardViewHolder {


    public MoviesCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(final Object data) {
        final Movie movie = (Movie) data;

        titleView.setText(movie.getTitle());
        subTitleView.setText(context.getString(R.string.label_year) + " " + movie.getYear() + "\n" +
                context.getString(R.string.label_director) + " " + movie.getDirector() + "\n" +
                context.getString(R.string.label_actors) + " " +((movie.getActors().equals(""))?"No actors":movie.getActors()));
        buttonView.setText(R.string.label_watch);
        mainLayout.removeView(subRecyclerView);

        setImage(movie.getIllustrationPath());

        buttonView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                IntentsHelper.startWatchActivity( movie.getTitle(),  movie.getMediaPath());
            }

        });

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                IntentsHelper.startDetailActivity(MovieDetailsActivity.class, movie);
            }
        });

    }



}

