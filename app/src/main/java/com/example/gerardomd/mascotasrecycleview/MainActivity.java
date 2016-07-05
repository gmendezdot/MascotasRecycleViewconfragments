package com.example.gerardomd.mascotasrecycleview;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gerardomd.mascotasrecycleview.Adapters.PageAdapter;
import com.example.gerardomd.mascotasrecycleview.Fragments.InfoPet;
import com.example.gerardomd.mascotasrecycleview.Fragments.RecyclerViewFragment;
import com.example.gerardomd.mascotasrecycleview.Pojo.Animales;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

 //   private ArrayList<Animales> animals,animalscopy;
  //  private RecyclerView list;
    ArrayList<Animales> Animal;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
       // setSupportActionBar(miActionBar);
       // getSupportActionBar().setIcon(R.drawable.cat_footprint);


        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }


        setUpViewPager();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.estrella) {
            Intent intent = new Intent(MainActivity.this, MostrarRaitingMascotas.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.contacto){
            Intent intent = new Intent(MainActivity.this, Contacto.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.acercade){
            Intent intent = new Intent(MainActivity.this, Acercade.class);
            startActivity(intent);
        }
       return super.onOptionsItemSelected(item);
    }



    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);




    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new InfoPet());
        return fragments;

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
      //  tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
       // tabLayout.getTabAt(1).setIcon(R.drawable.ic_info);
        tabLayout.getTabAt(0).setText("ANIMALES");
        tabLayout.getTabAt(1).setText("INFO");

    }



}

