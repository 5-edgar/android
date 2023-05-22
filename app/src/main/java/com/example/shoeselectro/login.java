package com.example.shoeselectro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText txt_emailreg, txt_clavereg;

    Button btnlogin, btn_registrarselog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        txt_emailreg = findViewById(R.id.txtemailreg);
        txt_clavereg = findViewById(R.id.txtclavereg);
        btnlogin = findViewById(R.id.btn_login);
        btn_registrarselog = findViewById(R.id.btn_registrarselog);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la instancia de la base de datos
                ConexionSQLiteHelper admin = new ConexionSQLiteHelper(login.this, "UsuariosReg", null, 1);
                SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

                // Obtener los valores ingresados por el usuario
                String email = txt_emailreg.getText().toString();
                String clave = txt_clavereg.getText().toString();

                // Realizar la consulta a la base de datos
                Cursor cursor = baseDeDatos.rawQuery("SELECT * FROM UsuariosReg WHERE email = ? AND clave = ?", new String[]{email, clave});

                // Verificar si el cursor tiene algún resultado
                if (cursor.moveToFirst()) {
                    // Si hay un registro con las mismas credenciales, se puede iniciar sesión
                    Toast.makeText(login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    //Creamos un Intent para redirigir a la actividad "Registro"
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Si no hay resultados, las credenciales no son válidas
                    Toast.makeText(login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

                // Cerrar la conexión con la base de datos
                cursor.close();
                baseDeDatos.close();
            }
        });

        // Creamos evento para programar el boton Registrarse
        btn_registrarselog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un Intent para redirigir a la actividad "Registro"
                Intent intent = new Intent(login.this, registro.class);
                startActivity(intent);
            }
        });
    }
}
