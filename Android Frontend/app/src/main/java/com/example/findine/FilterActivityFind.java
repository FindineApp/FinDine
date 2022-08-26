package com.example.findine;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class FilterActivityFind extends AppCompatActivity {

    private ToggleButton restaurantButton;
    private ToggleButton cafeButton;
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

    }
}