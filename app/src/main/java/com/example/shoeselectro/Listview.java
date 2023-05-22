package com.example.shoeselectro;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shoeselectro.constantesdb.ConstantesDB;
import com.example.shoeselectro.utilidades.Articulo;

import java.util.ArrayList;

public class Listview extends AppCompatActivity {


    private ListView lvArticulos;
    private ArrayList<String> lista;
    private ArrayList<Articulo> listaArticulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);





        lvArticulos = (ListView)findViewById(R.id.lv_articulos);

        consultarListaArticulos();

        lvArticulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0) {
                    Articulo articulo = new Articulo();
                    articulo = listaArticulos.get(i - 1);

                    Toast.makeText(Listview.this, "id: " + String.valueOf(articulo.getCodigo()) + "\n"
                            + "Descripcion: " + articulo.getDescripcion() + "\n"
                            + "Precio: " + articulo.getPrecio().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void consultarListaArticulos(){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(getApplicationContext(), "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getReadableDatabase();

        Articulo articulo = null;
        listaArticulos = new ArrayList<Articulo>();

        String query = "select * from " + ConstantesDB.NOMBRE_TABLA;
        Cursor filas = baseDeDatos.rawQuery(query, null);
        while(filas.moveToNext()){
            articulo = new Articulo();
            articulo.setCodigo(filas.getInt(0));
            articulo.setDescripcion(filas.getString(1));
            articulo.setPrecio(filas.getFloat(2));
            listaArticulos.add(articulo);
        }

        lista = new ArrayList<String>();
        lista.add("Seleccione");
        for(int i=0; i < listaArticulos.size(); i++){
            lista.add(listaArticulos.get(i).getCodigo()+" - "+listaArticulos.get(i).getDescripcion());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        lvArticulos.setAdapter(adaptador);
    }

    public void Salir(View view){
        finish();
    }

}