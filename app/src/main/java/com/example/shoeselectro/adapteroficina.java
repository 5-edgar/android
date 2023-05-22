package com.example.shoeselectro;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class adapteroficina extends RecyclerView.Adapter<adapteroficina.ViewHolderDatos> {
    ArrayList<personatele> listTele;

    public adapteroficina(ArrayList<personatele> listTele) {
        this.listTele = listTele;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlistoficina,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int position) {
      viewHolderDatos.etiNombre.setText(listTele.get(position).getNombre());
      viewHolderDatos.etiInformacion.setText(listTele.get(position).getInfo());
      viewHolderDatos.foto.setImageResource(listTele.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listTele.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView etiNombre,etiInformacion;
        ImageView foto;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            etiNombre = itemView.findViewById(R.id.idNombreTele);
            etiInformacion = itemView.findViewById(R.id.idInformacionTele);
            foto = itemView.findViewById(R.id.idImagenTele);
        }

    }
}
