package com.example.shoeselectro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapterEscolar extends RecyclerView.Adapter<adapterEscolar.ViewHolderDatos> {
    ArrayList<personalaptop> listEscolar;

    public adapterEscolar(ArrayList<personalaptop> listEscolar) {
        this.listEscolar = listEscolar;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlistescolar,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int position) {
        viewHolderDatos.etiNombre.setText(listEscolar.get(position).getNombre());
        viewHolderDatos.etiInformacion.setText(listEscolar.get(position).getInfo());
        viewHolderDatos.foto.setImageResource(listEscolar.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listEscolar.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView etiNombre,etiInformacion;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            etiNombre = itemView.findViewById(R.id.idNombreCompu);
            etiInformacion = itemView.findViewById(R.id.idInformacionCompu);
            foto = itemView.findViewById(R.id.idImagenCompu);
        }

    }
}
