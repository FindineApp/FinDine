package com.example.findine.places;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.findine.R;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private Context context;
    private List<PlaceItem> placeItems;

    public PlaceAdapter(Context context, List<PlaceItem> placeItems) {
        this.context = context;
        this.placeItems = placeItems;
    }

    @NonNull
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_adapter_layout, parent, false);
        return new PlaceAdapter.ViewHolder(view);
    }

    /*
        Show data onto recyclerview
        Called after OnCreateViewHolder to bind the views
     */
    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.ViewHolder holder, int position) {
        PlaceItem placeItem = placeItems.get(position);
        holder.placeTitleView.setText(placeItem.getPlaceTitle());
        holder.placeDistanceView.setText(placeItem.getPlaceDistance());
        holder.placeTypeView.setText(placeItem.getPlaceType());
        holder.placeRatingView.setText(String.valueOf(placeItem.getPlaceRate()));
        Glide.with(context).load(placeItem.getPlaceIcon()).centerCrop().into(holder.placeIconView);
        Glide.with(context).load(placeItem.getPlacePhoto()).centerCrop().into(holder.placePhotoView);
    }

    @Override
    public int getItemCount() {
        return placeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView placeTitleView;
        public TextView placeDistanceView;
        public TextView placeRatingView;
        public TextView placeTypeView;
        public ImageView placeIconView;
        public ImageView placePhotoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            placeTitleView = itemView.findViewById(R.id.placeTitle);
            placeDistanceView = itemView.findViewById(R.id.placeDistance);
            placeRatingView = itemView.findViewById(R.id.placeRating);
            placeTypeView = itemView.findViewById(R.id.placeType);
            placeIconView = itemView.findViewById(R.id.placeIcon);
            placePhotoView = itemView.findViewById(R.id.placePhoto);
        }
    }

}
