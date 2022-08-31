package com.example.findine;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.example.findine.places.PlaceAdapter;
import com.example.findine.places.PlaceItem;

import java.util.ArrayList;
import java.util.List;

/**
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment {

    private SearchView searchView;
    private ImageButton filterButton;

    private RecyclerView recyclerView;
    private PlaceAdapter adapter;
    private List<PlaceItem> placeItems;
    private List<PlaceItem> searchItems;

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

        placeTitle = "HaiDiLao HotPot Richmond";
        placeDistance = "700 m";
        placeType = "Chinese";
        placeRate = 4.5;
        placePhoto = "https://media-cdn.tripadvisor.com/media/photo-s/16/a5/b9/e9/photo1jpg.jpg";

        PlaceItem placeItem = new PlaceItem(placeTitle, placeDistance, placeType, placeRate, placePhoto);
        PlaceItem placeItem1 = new PlaceItem("Yunshang Rice Noodle", "1.2 km", "Chinese", 3.8, placePhoto);
        placeItems.add(placeItem);
        placeItems.add(placeItem1);
        placeItems.add(new PlaceItem("Tim Hortons", "2.4 km", "Fastfood", 3.8, placePhoto));
        placeItems.add(new PlaceItem("Edo Japan - CF Richmond Centre - Grill and Sushi", "500 m", "Japanese", 3.6, placePhoto));
        adapter.notifyDataSetChanged();

        filterButton = view.findViewById(R.id.browseFilter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent filterIntent = new Intent(getActivity(), FilterActivity.class);
                startActivity(filterIntent);
            }
        });

        return view;
    }
}