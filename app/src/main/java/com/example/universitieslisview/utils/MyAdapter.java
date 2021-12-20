package com.example.universitieslisview.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.universitieslisview.R;
import com.example.universitieslisview.SchoolListActivity;
import com.example.universitieslisview.models.University;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<University> data_set = null;
    private String[] images;
    StorageReference storageRef =  FirebaseStorage.getInstance().getReference();

    public MyAdapter(Context context, ArrayList<University> universities, String[] images) {
        this.context = context;
        data_set = universities;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.university_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.uni_name.setText(data_set.get(position).getName());
        holder.uni_region.setText(data_set.get(position).getRegion());
        holder.uni_nbrSchool.setText(String.valueOf(data_set.get(position).getNbrSchool()));
       // StorageReference thubnailRef = storageRef.child("media").child("etablissements/"+images[position]);
        StorageReference thubnailRef = storageRef.child("media/").child("etablissements/"+images[position]);
        final long ONE_MEGABYTE = 1024 * 1024;
        thubnailRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                holder.uni_image.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

       // holder.uni_image.setImageResource(data_set.get(position).getUniImage());

        int pos = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(context.getApplicationContext(), , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(), SchoolListActivity.class);
                intent.putExtra("universityId", data_set.get(pos).getId());
                intent.putExtra("universityName", data_set.get(pos).getName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_set.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView uni_image;
        private TextView uni_name;
        private TextView uni_region;
        private TextView uni_nbrSchool;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            uni_image = (ImageView) itemView.findViewById(R.id.image_university);
            uni_name = (TextView) itemView.findViewById(R.id.name_university);
            uni_region = (TextView) itemView.findViewById(R.id.city_university);
            uni_nbrSchool = (TextView) itemView.findViewById(R.id.nbFiliere_university);
        }
    }
}
