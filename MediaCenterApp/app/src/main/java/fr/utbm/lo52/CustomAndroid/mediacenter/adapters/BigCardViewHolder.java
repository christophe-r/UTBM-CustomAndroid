package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by vmars on 04/12/2016.
 */

public abstract class BigCardViewHolder extends CardViewHolder {

    protected TextView titleView;
    protected TextView subTitleView;
    protected ImageView imageView;
    protected Button buttonView;
    protected LinearLayout mainLayout;
    protected CardView cardView;
    protected RecyclerView subRecyclerView;


    protected BigCardViewHolder(View itemView) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.big_title);
        subTitleView = (TextView) itemView.findViewById(R.id.big_subTitle);
        imageView = (ImageView) itemView.findViewById(R.id.big_image);
        buttonView = (Button) itemView.findViewById(R.id.big_button);
        cardView = (CardView) itemView.findViewById(R.id.big_cardview);
        mainLayout = (LinearLayout) itemView.findViewById(R.id.big_mainlayout);
        subRecyclerView = (RecyclerView) itemView.findViewById(R.id.big_sub_recycler_view);

    }

    protected void setImage(String relativePath){
       super.setImage(relativePath, imageView);
    }


}
