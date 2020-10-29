package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class UltimasMascotasFavoritas extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_mascotas_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotas = findViewById(R.id.rvUltimasMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        InicializarListaMascotas();
        InicializarAdaptador();
    }

    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void InicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();


        mascotas.add(new Mascota("Mascota 5","8",R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 4","1",R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 3","3",R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 2","4",R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 1","5",R.drawable.mascota1));





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnFavorito:
                //metodoAdd()
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}