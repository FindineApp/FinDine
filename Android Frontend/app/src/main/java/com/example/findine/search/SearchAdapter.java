package com.example.findine.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findine.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private Context context;
    private List<SearchItem> searchItems;

    public SearchAdapter(Context context, List<SearchItem> searchItems) {
        this.context = context;
        this.searchItems = searchItems;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_adapter_layout, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    /*
        Show data onto recyclerview
        Called after OnCreateViewHolder to bind the views
     */
    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        SearchItem searchItem = searchItems.get(position);
        holder.searchTextView.setText(searchItem.getCategory());
    }

    @Override
    public int getItemCount() {
        return searchItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView searchTextView;
        public ImageView searchImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            searchTextView = (TextView) itemView.findViewById(R.id.searchTextView);
            searchImageView = (ImageView) itemView.findViewById(R.id.searchImageView);
        }
    }
}
