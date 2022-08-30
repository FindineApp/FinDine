package com.example.findine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.findine.search.SearchAdapter;
import com.example.findine.search.SearchItem;

import java.util.ArrayList;
import java.util.List;

/**
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    private SearchView searchView;
    private RecyclerView recyclerView;

    List<SearchItem> searchItems;

    private SearchAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchView = view.findViewById(R.id.searchBar);
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.searchRecyclerView);
        recyclerView.setHasFixedSize(true);  // every item in recyclerView has fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        searchItems = new ArrayList<>();

        adapter = new SearchAdapter(getContext(), searchItems);
        recyclerView.setAdapter(adapter);

        searchItems.add(new SearchItem("Hotpot"));
        searchItems.add(new SearchItem("Seafood"));
        searchItems.add(new SearchItem("Indian"));
        searchItems.add(new SearchItem("Korean"));
        searchItems.add(new SearchItem("BBQ"));
        searchItems.add(new SearchItem("Ramen"));
        searchItems.add(new SearchItem("Soup"));
        searchItems.add(new SearchItem("Italian"));
        searchItems.add(new SearchItem("Pizza"));
        searchItems.add(new SearchItem("Poutine"));
        searchItems.add(new SearchItem("Tandori"));
        searchItems.add(new SearchItem("Japanese"));
        searchItems.add(new SearchItem("Greek"));
        searchItems.add(new SearchItem("Fries"));
        searchItems.add(new SearchItem("Wonton"));
        adapter.notifyDataSetChanged();

        return view;
    }
}