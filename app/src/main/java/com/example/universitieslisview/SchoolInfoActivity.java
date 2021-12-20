package com.example.universitieslisview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.universitieslisview.models.Filiere;
import com.example.universitieslisview.models.School;
import com.example.universitieslisview.utils.GridAdapter;
import com.example.universitieslisview.utils.SlideAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

public class SchoolInfoActivity extends AppCompatActivity {

    SliderView sliderView;
    ImageView imageView;
    GridView gridView;
    int[] images = {R.mipmap.harvard, R.mipmap.img_harvard_2, R.mipmap.img_harvard_3};
    ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    String[] gridValue = new String[]{
            "GI", "GI", "GI", "GI", "GI", "GI", "GI", "GI", "GI", "GI", "GI", "GI"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_info_layout);
        imageView = findViewById(R.id.top_arrow);
        SlidingUpPanelLayout layout = findViewById(R.id.slidingUp);
        layout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                sliderView.findViewById(R.id.images_slider).setAlpha(1 - slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    imageView.setImageResource(R.drawable.ic_bottom_arrow);
                } else if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                    imageView.setImageResource(R.drawable.ic_top_arrow);
                }
            }
        });

        sliderView = findViewById(R.id.images_slider);
        SlideAdapter slideAdapter = new SlideAdapter(images);
        sliderView.setSliderAdapter(slideAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        filieres.add(new Filiere("GI"));
        filieres.add(new Filiere("GI"));
        filieres.add(new Filiere("GI"));
        gridView = findViewById(R.id.grid_view);
        GridAdapter gridAdapter = new GridAdapter(this, filieres);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, gridValue);
        gridView.setAdapter(adapter);
    }

}