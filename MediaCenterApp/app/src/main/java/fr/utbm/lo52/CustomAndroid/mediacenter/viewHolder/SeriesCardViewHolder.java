package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardsListAdapter;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Episode;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Serie;

/**
 * Created by vmars on 03/12/2016.
 */

public class SeriesCardViewHolder extends CardViewHolder {

    private final Context context;
    private SharedPreferences sp;

    private TextView serieTitleView;
    private TextView serieSubTitleView;
    private ImageView serieImageView;
    private Button serieButtonWatch;
    private RecyclerView episodeRecyclerView;
    private boolean isEpisodeMenuOpen = false;
    private Drawable iconClose;
    private Drawable iconOpen;

    protected SeriesCardViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        sp = PreferenceManager.getDefaultSharedPreferences(context);

        serieTitleView = (TextView) itemView.findViewById(R.id.serie_title);
        serieSubTitleView = (TextView) itemView.findViewById(R.id.serie_subtitle);
        serieImageView = (ImageView) itemView.findViewById(R.id.serie_image);
        serieButtonWatch = (Button) itemView.findViewById(R.id.serie_show_episode);
        episodeRecyclerView = (RecyclerView) itemView.findViewById(R.id.episode_recycler_view);

        iconOpen = context.getResources().getDrawable(R.drawable.ic_more_open_24dp);
        iconClose = context.getResources().getDrawable(R.drawable.ic_more_close_24dp);
    }

    @Override
    public void bind(Object data) {

        final Serie serie = (Serie) data;

        serieTitleView.setText(serie.getTitle());
        serieSubTitleView.setText("Season " + serie.getSeason() + "\nYear: " + serie.getYear());
        episodeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        episodeRecyclerView.setAdapter(new CardsListAdapter<Episode>(serie.getEpisode(), EpisodeCardViewHolder.class, R.layout.cell_card_episode));

        File imgFile = new File(sp.getString("pref_mediacenter_path", Environment.getExternalStorageDirectory()+"/MediaCenter/"), serie.getIllustrationPath());

        if(imgFile.exists()){
            Log.v("File Found", imgFile.getAbsolutePath());

            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath(), bmOptions);
            serieImageView.setImageBitmap(myBitmap);

        } else {
            Log.e("File Not Found", imgFile.getPath());
        }

        serieButtonWatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isEpisodeMenuOpen){
                    isEpisodeMenuOpen = true;
                    serieButtonWatch.setCompoundDrawablesWithIntrinsicBounds(null, null, iconOpen, null);
                    episodeRecyclerView.setVisibility(View.VISIBLE);
                }else{
                    isEpisodeMenuOpen = false;
                    serieButtonWatch.setCompoundDrawablesWithIntrinsicBounds(null, null, iconClose, null);
                    episodeRecyclerView.setVisibility(View.GONE);
                }
            }

        });

    }


}
