package com.example.universitieslisview;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.universitieslisview.models.University;
import com.example.universitieslisview.utils.MyAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listUniversities;
    private ImageView image_test;
    private String[] images = {"ic_moulay_ismail.png", "ic_moulay_ismail.png", "ic_ibnzohr.png", "ic_hassan_2.png",
    "ic_chouaib_doukali.png", "ic_cadi_ayyad.png"};
    private FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_test = findViewById(R.id.image_test);
        listUniversities = findViewById(R.id.recyclerList);
        db = FirebaseFirestore.getInstance();
        db.collection("users")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });



        MyAdapter myAdapter = new MyAdapter(this,getUniversities(),images);
        listUniversities.setAdapter(myAdapter);
        listUniversities.setLayoutManager(new LinearLayoutManager(this));
    }

    public ArrayList<University> getUniversities(){
        ArrayList<University> universities = new ArrayList<University>();
        universities.add(new University(1,"Ibn Zouhr","Agadir",5,R.drawable.ic_ibnzohr));
        universities.add(new University(2," Cadi Ayyad","Marrakech",6, R.drawable.ic_cadi_ayyad));
        universities.add(new University(3," Hassan II","Casablanca",7, R.drawable.ic_hassan_2));
        universities.add(new University(4," Chouaib Doukkali","El Jadida",8, R.drawable.ic_chouaib_doukali));
        universities.add(new University(5," Moulay-Ismaïl","Meknes",9, R.drawable.ic_moulay_ismail));
        return universities;
    }

}