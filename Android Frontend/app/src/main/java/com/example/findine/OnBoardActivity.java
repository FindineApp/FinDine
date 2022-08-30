package com.example.findine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.findine.onBoard.OnBoardAdapter;

public class OnBoardActivity extends AppCompatActivity {

    public static ViewPager viewPager;
    OnBoardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        viewPager = findViewById(R.id.viewpager);
        adapter = new OnBoardAdapter(this);
        viewPager.setAdapter(adapter);
        if (isOpened()) {
            Intent intent = new Intent(OnBoardActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            SharedPreferences.Editor editor=getSharedPreferences("slide", MODE_PRIVATE).edit();
            editor.putBoolean("slide",true);
            editor.apply();
        }
    }

    private boolean isOpened() {
        SharedPreferences sharedPreferences=getSharedPreferences("slide", MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("slide",false);
        return result;
    }
}