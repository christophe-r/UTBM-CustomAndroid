package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.View;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.SmallCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

/**
 * Created by vmars on 03/12/2016.
 */

public class EpisodesCardViewHolder extends SmallCardViewHolder {

    protected EpisodesCardViewHolder(View itemView) {
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

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(context)
                        .setTitle("Episode " + episode.getEpNumber() + ": " + episode.getTitle())
                        .setMessage(Html.fromHtml(episode.getSummary()))
                        .setPositiveButton(R.string.label_watch, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                IntentsHelper.startWatchActivity("Episode " + episode.getEpNumber() + ": " + episode.getTitle(),  episode.getMediaPath());
                            }
                        })
                        .setNegativeButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                        .show();
            }
        });


    }
}
