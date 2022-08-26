package com.example.findine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.findine.places.PlaceAdapter;
import com.example.findine.places.PlaceItem;
import com.example.findine.reviews.ReviewAdapter;
import com.example.findine.reviews.ReviewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlaceAdapter adapter;
    private List<PlaceItem> placeItems;

    private String placeTitle;
    private String placeDistance;
    private String placeType;
    private double placeRate;
    private String placeIcon;
    private String placePhoto;

    public BrowseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.browseRecyclerView);
        recyclerView.setHasFixedSize(true);  // every item in recyclerView has fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        placeItems = new ArrayList<>();

        adapter = new PlaceAdapter(getContext(), placeItems);
        recyclerView.setAdapter(adapter);

        placeTitle = "HaiDiLao Richmond";
        placeDistance = "700 m";
        placeType = "Chinese";
        placeRate = 4.7;
        placeIcon = "https://media-cdn.tripadvisor.com/media/photo-p/16/7b/79/da/logo.jpg";
        placePhoto = "https://media-cdn.tripadvisor.com/media/photo-s/16/a5/b9/e9/photo1jpg.jpg";

        for (int i = 0; i < 10; i++) {
            PlaceItem placeItem = new PlaceItem(placeTitle, placeDistance, placeType, placeRate, placeIcon, placePhoto);
            placeItems.add(placeItem);
            adapter.notifyDataSetChanged();
        }

        return view;
    }
}