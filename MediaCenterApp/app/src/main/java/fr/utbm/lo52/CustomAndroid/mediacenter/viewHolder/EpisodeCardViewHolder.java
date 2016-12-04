package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.SmallCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;

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

                Intent intent = new Intent(v.getContext(), WatchActivity.class);

                intent.putExtra("VIDEO_TITLE","Episode " + episode.getEpNumber() + ": " + episode.getTitle());
                intent.putExtra("VIDEO_PATH", episode.getMediaPath());
                v.getContext().startActivity(intent);
            }

        });
    }
}
