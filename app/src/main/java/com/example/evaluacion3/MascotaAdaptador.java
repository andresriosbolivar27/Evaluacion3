package com.example.evaluacion3;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Inflara el layout y lo pasara al viewholder para que el obtenga los vies
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMV.setText(mascota.getNombre());
        mascotaViewHolder.tvContadorMV.setText(mascota.getContador());

        mascotaViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,DetalleMascota.class);
                intent.putExtra("nombre",mascota.getNombre());
                intent.putExtra("contador",mascota.getContador());
                intent.putExtra("foto",mascota.getFoto());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de mascotas
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreMV,tvContadorMV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFotoMascota);
            tvNombreMV = itemView.findViewById(R.id.tvNombreMascota);
            tvContadorMV = itemView.findViewById(R.id.tvContador);
        }
    }
}
