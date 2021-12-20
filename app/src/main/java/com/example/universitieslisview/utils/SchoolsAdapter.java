package com.example.universitieslisview.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.universitieslisview.R;
import com.example.universitieslisview.SchoolInfoActivity;
import com.example.universitieslisview.SchoolListActivity;
import com.example.universitieslisview.models.School;
import com.example.universitieslisview.models.University;

import java.util.ArrayList;

import xyz.hanks.library.bang.SmallBangView;

public class SchoolsAdapter extends RecyclerView.Adapter<SchoolsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<School> data_set = null;

    public SchoolsAdapter(Context context, ArrayList<School> schools) {
        this.context = context;
        data_set = schools;
    }

    @NonNull
    @Override
    public SchoolsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.school_card, parent, false);

        return new SchoolsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchoolsAdapter.MyViewHolder holder, int position) {

        holder.name_school.setText(data_set.get(position).getName());
        holder.fullname_school.setText(data_set.get(position).getFullname() );
        holder.city_school.setText(data_set.get(position).getCity());
        holder.nbFiliere_school.setText(data_set.get(position).getNbrBranches() + " filières");

        int pos = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(context.getApplicationContext(), , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(), SchoolInfoActivity.class);
                intent.putExtra("universityId", data_set.get(pos).getId());
                context.getApplicationContext().startActivity(intent);
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.imageView.isSelected()) {
                    holder.imageView.setSelected(false);
                } else {
                    // if not selected only
                    // then show animation.
                    holder.imageView.setSelected(true);
                    holder.imageView.likeAnimation();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_set.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name_school;
        private TextView fullname_school;
        private TextView city_school;
        private TextView nbFiliere_school;
        private SmallBangView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_school = (TextView) itemView.findViewById(R.id.name_school);
            fullname_school = (TextView) itemView.findViewById(R.id.fullname_school);
            city_school = (TextView) itemView.findViewById(R.id.city_school);
            nbFiliere_school = (TextView) itemView.findViewById(R.id.nbFiliere_school);
            imageView = (SmallBangView) itemView.findViewById(R.id.imageViewAnimation);
        }
    }
}
