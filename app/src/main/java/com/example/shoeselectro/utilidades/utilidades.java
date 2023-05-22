package com.example.shoeselectro.utilidades;

public class utilidades {

   //Constantes campos tabla usuario;


   public static final String TABLA_USUARIO = "usuario";
   public static final String CAMPO_ID = "id";
   public static final String CAMPO_NOMBRE = "nombre";
   public static final String CAMPO_APELLIDO = "apellido";
   public static final String CAMPO_CORREO = "correo";
   public static final String CAMPO_PASSWORD = "password";

   public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ TABLA_USUARIO +" " +
           "("+ CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "+CAMPO_CORREO+" TEXT, "+CAMPO_PASSWORD+" TEXT )";
}
