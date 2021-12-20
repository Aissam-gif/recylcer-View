package com.example.universitieslisview.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.universitieslisview.R;
import com.example.universitieslisview.models.Filiere;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Filiere> data_set = null;
    private LayoutInflater layoutInflater;

    public GridAdapter(Context context, ArrayList<Filiere> filieres) {
        this.context = context;
        data_set = filieres;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data_set.size();
    }

    @Override
    public Filiere getItem(int position) {
        return data_set.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_filiere_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.filiere_name.setText(getItem(position).getName());
        return convertView;
    }
    static class ViewHolder {
        TextView filiere_name;
        public ViewHolder(View view) {
            filiere_name = view.findViewById(R.id.filiere_name);
        }
    }
}
