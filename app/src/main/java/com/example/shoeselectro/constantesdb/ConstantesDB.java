package com.example.shoeselectro.constantesdb;

public class ConstantesDB {
    public static final String DATABASE_NAME = "usuarios.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "UsuariosReg";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_CLAVE = "clave";

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NOMBRE + " TEXT," +
                    COLUMN_EMAIL + " TEXT UNIQUE," +
                    COLUMN_CLAVE + " TEXT)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    // Datos


    public static final String CAMPO_CODIGO = "codigo";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public final static String CAMPO_PRECIO = "precio";
    public final static String NOMBRE_TABLA = "articulos";
    public final static String CREAR_TABLA_ARTICULOS = "create table articulos ("+CAMPO_CODIGO+" int, "
            +CAMPO_DESCRIPCION+" text, "
            +CAMPO_PRECIO+" real)";

}