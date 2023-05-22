package com.example.shoeselectro;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoeselectro.constantesdb.ConstantesDB;

public class Datos extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);




        et_codigo = (EditText) findViewById(R.id.txt_codigo);
        et_descripcion = (EditText) findViewById(R.id.txt_descripcion);
        et_precio = (EditText) findViewById(R.id.txt_precio);
    }

    // CREAMOS EVENTO CLICK DEL BOTTON REGISTRAR
    public void Registrar (View v){
        onClickRegistrar(v);
    }

    // METODO PARA CREAR ARTICULO

    public void onClickRegistrar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,"administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put(ConstantesDB.CAMPO_CODIGO, codigo);
            registro.put(ConstantesDB.CAMPO_DESCRIPCION, descripcion);
            registro.put(ConstantesDB.CAMPO_PRECIO, precio);

            Long resultado = baseDeDatos.insert(ConstantesDB.NOMBRE_TABLA, ConstantesDB.CAMPO_CODIGO, registro);

            baseDeDatos.close();
            et_codigo.setText("");
            Limpiar();

            Toast.makeText(this,"Registro Exitoso id: " + resultado, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }


    public void Consultar(View v){
        //onClickConsultarSql(v)
        onClickConsultar(v);
    }

    //Consulta funcion query
    public void onClickConsultar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        try{
            String[] parmetros = {et_codigo.getText().toString()};
            String[] campos = {ConstantesDB.CAMPO_DESCRIPCION,ConstantesDB.CAMPO_PRECIO};

            Cursor fila = baseDeDatos.query(ConstantesDB.NOMBRE_TABLA, campos, ConstantesDB.CAMPO_CODIGO+"=?",
                    parmetros,null,null, null );
            if(fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                baseDeDatos.close();
            }else {
                Toast.makeText(this, "No Existe el Articulo", Toast.LENGTH_SHORT).show();
                baseDeDatos.close();
                Limpiar();
            }
        }catch (Exception e){
            Toast.makeText(this, "Debes ingresar un Codigo de Producto.", Toast.LENGTH_SHORT).show();
            Limpiar();
        }
    }

    public void Limpiar(){
        et_descripcion.setText("");
        et_precio.setText("");
    }

    //Metodo Para Modificar un Articulo
    public void Modificar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this,"administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        String[] parametros = {codigo};

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put(ConstantesDB.CAMPO_CODIGO, codigo);
            registro.put(ConstantesDB.CAMPO_DESCRIPCION, descripcion);
            registro.put(ConstantesDB.CAMPO_PRECIO, precio);
            int cantidad = baseDeDatos.update(ConstantesDB.NOMBRE_TABLA, registro, ConstantesDB.CAMPO_CODIGO + "=?" , parametros);
            baseDeDatos.close();

            et_codigo.setText("");
            Limpiar();

            if (cantidad > 0 )
                Toast.makeText(this, "Datos de Articulo Modificados con Exito", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "El Registro A Modificar, No Existe", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Se deben llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para Eliminar o dar de Baja un articulo
    public void Eliminar(View view){
        ConexionSQLiteHelper admin = new ConexionSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String[] parametros = {codigo};
        if(!codigo.isEmpty()){
            int cantidad = baseDeDatos.delete(ConstantesDB.NOMBRE_TABLA, ConstantesDB.CAMPO_CODIGO+"=?",parametros);
            baseDeDatos.close();

            et_codigo.setText("");
            Limpiar();

            if (cantidad > 0)
                Toast.makeText(this, "Registro Eliminado con Exito", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "El Articulo que desea Elimar No Existe", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Debes introducir el codigo del articulo", Toast.LENGTH_SHORT).show();
        }
    }

    //Consulta Spinner
    public void ConsultaSpinner(View view){
        Intent spinner = new Intent(Datos.this, Spinner.class);
        startActivity(spinner);
    }

    //Consulta ListView
    public void ConsultaLista(View view){
        Intent listView = new Intent(Datos.this, Listview.class);
        startActivity (listView);
    }
}
