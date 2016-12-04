package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by vmars on 03/12/2016.
 */

public class CardsListAdapter<T> extends RecyclerView.Adapter<CardViewHolder> {

    private List<T> objectsList;
    private Class viewHolderClass;
    private int ressourceLayout;

    public CardsListAdapter(List<T> list, Class viewHolder, int ressourceLayout) {
        this.objectsList = list;
        if(!CardViewHolder.class.isAssignableFrom(viewHolder))
            Log.e(TAG, "CardsListAdapter: Error incompatible class viewHolder, it must be inherited from CardViewHolder");
        this.viewHolderClass = viewHolder;
        this.ressourceLayout = ressourceLayout;
    }

   @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(this.ressourceLayout, viewGroup, false);
       try {
           return (CardViewHolder) viewHolderClass.getDeclaredConstructor(View.class).newInstance(view);
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }


    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bind(objectsList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + viewHolderClass + "eeeeeeeeeeeeeeeeeeeee" + objectsList.size());
        return objectsList.size();
    }

}