package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.BigCardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Album;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Track;

/**
 * Created by vmars on 04/12/2016.
 */

public class MusicCardViewHolder extends BigCardViewHolder {

    private boolean isEpisodeMenuOpen = false;
    private Drawable iconClose;
    private Drawable iconOpen;

    protected MusicCardViewHolder(View itemView) {
        super(itemView);

        iconOpen = context.getResources().getDrawable(R.drawable.ic_more_open_24dp);
        iconClose = context.getResources().getDrawable(R.drawable.ic_more_close_24dp);

        buttonView.setText(R.string.label_tracks);
        buttonView.setCompoundDrawablesWithIntrinsicBounds(null, null, iconClose, null);
    }

    @Override
    public void bind(Object data) {

        final Album album = (Album) data;

        titleView.setText(album.getTitle());
        subTitleView.setText(context.getString(R.string.label_author)+" " + album.getAuthor() + "\n"+context.getString(R.string.label_year)+" " + album.getYear());

        subRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        subRecyclerView.setAdapter(new CardsListAdapter<Track>(album.getTracks(), TrackCardViewHolder.class, R.layout.cell_card_small));

        setImage(album.getIllustrationPath());

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
