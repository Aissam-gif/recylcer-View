package com.example.universitieslisview.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.view.menu.MenuView;

import com.example.universitieslisview.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SlideAdapter extends SliderViewAdapter<SlideAdapter.Holder> {
    int[] images;
    public SlideAdapter(int[] images) {
        this.images = images;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.itemView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends SliderViewAdapter.ViewHolder {
           ImageView itemView;
            public Holder(View view) {
                super(view);
                itemView = view.findViewById(R.id.image_view);
            }
        }
}
