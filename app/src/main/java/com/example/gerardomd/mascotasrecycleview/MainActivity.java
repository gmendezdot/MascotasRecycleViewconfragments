package com.example.gerardomd.mascotasrecycleview;

import android.content.Intent;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Animales> animals,animalscopy;
    private RecyclerView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setIcon(R.drawable.cat_footprint);



        setpets();

        list = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        list.setLayoutManager(llm);

        setadapter();

    }


    public void setadapter(){
        AdapterRecycleView adapter = new AdapterRecycleView(animals, this);
        list.setAdapter(adapter);
    }


    public void setpets(){

        animals = new ArrayList<Animales>();
        animals.add(new Animales(R.drawable.leon,R.drawable.dog_bone_50,"LION","5",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.perro,R.drawable.dog_bone_50,"DOG","0",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.gato,R.drawable.dog_bone_50,"CAT","2",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.elefante,R.drawable.dog_bone_50,"ELEPHANT","3",R.drawable.dog_bone_filled_50));
        animals.add(new Animales(R.drawable.caballo,R.drawable.dog_bone_50,"HORSE","0",R.drawable.dog_bone_filled_50));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.estrella) {
            //CALLING THE SECOND ACTIVITY
            raiting();//CREANDO UNA COPIA DEL ARRAYLIST SOLO CON LOS OBJETOS QUE TIENE RAITING
            Intent intent = new Intent(MainActivity.this, MostrarRaitingMascotas.class);
            intent.putExtra("arrayactividaddos", animalscopy);
            startActivity(intent);
        }
       return super.onOptionsItemSelected(item);
    }


    public void raiting(){
        int x=0;

        animalscopy = new ArrayList<Animales>(animals);
        //Iterator<Animales> it = animalscopy.iterator();

        for(int i=0;i<animals.size();i++){
       //     while(it.hasNext()){
            if ((animalscopy.get(x).getCount()).equals("0")) {
                animalscopy.remove(x);
            } else
                x++;
        }

    }





    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);




    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        // savedInstanceState.putString(snombre, "");

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }







}

