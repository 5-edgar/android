package com.example.shoeselectro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.shoeselectro.constantesdb.ConstantesDB;
import com.example.shoeselectro.utilidades.utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL(ConstantesDB.SQL_CREATE_TABLE);
        baseDeDatos.execSQL(ConstantesDB.CREAR_TABLA_ARTICULOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int oldVersion, int newVersion) {
        baseDeDatos.execSQL("drop table if exists "+ ConstantesDB.TABLE_NAME);
        baseDeDatos.execSQL("drop table if exists "+ ConstantesDB.NOMBRE_TABLA);
        onCreate(baseDeDatos);
    }
}
