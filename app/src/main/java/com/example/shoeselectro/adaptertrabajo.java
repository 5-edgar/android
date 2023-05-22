package com.example.shoeselectro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adaptertrabajo extends RecyclerView.Adapter<adaptertrabajo.ViewHolderDatos> {
   ArrayList<personalava> listrabajo;

    public adaptertrabajo(ArrayList<personalava> listrabajo) {
        this.listrabajo = listrabajo;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlisttrabajo,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int position) {
       viewHolderDatos.etiNombre.setText(listrabajo.get(position).getNombre());
        viewHolderDatos.etiInformacion.setText(listrabajo.get(position).getInfo());
        viewHolderDatos.foto.setImageResource(listrabajo.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listrabajo.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            etiNombre = itemView.findViewById(R.id.idNombreLav);
            etiInformacion = itemView.findViewById(R.id.idInformacionLav);
           foto = itemView.findViewById(R.id.idImagenLav);
        }

    }
}
