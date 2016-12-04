package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;

/**
 * Created by vmars on 04/12/2016.
 */

public abstract class SmallCardViewHolder extends CardViewHolder {

    protected TextView numberView;
    protected TextView titleView;
    protected ImageView imageView;
    protected LinearLayout cardView;


    protected SmallCardViewHolder(View itemView) {
        super(itemView);

        numberView = (TextView) itemView.findViewById(R.id.small_number);
        titleView = (TextView) itemView.findViewById(R.id.small_title);
        imageView = (ImageView) itemView.findViewById(R.id.small_img);
        cardView = (LinearLayout) itemView.findViewById(R.id.small_cardview);

    }

    protected void setImage(String relativePath){
        super.setImage(relativePath, imageView);
    }


}
