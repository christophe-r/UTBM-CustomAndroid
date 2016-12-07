package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.SmallCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

/**
 * Created by vmars on 03/12/2016.
 */

public class EpisodeCardViewHolder extends SmallCardViewHolder {

    protected EpisodeCardViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void bind(Object data) {
        final Episode episode = (Episode) data;
        numberView.setText(episode.getEpNumber());
        titleView.setText(episode.getTitle());

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                IntentsHelper.startWatchActivity("Episode " + episode.getEpNumber() + ": " + episode.getTitle(),  episode.getMediaPath());
            }

        });
    }
}
