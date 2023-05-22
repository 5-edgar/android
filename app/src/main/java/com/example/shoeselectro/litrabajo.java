package com.example.shoeselectro;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.shoeselectro.databinding.ActivityLitrabajoBinding;

import java.util.ArrayList;

public class litrabajo extends AppCompatActivity {
    ArrayList<personalava> listrabajo;
    RecyclerView recicler;
    //private AppBarConfiguration appBarConfiguration;
    private ActivityLitrabajoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLitrabajoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listrabajo = new ArrayList<>();
        recicler = findViewById(R.id.recyclelavadora);
        
        recicler.setLayoutManager(new LinearLayoutManager(this));
        llenarPersonaje();

       adaptertrabajo adapter = new adaptertrabajo(listrabajo);
       recicler.setAdapter(adapter);
    }

    private void llenarPersonaje() {

        listrabajo.add(new personalava("Lavadora","Samsung Color Blanco ",R.drawable.lavadora));
        listrabajo.add(new personalava("Lavadora","Mabe 40 Visible Color Negro",R.drawable.lavadora1));
        listrabajo.add(new personalava("Lavadora","Electrolux Color Plata 50",R.drawable.lavadora3));
        listrabajo.add(new personalava("Lavadora","Samsung Color Plata 50",R.drawable.lavadora4));
        listrabajo.add(new personalava("Lavadora","Jnox 12 Color Plata",R.drawable.lavadora5));
        listrabajo.add(new personalava("Lavadora","Indurama Color Blanco",R.drawable.lavadora6));
        listrabajo.add(new personalava("Lavadora","Indurama Visible Color Blanco",R.drawable.lavadora7));
        listrabajo.add(new personalava("Lavadora","Mabe Doble Color Cafe",R.drawable.lavadora8));
        listrabajo.add(new personalava("Lavadora","Indurama Color Negro",R.drawable.lavadora9));
        listrabajo.add(new personalava("Lavadora","Mabe doble capacidad",R.drawable.lavadora10));
    }


}