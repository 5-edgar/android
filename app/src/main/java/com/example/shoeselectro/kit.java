package com.example.shoeselectro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class kit extends AppCompatActivity {
    ArrayList<personaKits> listKits;

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit);

        listKits = new ArrayList<>();
        recycler =findViewById(R.id.recyclerKits);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        llenarPersonajes();

        adapterKits adapter = new adapterKits(listKits);
        recycler.setAdapter(adapter);
    }

    private void llenarPersonajes() {
        listKits.add(new personaKits("Combo","Mabe",R.drawable.kit));
        listKits.add(new personaKits("Kit","Espatulas",R.drawable.kit1));
        listKits.add(new personaKits("Equipos","Cromados para la Cocina",R.drawable.kit2));
        listKits.add(new personaKits("Kit","Ollas y Sarten",R.drawable.kit3));
        listKits.add(new personaKits("Kit","Desayuno",R.drawable.kit4));
        listKits.add(new personaKits("Batidora","Multifuncion Oster",R.drawable.kit5));
        listKits.add(new personaKits("Kit","De Cocina Basico ",R.drawable.kit6));
        listKits.add(new personaKits("Equipos","Tramontina color Blanco",R.drawable.kit7));
        listKits.add(new personaKits("Kit","Desayuno color Negro",R.drawable.kit8));
        listKits.add(new personaKits("kit","Desayuno color Negro",R.drawable.kit9));
        listKits.add(new personaKits("Kit","Basico de Cocina",R.drawable.kit10));
        listKits.add(new personaKits("Kit","Cuchillos",R.drawable.kit11));
        listKits.add(new personaKits("Kit","Sarten, cuchillos",R.drawable.kit12));
        listKits.add(new personaKits("Equipos","Tramontina color rojo",R.drawable.kit13));
        listKits.add(new personaKits("Kit","Completo de Cocina",R.drawable.kit14));
        listKits.add(new personaKits("Kit","Cafetero",R.drawable.kit15));
        listKits.add(new personaKits("Kit","Ollas-Sarten",R.drawable.kit16));
        listKits.add(new personaKits("Kit","Desayuno-Tramontina",R.drawable.kit17));
        listKits.add(new personaKits("Equipos","Repostero color Negro",R.drawable.kit18));
        listKits.add(new personaKits("Equipos","De Cocina",R.drawable.kit19));
        listKits.add(new personaKits("Kit","Sarten-Ollas",R.drawable.kit20));
    }
}