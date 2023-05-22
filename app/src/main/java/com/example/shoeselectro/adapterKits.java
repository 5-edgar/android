package com.example.shoeselectro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterKits extends RecyclerView.Adapter<adapterKits.ViewHolderDatos> {

    ArrayList<personaKits> listKits;

    public adapterKits(ArrayList<personaKits> listKits) {
        this.listKits = listKits;
    }

    @NonNull
    @Override
    public adapterKits.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlistkits,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterKits.ViewHolderDatos viewHolderDatos, int position) {
       viewHolderDatos.etiNombre.setText(listKits.get(position).getNombre());
       viewHolderDatos.etiInformacion.setText(listKits.get(position).getInfo());
       viewHolderDatos.foto.setImageResource(listKits.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listKits.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            etiNombre = itemView.findViewById(R.id.idNombreKits);
            etiInformacion = itemView.findViewById(R.id.idInformacionKits);
            foto = itemView.findViewById(R.id.idImagenKits);
        }
    }
}
