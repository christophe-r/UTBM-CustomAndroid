package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.BigCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;

/**
 * Created by vmars on 03/12/2016.
 */

public class SeriesCardViewHolder extends BigCardViewHolder {

    private boolean isEpisodeMenuOpen = false;
    private Drawable iconClose;
    private Drawable iconOpen;

    protected SeriesCardViewHolder(View itemView) {
        super(itemView);

        iconOpen = context.getResources().getDrawable(R.drawable.ic_more_open_24dp);
        iconClose = context.getResources().getDrawable(R.drawable.ic_more_close_24dp);

        buttonView.setText(R.string.label_episodes);
        buttonView.setCompoundDrawablesWithIntrinsicBounds(null, null, iconClose, null);
    }

    @Override
    public void bind(Object data) {

        final Serie serie = (Serie) data;

        titleView.setText(serie.getTitle());
        subTitleView.setText(context.getString(R.string.label_season) + " " + serie.getSeason() + "\n"+ context.getString(R.string.label_year) + " " + serie.getYear());

        subRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        subRecyclerView.setAdapter(new CardsListAdapter<Episode>(serie.getEpisodes(), EpisodeCardViewHolder.class, R.layout.cell_card_small));

        setImage(serie.getIllustrationPath());

        buttonView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isEpisodeMenuOpen){
                    isEpisodeMenuOpen = true;
                    buttonView.setCompoundDrawablesWithIntrinsicBounds(null, null, iconOpen, null);
                    subRecyclerView.setVisibility(View.VISIBLE);
                }else{
                    isEpisodeMenuOpen = false;
                    buttonView.setCompoundDrawablesWithIntrinsicBounds(null, null, iconClose, null);
                    subRecyclerView.setVisibility(View.GONE);
                }
            }

        });

    }


}
