package fr.utbm.lo52.CustomAndroid.mediacenter.adapters.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;

/**
 * Created by vmars on 03/12/2016.
 */

public class EpisodeCardsViewHolder extends CardsViewHolder {

    private TextView episodeNumberView;
    private TextView episodeTitleView;
    private final Context context;


    protected EpisodeCardsViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();

        episodeNumberView = (TextView) itemView.findViewById(R.id.episode_number);
        episodeTitleView = (TextView) itemView.findViewById(R.id.episode_title);

    }

    @Override
    public void bind(Object data) {
        final Episode episode = (Episode) data;
        episodeNumberView.setText(episode.getEpNumber());
        episodeTitleView.setText(episode.getTitle());

    }
}
