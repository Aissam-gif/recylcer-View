package com.example.universitieslisview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.universitieslisview.models.School;
import com.example.universitieslisview.utils.MyAdapter;
import com.example.universitieslisview.utils.SchoolsAdapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SchoolListActivity extends AppCompatActivity {
    private RecyclerView listUniversities;
    private TextView university_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#007FFF")));
        actionBar.setTitle(Html.fromHtml("<font color='#FFFFFF'>Retour</font>"));
        actionBar.setElevation(0);
        Bundle extras = getIntent().getExtras();
        int UniversityId = -1;
        String UniversityName = null;
        if (extras != null) {
            UniversityId = extras.getInt("universityId");
            UniversityName = extras.getString("universityName");
        }
        university_name = findViewById(R.id.university_name);
        university_name.setText(UniversityName);
        listUniversities = findViewById(R.id.recyclerList);

        SchoolsAdapter myAdapter = new SchoolsAdapter(this,getSchools(UniversityId));
        listUniversities.setAdapter(myAdapter);
        listUniversities.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<School> getSchools(int uniId){
        ArrayList<School> schools = new ArrayList<>();
        schools.add(new School(1,"EST","Ecole Sup??rieur de Technologie","Agadir",5,1));
        schools.add(new School(2,"ENCG","??coles nationales de commerce et de gestion","Agadir",6, 1));
        schools.add(new School(9,"FSS","Facult?? des Sciences Semlalia","Marrakech",8,2));
        schools.add(new School(10,"ENSIAS","??cole Nationale Sup??rieure d'Informatique et d'Analyse des Syst??mes","Marrakech",10,2));
        schools.add(new School(3,"ENSAM","??cole nationale sup??rieure d'arts et m??tiers","Casablanca",7,3));
        schools.add(new School(4,"ESFI","Ecole sup??rieure de formation des ing??nieurs","Casablanca",8,3));
        schools.add(new School(7,"FS","Facult?? science El Jadida","El Jadida",4,4));
        schools.add(new School(8,"FSJESA","Facult?? des sciences juridiques, ??conomiques et sociales d'Agadir","El Jadida",6,4));
        schools.add(new School(5,"OFFPT","Office de la formation professionnelle et de promotion du travail","Meknes",9,5));
        schools.add(new School(6,"FPT","Facult?? Polydisciplinaire de Taroudant","Meknes",2,5));
        ArrayList<School> result = schools.stream().filter(school -> school.getId_uni() == uniId).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
}