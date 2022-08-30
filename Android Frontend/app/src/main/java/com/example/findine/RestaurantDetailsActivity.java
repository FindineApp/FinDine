package com.example.findine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.findine.reviews.ReviewAdapter;
import com.example.findine.reviews.ReviewItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "RestaurantDetails";

    private final int OPERATIONAL = 0;
    private final int CLOSED_TEMPORARILY = 1;
    private final int CLOSED_PERMANENTLY = 2;
    private final int REVIEWS_AMOUNT = 5;

    private MapView mapView;
    private RecyclerView recyclerView;
    private Button detailsButton;

    private ViewPager viewPager;
    private ReviewAdapter adapter;

    private List<String> imageList;
    private List<ReviewItem> reviewItems;

    private double latitude;
    private double longitude;
    private int businessStatus;
    private boolean openNow;
    private String openingHours;
    private String googlePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        getSupportActionBar().hide();

        // Get the SupportMapFragment and register for the callback
        // when the map is ready for use.
        mapView = (MapView) findViewById(R.id.restaurant_mapview);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        imageList = new ArrayList<>();
        imageList.add("https://media-cdn.tripadvisor.com/media/photo-s/16/a5/b9/e9/photo1jpg.jpg");
        imageList.add("https://1.bp.blogspot.com/-VELiixFarDY/XFdjl2FxLCI/AAAAAAABI9w/BGlE1N3nGBEZTFXwwk5Sizx_ieRN-UtyACLcBGAs/s1600/Haidilao.jpg");
        /*
        if (imageList.size() == 0) {

        }

         */
        viewPager = findViewById(R.id.view_pager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(imageList);
        viewPager.setAdapter(myPagerAdapter);

        recyclerView = (RecyclerView) findViewById(R.id.restaurantRecyclerView);
        recyclerView.setHasFixedSize(true);  // every item in recyclerView has fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reviewItems = new ArrayList<>();

        adapter = new ReviewAdapter(getApplicationContext(), reviewItems);
        recyclerView.setAdapter(adapter);

        try {
            loadReviews();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        googlePage = "https://goo.gl/maps/dDPZ5cv8XeHr1HsG6";
        detailsButton = (Button) findViewById(R.id.details_button);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googlePage));
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Exception Caught", e.toString());
                }
            }
        });

    }

    private void loadReviews() throws URISyntaxException, MalformedURLException {
        String userName = "Peter Na";
        String userDate = "a week ago";
        String userDescription = "very friendly service and the food is great. Would definitely come again next time";
        double userRate = 4;
        String userProfilePic = "https://lh3.googleusercontent.com/a/AATXAJwgg1tM4aVA4nJCMjlfJtHtFZuxF475Vb6tT74S=s128-c0x00000000-cc-rp-mo";
        for (int i = 0; i < REVIEWS_AMOUNT; i++) {
            ReviewItem reviewItem = new ReviewItem(userName, userDate, userDescription, userRate, userProfilePic);
            reviewItems.add(reviewItem);
            adapter.notifyDataSetChanged();
            recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
        }
    }

    public static String getCurrentWeekDay() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            default:
                return null;
        }
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready for use.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.

            // Saving state of our app
            // using SharedPreferences
            SharedPreferences sharedPreferences
                    = getSharedPreferences(
                    "sharedPrefs", MODE_PRIVATE);
            final boolean isDarkModeOn
                    = sharedPreferences
                    .getBoolean(
                            "isDarkModeOn", false);
            // When user reopens the app
            // after applying dark/light mode
            boolean success = false;
            if (isDarkModeOn) {
                success = googleMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                this, R.raw.style_json_night));
            } else {
                Log.e(TAG, "Map day mode");
            }
            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
        LatLng marker = new LatLng(49.2276, -123.0076);
        googleMap.addMarker(new MarkerOptions()
                .position(marker)
                .title("Marker"));
        float zoomLevel = 15.0f; //This goes up to 21
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, zoomLevel));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}