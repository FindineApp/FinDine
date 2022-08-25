package com.example.findine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private List<Uri> imageList;

    private double latitude;
    private double longitude;
    private boolean openNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        getSupportActionBar().hide();

        imageList = new ArrayList<>();
        if (imageList.size() == 0) {

        }
        viewPager = findViewById(R.id.view_pager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(imageList);
        viewPager.setAdapter(myPagerAdapter);


    }
}