package com.example.findine.reviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.findine.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private Context context;
    private List<ReviewItem> reviewItems;

    public ReviewAdapter(Context context, List<ReviewItem> reviewItems) {
        this.context = context;
        this.reviewItems = reviewItems;
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_adapter_layout, parent, false);
        return new ReviewAdapter.ViewHolder(view);
    }

    @Override
    /*
        Show data onto recyclerview
        Called after OnCreateViewHolder to bind the views
     */
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
        ReviewItem reviewItem = reviewItems.get(position);
        holder.userNameView.setText(reviewItem.getUserName());
        holder.userDateView.setText(reviewItem.getUserDate());
        holder.userRateView.setRating((float) reviewItem.getUserRate());
        holder.userDescriptionView.setText(reviewItem.getUserDescription());
        Glide.with(context).load(reviewItem.getUserProfilePicture()).into(holder.userProfilePicView);
    }

    @Override
    public int getItemCount() {
        return reviewItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView userNameView;
        public TextView userDateView;
        public RatingBar userRateView;
        public TextView userDescriptionView;
        public CircleImageView userProfilePicView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userNameView = (TextView) itemView.findViewById(R.id.userNameView);
            userDateView = (TextView) itemView.findViewById(R.id.userDateView);
            userRateView = (RatingBar) itemView.findViewById(R.id.userRateView);
            userDescriptionView = (TextView) itemView.findViewById(R.id.userDescriptionView);
            userProfilePicView = (CircleImageView) itemView.findViewById(R.id.userProfilePicView);
        }
    }

}
