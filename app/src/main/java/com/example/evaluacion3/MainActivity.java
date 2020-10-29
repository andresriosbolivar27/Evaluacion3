package com.example.evaluacion3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView info;
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        InicializarListaMascotas();
        InicializarAdaptador();

        //Obteniendo la intancia del textview
        info =(TextView)findViewById(R.id.info);
    }

    public void InicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Mascota 1","5",R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2","4",R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 3","3",R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 4","1",R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 5","8",R.drawable.mascota5));
        mascotas.add(new Mascota("Mascota 6","10",R.drawable.mascota6));
        mascotas.add(new Mascota("Mascota 7","9",R.drawable.mascota7));
        mascotas.add(new Mascota("Mascota 8","6",R.drawable.mascota8));
        mascotas.add(new Mascota("Mascota 9","7",R.drawable.mascota9));
    }
    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
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
                Intent intent = new Intent(MainActivity.this,UltimasMascotasFavoritas.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}