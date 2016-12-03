package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Objects;

/**
 * Created by vmars on 02/12/2016.
 */

public abstract class CardsViewHolder extends RecyclerView.ViewHolder{

    protected CardsViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bind(Object data);
}
