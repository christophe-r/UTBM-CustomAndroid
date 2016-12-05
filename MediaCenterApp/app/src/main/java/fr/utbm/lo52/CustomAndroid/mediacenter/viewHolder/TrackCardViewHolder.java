package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Intent;
import android.view.View;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.SmallCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Track;

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

                Intent intent = new Intent(v.getContext(), WatchActivity.class);

                intent.putExtra("VIDEO_TITLE", track.getTrackNumber() + " - " + track.getTitle());
                intent.putExtra("VIDEO_PATH", track.getMediaPath());
                v.getContext().startActivity(intent);
            }

        });
    }
}
