package fr.utbm.lo52.CustomAndroid.mediacenter.viewHolder;


import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import fr.utbm.lo52.CustomAndroid.mediacenter.R;
import fr.utbm.lo52.CustomAndroid.mediacenter.adapters.CardViewHolder;
import fr.utbm.lo52.CustomAndroid.mediacenter.models.Preview;
import fr.utbm.lo52.CustomAndroid.mediacenter.utils.IntentsHelper;

import static android.content.ContentValues.TAG;

/**
 * Created by vmars on 03/12/2016.
 */

public class PreviewCardViewHolder extends CardViewHolder {

    private ImageView imagePreviewView;
    private TextView titlePreviewView;

    protected PreviewCardViewHolder(View itemView) {
        super(itemView);

        imagePreviewView = (ImageView) itemView.findViewById(R.id.preview_img);
        titlePreviewView = (TextView) itemView.findViewById(R.id.preview_title);

    }

    @Override
    public void bind(Object data) {
        final Preview preview = (Preview) data;

        titlePreviewView.setText(preview.getTitle());
        setImage(preview.getIllustrationPath(), imagePreviewView);

        imagePreviewView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(AppCompatActivity.class.isAssignableFrom(preview.getDetailActivityclass()))
                    IntentsHelper.startDetailActivity(preview.getDetailActivityclass(), (Serializable) preview.getData());
                else
                    Log.e(TAG, "Cannot start the new activity. The class given by preview is not an activity");
            }

        });
    }
}
