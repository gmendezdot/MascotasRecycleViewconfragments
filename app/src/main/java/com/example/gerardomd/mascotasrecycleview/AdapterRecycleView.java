package com.example.gerardomd.mascotasrecycleview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;



public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.AnimalesViewHolder> {

    ArrayList<Animales> Animal;
    Activity activity;
    int x=0;
    String suma;

//6
    public AdapterRecycleView(ArrayList<Animales> array, Activity activity){
        this.Animal = array;
        this.activity = activity;
    }

//4
    @Override
    public AnimalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Generar inflador
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview, parent, false);
        return new AnimalesViewHolder(v);
    }
//5
    @Override
    public void onBindViewHolder(final AnimalesViewHolder holder, final int position) {
        final Animales animals = Animal.get(position);



    holder.bone.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            holder.count.setText(String.valueOf(Integer.valueOf(animals.getCount())+1));
            animals.setCount(String.valueOf(Integer.valueOf(animals.getCount())+1));
            Toast.makeText(activity, "LE DISTE GUSTA A "+animals.getName()  ,Toast.LENGTH_SHORT).show();
        }
    });

        holder.photo.setImageResource(animals.getPhoto());
        holder.bone.setImageResource(animals.getBone());
        holder.name.setText(animals.getName());
        holder.count.setText(animals.getCount());
        holder.bone2.setImageResource(animals.getBone2());

    }
//3
    @Override
    public int getItemCount() {
        return Animal.size();
    }

    //1
    public static class AnimalesViewHolder extends RecyclerView.ViewHolder{

        private ImageView photo;
        private ImageView bone;
        private TextView name;
        private TextView count;
        private ImageView bone2;
//2 crear constructor
        public AnimalesViewHolder(View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            bone = (ImageView) itemView.findViewById(R.id.bone1);
            name = (TextView) itemView.findViewById(R.id.name);
            count = (TextView) itemView.findViewById(R.id.countfav);
            bone2 = (ImageView) itemView.findViewById(R.id.bone2);

        }
    }


}



//pasos
//1
//2crear constructor
//agregar el extends
//implementar los 3 metodos
//creamos el ArrayList
//3
//4
//Generar inflador
//5
//6