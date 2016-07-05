package com.example.gerardomd.mascotasrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.gerardomd.mascotasrecycleview.Adapters.AdapterRecycleView;
import com.example.gerardomd.mascotasrecycleview.Pojo.Animales;

import java.util.ArrayList;

public class MostrarRaitingMascotas extends AppCompatActivity {

    private ArrayList<Animales> animals;
    private RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_raiting_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.cat_footprint);

        animals = new ArrayList<Animales>();

       // Intent intent = getIntent();
        //animals = intent.getParcelableArrayListExtra("arrayactividaddos");

        list = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(llm);

        AdapterRecycleView adapter = new AdapterRecycleView(animals, this);
        list.setAdapter(adapter);

        setpets();
        setadapter();

    }

    public void setadapter(){
        AdapterRecycleView adapter = new AdapterRecycleView(animals, this);
        list.setAdapter(adapter);
    }
    public void setpets(){

        animals = new ArrayList<Animales>();
        animals.add(new Animales(R.drawable.c_leon,R.drawable.dog_bone_50,"LION","5",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.c_perro,R.drawable.dog_bone_50,"DOG","1",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.c_gato,R.drawable.dog_bone_50,"CAT","2",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.c_elefante,R.drawable.dog_bone_50,"ELEPHANT","3",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.c_caballo,R.drawable.dog_bone_50,"HORSE","1",R.drawable.dog_bone_filled_50));
    }





}
