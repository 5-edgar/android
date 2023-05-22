package com.example.shoeselectro;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shoeselectro.constantesdb.ConstantesDB;
import com.example.shoeselectro.utilidades.Articulo;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {


    private android.widget.Spinner spArticulos;
    private TextView tvCodigo, tvNombre, tvPrecio;
    ArrayList<String> listaSpinner;
    ArrayList<Articulo> listaArticulos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);




        spArticulos = (android.widget.Spinner)findViewById(R.id.sp_articulos);
        tvCodigo = (TextView)findViewById(R.id.tv_codigo);
        tvNombre = (TextView)findViewById(R.id.tv_nombre);
        tvPrecio = (TextView)findViewById(R.id.tv_precio);

        consultarListaArticulos();

        // se ejecuta cuando cambie la seleccion de items en el Spinner.
        spArticulos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i>0) {
                    Articulo articulo = new Articulo();
                    articulo = listaArticulos.get(i-1);

                    tvCodigo.setText(String.valueOf(articulo.getCodigo()));
                    tvNombre.setText(articulo.getDescripcion());
                    tvPrecio.setText(articulo.getPrecio().toString());
                }else{
                    tvCodigo.setText("");
                    tvNombre.setText("");
                    tvPrecio.setText("");
                }
            }

            // este metodo se ejecuta cuando se ejecuta el Activity
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
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

        listaSpinner = new ArrayList<String>();
        listaSpinner.add("Seleccione");
        for(int i=0; i < listaArticulos.size(); i++){
            listaSpinner.add(listaArticulos.get(i).getCodigo()+" - "+listaArticulos.get(i).getDescripcion());
        }

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSpinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spArticulos.setAdapter(adaptador);
    }

    public void Salir(View view){
        finish();
    }
}
