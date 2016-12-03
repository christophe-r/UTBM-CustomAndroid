package fr.utbm.lo52.CustomAndroid.mediacenter.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by vmars on 03/12/2016.
 */

public class CardsListAdapter<T> extends RecyclerView.Adapter<CardsViewHolder> {

    private List<T> objectsList;
    private Class viewHolderClass;
    private int ressourceLayout;

    public CardsListAdapter(List<T> list, Class viewHolder, int ressourceLayout) {
        this.objectsList = list;
       // TODO checks if the viewHolder Class extends from CardsViewHolder
        this.viewHolderClass = viewHolder;
        this.ressourceLayout = ressourceLayout;
    }

   @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(this.ressourceLayout, viewGroup, false);
       try {
           return (CardsViewHolder) viewHolderClass.getDeclaredConstructor(View.class).newInstance(view);
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }


    @Override
    public void onBindViewHolder(CardsViewHolder holder, int position) {
        holder.bind(objectsList.get(position));
    }

    @Override
    public int getItemCount() {
        return objectsList.size();
    }

}