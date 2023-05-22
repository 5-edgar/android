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

import com.example.shoeselectro.databinding.ActivityLihogarBinding;

import java.util.ArrayList;

public class lihogar extends AppCompatActivity {
    ArrayList<personajehogar> listHogar;

    RecyclerView recycler;
   private AppBarConfiguration appBarConfiguration;
    private ActivityLihogarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLihogarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        listHogar = new ArrayList<>();
        recycler =findViewById(R.id.recyclerhogar);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        llenarPersonajes();

        adapterhogar adapter = new adapterhogar(listHogar);
        recycler.setAdapter(adapter);
    }

    private void llenarPersonajes() {
        listHogar.add(new personajehogar("Camiseta","Ajustada en tres colores  $15.00",R.drawable.camiseta));
        listHogar.add(new personajehogar("Camiseta","Tela flexible  $18.50",R.drawable.camiseta1));
        listHogar.add(new personajehogar("Camiseta","Marathom $25.00",R.drawable.camiseta2));

    }


}