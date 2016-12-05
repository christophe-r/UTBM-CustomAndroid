package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Intent;
import android.view.View;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.MovieDetailsActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.BigCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Movie;

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
        subTitleView.setText(movie.getYear());
        buttonView.setText(R.string.label_watch);
        mainLayout.removeView(subRecyclerView);

        setImage(movie.getIllustrationPath());

        buttonView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WatchActivity.class);

                intent.putExtra("VIDEO_TITLE", movie.getTitle());
                intent.putExtra("VIDEO_PATH", movie.getMediaPath());
                v.getContext().startActivity(intent);
            }

        });

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent movieDetailsIntent = new Intent(context, MovieDetailsActivity.class);
                movieDetailsIntent.putExtra("Movie", movie);
                context.startActivity(movieDetailsIntent);
            }
        });

    }



}

