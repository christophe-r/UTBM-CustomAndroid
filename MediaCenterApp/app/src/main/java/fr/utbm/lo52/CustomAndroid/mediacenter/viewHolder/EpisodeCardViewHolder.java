package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.activities.WatchActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;

/**
 * Created by vmars on 03/12/2016.
 */

public class EpisodeCardViewHolder extends CardViewHolder {

    private TextView episodeNumberView;
    private TextView episodeTitleView;
    private ImageView episodePlayView;
    private final Context context;


    protected EpisodeCardViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();

        episodeNumberView = (TextView) itemView.findViewById(R.id.episode_number);
        episodeTitleView = (TextView) itemView.findViewById(R.id.episode_title);
        episodePlayView = (ImageView) itemView.findViewById(R.id.episode_play);

    }

    @Override
    public void bind(Object data) {
        final Episode episode = (Episode) data;
        episodeNumberView.setText(episode.getEpNumber());
        episodeTitleView.setText(episode.getTitle());

        episodePlayView.setOnClickListener(new View.OnClickListener(){
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
