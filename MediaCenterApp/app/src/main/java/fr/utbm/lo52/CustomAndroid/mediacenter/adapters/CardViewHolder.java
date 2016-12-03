package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by vmars on 02/12/2016.
 */

public abstract class CardViewHolder extends RecyclerView.ViewHolder{

    protected CardViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bind(Object data);

}
