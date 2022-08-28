package com.example.findine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class FilterActivityFind extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "FilterActivityFind";

    private MapView mapView;

    private ToggleButton restaurantButton;
    private ToggleButton cafeButton;
    private SeekBar seekBar;
    private RadioButton rateButton4;
    private RadioButton rateButton3;
    private RadioButton rateButton2;
    private RadioButton rateButton1;
    private ToggleButton priceButton4;
    private ToggleButton priceButton3;
    private ToggleButton priceButton2;
    private ToggleButton priceButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_find);

        getSupportActionBar().hide();

        // Get the SupportMapFragment and register for the callback
        // when the map is ready for use.
        mapView = (MapView) findViewById(R.id.filterMapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        ImageView backButton = (ImageView) findViewById(R.id.back_button_1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        restaurantButton = (ToggleButton) findViewById(R.id.toggleButtonRestaurant);
        restaurantButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_restaurant_24, 0, 0, 0);
                    buttonView.setTextColor(getResources().getColor(R.color.black));
                } else {
                    // The toggle is disabled
                    buttonView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_restaurant_24_white, 0, 0, 0);
                    buttonView.setTextColor(getResources().getColor(R.color.light_grey));
                }
            }
        });

        cafeButton = (ToggleButton) findViewById(R.id.toggleButtonCafe);
        cafeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24);
                    buttonView.setTextColor(getResources().getColor(R.color.black));
                } else {
                    // The toggle is disabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24_white);
                    buttonView.setTextColor(getResources().getColor(R.color.light_grey));
                }
            }
        });

        cafeButton = (ToggleButton) findViewById(R.id.toggleButtonCafe);
        cafeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24);
                    buttonView.setTextColor(getResources().getColor(R.color.black));
                } else {
                    // The toggle is disabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24_white);
                    buttonView.setTextColor(getResources().getColor(R.color.light_grey));
                }
            }
        });

        cafeButton = (ToggleButton) findViewById(R.id.toggleButtonCafe);
        cafeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24);
                    buttonView.setTextColor(getResources().getColor(R.color.black));
                } else {
                    // The toggle is disabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24_white);
                    buttonView.setTextColor(getResources().getColor(R.color.light_grey));
                }
            }
        });

        cafeButton = (ToggleButton) findViewById(R.id.toggleButtonCafe);
        cafeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24);
                    buttonView.setTextColor(getResources().getColor(R.color.black));
                } else {
                    // The toggle is disabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24_white);
                    buttonView.setTextColor(getResources().getColor(R.color.light_grey));
                }
            }
        });

        cafeButton = (ToggleButton) findViewById(R.id.toggleButtonCafe);
        cafeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24);
                    buttonView.setTextColor(getResources().getColor(R.color.black));
                } else {
                    // The toggle is disabled
                    buttonView.setButtonDrawable(R.drawable.ic_baseline_restaurant_24_white);
                    buttonView.setTextColor(getResources().getColor(R.color.light_grey));
                }
            }
        });

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mapView.onCreate(savedInstanceState);
                mapView.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng marker = new LatLng(49.2276, -123.0076);
                        Circle circle = googleMap.addCircle(new CircleOptions()
                                .center(new LatLng(49.2276, -123.0076))
                                .radius(1100)
                                .strokeColor(0xFFF65F45)
                                .fillColor(0x91FF7853));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, getZoomLevel(circle)));
                    }
                });
            }
        });

    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready for use.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng marker = new LatLng(49.2276, -123.0076);
        Circle circle = googleMap.addCircle(new CircleOptions()
                .center(new LatLng(49.2276, -123.0076))
                .radius(500)
                .strokeColor(0xFFF65F45)
                .fillColor(0x91FF7853));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, getZoomLevel(circle)));
    }

    private float getZoomLevel(Circle circle) {
        float zoomLevel = 11f;
        if (circle != null) {
            double radius = circle.getRadius() + circle.getRadius() / 2;
            double scale = radius / 500;
            zoomLevel = (float) (16 - Math.log(scale) / Math.log(2));
            zoomLevel = zoomLevel - 0.9f;
        }
        return zoomLevel;
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