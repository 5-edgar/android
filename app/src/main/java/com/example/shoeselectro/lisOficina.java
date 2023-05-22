package com.example.shoeselectro;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class lisOficina extends AppCompatActivity {
    ArrayList<personatele> listele;

    RecyclerView recycler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis_oficina);

        listele = new ArrayList<>();
        recycler = findViewById(R.id.recyclerTele);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        llenarPersonaje();

      adapteroficina adapter = new adapteroficina(listele);
      recycler.setAdapter(adapter);
}

    private void llenarPersonaje() {
        listele.add(new personatele("Televisor","Samsung 42",R.drawable.televisor));
        listele.add(new personatele("Televisor","Lg 42",R.drawable.televisor1));
        listele.add(new personatele("Televisor","Lg 51",R.drawable.televisor2));
        listele.add(new personatele("Televisor","Samsung 45",R.drawable.televisro3));
        listele.add(new personatele("Televisor","Daewoo 35",R.drawable.televisro4));
        listele.add(new personatele("Televisor","Lg 51",R.drawable.televisro5));
        listele.add(new personatele("Televisor","Samsung 39",R.drawable.televisro6));
        listele.add(new personatele("Televisor","Lg 59",R.drawable.televisro7));
        listele.add(new personatele("Televisor","Sanmsung 41",R.drawable.televisro8));
    }

}