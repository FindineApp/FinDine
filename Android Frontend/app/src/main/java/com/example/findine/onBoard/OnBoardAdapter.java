package com.example.findine.onBoard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.findine.MainActivity;
import com.example.findine.OnBoardActivity;
import com.example.findine.R;

public class OnBoardAdapter extends PagerAdapter {

    Context context;

    public OnBoardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.on_board_screen, container, false);

        ImageView logo = view.findViewById(R.id.logo);

        ImageView ind1 = view.findViewById(R.id.ind1);
        ImageView ind2 = view.findViewById(R.id.ind2);
        ImageView ind3 = view.findViewById(R.id.ind3);
        ImageView ind4 = view.findViewById(R.id.ind4);
        ImageView ind5 = view.findViewById(R.id.ind5);

        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);

        ImageView next = view.findViewById(R.id.next);
        ImageView back = view.findViewById(R.id.back);

        Button btnGetStarted=view.findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardActivity.viewPager.setCurrentItem(position+1);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnBoardActivity.viewPager.setCurrentItem(position-1);
            }
        });

        switch (position)
        {
            case 0:
                //logo.setImageResource(R.drawable.onboard_welcome_logo);
                ind1.setImageResource(R.drawable.selected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.unselected);
                ind1.setScaleX(1f);
                ind1.setScaleY(1f);
                ind2.setScaleX(0.7f);
                ind2.setScaleY(0.7f);
                ind3.setScaleX(0.7f);
                ind3.setScaleY(0.7f);
                ind4.setScaleX(0.7f);
                ind4.setScaleY(0.7f);
                ind5.setScaleX(0.7f);
                ind5.setScaleY(0.7f);
                title.setText("Welcome to the Findine APP! ");
                desc.setText("Please follow this introduction or click Get Started to navigate to the home screen directly!");
                back.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
                break;
            case 1:
                //logo.setImageResource(R.drawable.onboard_search_logo);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.selected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.unselected);
                ind1.setScaleX(0.7f);
                ind1.setScaleY(0.7f);
                ind2.setScaleX(1f);
                ind2.setScaleY(1f);
                ind3.setScaleX(0.7f);
                ind3.setScaleY(0.7f);
                ind4.setScaleX(0.7f);
                ind4.setScaleY(0.7f);
                ind5.setScaleX(0.7f);
                ind5.setScaleY(0.7f);
                title.setText("Can't decide where to eat?");
                desc.setText("Let Findine pick for you by simply pressing one button!");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 2:
                //logo.setImageResource(R.drawable.onboard_review_logo);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.selected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.unselected);
                ind1.setScaleX(0.7f);
                ind1.setScaleY(0.7f);
                ind2.setScaleX(0.7f);
                ind2.setScaleY(0.7f);
                ind3.setScaleX(1f);
                ind3.setScaleY(1f);
                ind4.setScaleX(0.7f);
                ind4.setScaleY(0.7f);
                ind5.setScaleX(0.7f);
                ind5.setScaleY(0.7f);
                title.setText("Rate UBC Facilities");
                desc.setText("Share your experience by rating and commenting on UBC restaurants, study spaces, and entertainments");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 3:
                //logo.setImageResource(R.drawable.onboard_post_logo);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.selected);
                ind5.setImageResource(R.drawable.unselected);
                ind1.setScaleX(0.7f);
                ind1.setScaleY(0.7f);
                ind2.setScaleX(0.7f);
                ind2.setScaleY(0.7f);
                ind3.setScaleX(0.7f);
                ind3.setScaleY(0.7f);
                ind4.setScaleX(1f);
                ind4.setScaleY(1f);
                ind5.setScaleX(0.7f);
                ind5.setScaleY(0.7f);
                title.setText("Have an idea in mind?");
                desc.setText("Search by keyword");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
                break;
            case 4:
                //logo.setImageResource(R.drawable.onboard_chatbot_logo);
                ind1.setImageResource(R.drawable.unselected);
                ind2.setImageResource(R.drawable.unselected);
                ind3.setImageResource(R.drawable.unselected);
                ind4.setImageResource(R.drawable.unselected);
                ind5.setImageResource(R.drawable.selected);
                ind1.setScaleX(0.7f);
                ind1.setScaleY(0.7f);
                ind2.setScaleX(0.7f);
                ind2.setScaleY(0.7f);
                ind3.setScaleX(0.7f);
                ind3.setScaleY(0.7f);
                ind4.setScaleX(0.7f);
                ind4.setScaleY(0.7f);
                ind5.setScaleX(1f);
                ind5.setScaleY(1f);
                title.setText("Any Questions?");
                desc.setText("Contact us through the Settings page and we hope you enjoy your time with Findine!");
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.GONE);
                break;
            default:
                System.out.println("ERROR on boarding");
                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}