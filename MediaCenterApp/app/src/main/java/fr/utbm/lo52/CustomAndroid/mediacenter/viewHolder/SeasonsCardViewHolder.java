package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.BigCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Season;

/**
 * Created by vmars on 03/12/2016.
 */

public class SeasonsCardViewHolder extends BigCardViewHolder {

    private boolean isEpisodeMenuOpen = false;
    private Drawable iconClose;
    private Drawable iconOpen;

    protected SeasonsCardViewHolder(View itemView) {
        super(itemView);

        iconOpen = context.getResources().getDrawable(R.drawable.ic_more_open_24dp);
        iconClose = context.getResources().getDrawable(R.drawable.ic_more_close_24dp);

        buttonView.setText(R.string.label_episodes);
        buttonView.setCompoundDrawablesWithIntrinsicBounds(null, null, iconClose, null);
    }

    @Override
    public void bind(Object data) {

        final Season season = (Season) data;

        titleView.setText(context.getString(R.string.label_season) + " " + season.getSeasonNumber());
        subTitleView.setText(season.getTitle() + "\n" +
                context.getString(R.string.label_year) + " " + season.getYear() + "\n" +
                ((season.getActors().equals(""))?"":season.getActors()));

        subRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        subRecyclerView.setAdapter(new CardsListAdapter<Episode>(season.getEpisodes(), EpisodesCardViewHolder.class, R.layout.cell_card_small));

        setImage(season.getIllustrationPath());

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
