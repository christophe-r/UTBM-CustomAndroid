package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;


import android.view.View;

import java.io.Serializable;

import fr.utbm.lo52.CustomAndroid.mediacenter.activities.SeasonActivity;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;


/**
 * Created by vmars on 08/12/2016.
 */

public class SeriesCardViewHolder extends PreviewCardViewHolder {
    protected SeriesCardViewHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void bind(Object data) {
        final Serie serie = (Serie) data;

        titlePreviewView.setText(serie.getTitle());
        setImage(serie.getIllustrationPath(), imagePreviewView);

        imagePreviewView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    IntentsHelper.startDetailActivity(SeasonActivity.class, (Serializable) serie);
            }

        });
    }

}
