package com.example.shoeselectro;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shoeselectro.constantesdb.ConstantesDB;
import com.example.shoeselectro.utilidades.utilidades;

public class registro extends AppCompatActivity {

    EditText txt_nombrereg, txt_emailreg, txt_clavereg;
    Button btnregistrar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Asociamos las variables creadas con los id de nuestro Activity
        txt_nombrereg = findViewById(R.id.txtnombrereg);
        txt_emailreg = findViewById(R.id.txtemailreg);
        txt_clavereg = findViewById(R.id.txtclavereg);
        btnregistrar = findViewById(R.id.btnregistrarreg);


        // Creamos evento para programar el botón Registrar
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener la instancia de la base de datos
                ConexionSQLiteHelper admin = new ConexionSQLiteHelper(registro.this, "UsuariosReg", null, 1);
                SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

                String nombre = txt_nombrereg.getText().toString();
                String email = txt_emailreg.getText().toString();
                String clave = txt_clavereg.getText().toString();

                if (!nombre.isEmpty() && !email.isEmpty() && !clave.isEmpty()) {
                    ContentValues registro = new ContentValues();
                    registro.put(ConstantesDB.COLUMN_NOMBRE, nombre);
                    registro.put(ConstantesDB.COLUMN_EMAIL, email);
                    registro.put(ConstantesDB.COLUMN_CLAVE, clave);

                    Long resultado = baseDeDatos.insert(ConstantesDB.TABLE_NAME, null, registro);

                    baseDeDatos.close();
                    limpiarCampos();

                    Toast.makeText(registro.this, "Registro Exitoso !! " + resultado, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(registro.this,login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(registro.this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }
            }


            private void limpiarCampos() {
                txt_nombrereg.setText("");
                txt_emailreg.setText("");
                txt_clavereg.setText("");
            }
        });
    }
}
