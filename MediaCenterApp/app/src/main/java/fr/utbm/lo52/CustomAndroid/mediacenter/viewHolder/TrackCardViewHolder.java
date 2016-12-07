package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.view.View;

import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.SmallCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Track;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

/**
 * Created by vmars on 04/12/2016.
 */

public class TrackCardViewHolder extends SmallCardViewHolder {

    protected TrackCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Object data) {
        final Track track = (Track) data;
        numberView.setText(track.getTrackNumber());
        titleView.setText(track.getTitle());

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                IntentsHelper.startWatchActivity( track.getTrackNumber() + " - " + track.getTitle(), track.getMediaPath());
            }

        });
    }
}
