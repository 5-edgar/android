package com.example.shoeselectro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class liescolar extends AppCompatActivity {
    ArrayList<personalaptop> listescolar;

    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liescolar);

        listescolar = new ArrayList<>();
        recycler =findViewById(R.id.recyclerLaptop);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        llenarPersonajes();

        adapterEscolar adapter = new adapterEscolar(listescolar);
        recycler.setAdapter(adapter);
    }

    private void llenarPersonajes() {
        listescolar.add(new personalaptop("Laptop","Lg I5",R.drawable.compu));
        listescolar.add(new personalaptop("Laptop","Mac",R.drawable.compu1));
        listescolar.add(new personalaptop("Laptop","Lenovo I7",R.drawable.compu2));
        listescolar.add(new personalaptop("Laptop","Mac",R.drawable.compu3));
        listescolar.add(new personalaptop("Laptop","Lenovo I5",R.drawable.compu4));
        listescolar.add(new personalaptop("Laptop","Samsung",R.drawable.compu5));
        listescolar.add(new personalaptop("Escritorio","I5",R.drawable.compu6));
        listescolar.add(new personalaptop("Escritorio","I9 ",R.drawable.compu7));
        listescolar.add(new personalaptop("Escritorio","Gammers I5",R.drawable.compu8));
        listescolar.add(new personalaptop("Escritorio","Todos los Accesorios Incluidos",R.drawable.compu9));
        listescolar.add(new personalaptop("Escritorio","Todos los Accesorios Incluidos",R.drawable.compu10));
        listescolar.add(new personalaptop("Laptop","Samsung",R.drawable.compu11));
        listescolar.add(new personalaptop("Escritorio","I7",R.drawable.compu12));
    }
}

