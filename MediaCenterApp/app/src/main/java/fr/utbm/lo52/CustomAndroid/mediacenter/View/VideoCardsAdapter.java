package fr.utbm.lo52.CustomAndroid.mediacenter.View;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.utbm.lo52.CustomAndroid.mediacenter.Model.Video;
import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by Christophe on 2016-11-29.
 */

public class VideoCardsAdapter extends RecyclerView.Adapter<VideoCardsViewHolder> {

    List<Video> list;

    //ajouter un constructeur prenant en entrée une liste
    public VideoCardsAdapter(List<Video> list) {
        this.list = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public VideoCardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_cards, viewGroup,false);
        return new VideoCardsViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(VideoCardsViewHolder videoCardsViewHolder, int position) {
        Video video = list.get(position);
        videoCardsViewHolder.bind(video);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}