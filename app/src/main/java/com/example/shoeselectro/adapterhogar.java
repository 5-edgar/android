package com.example.shoeselectro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterhogar extends RecyclerView.Adapter<adapterhogar.ViewHolderDatos> {

   ArrayList<personajehogar> listHogar;

    public adapterhogar(ArrayList<personajehogar> listHogar) {
        this.listHogar = listHogar;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlisthogar,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int position) {
          viewHolderDatos.etiNombre.setText(listHogar.get(position).getNombre());
          viewHolderDatos.etiInformacion.setText(listHogar.get(position).getInfo());
        viewHolderDatos.foto.setImageResource(listHogar.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listHogar.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView etiNombre,etiInformacion;
         ImageView foto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

             etiNombre = itemView.findViewById(R.id.idNombreRe);
             etiInformacion = itemView.findViewById(R.id.idInformacionRe);
             foto = itemView.findViewById(R.id.idImagenRe);
        }


    }
}
