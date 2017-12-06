package com.itla.mudat.OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Owner on 11/18/2017.
 */

public class SQLite_OpenHelper extends SQLiteOpenHelper {

    //CREANDO LA DB
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    //CREANDO LA TABLA
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE `usuario` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "\t`nombre`\tTEXT,\n" +
                "\t`identificacion`\tINTEGER,\n" +
                "\t`telefono`\tTEXT,\n" +
                "\t`clave`\tTEXT,\n" +
                "\t`email`\tTEXT,\n" +
                "\t`tipousuario`\tTEXT,\n" +
                "\t`estatus`\tINTEGER\n" +
                ");";

        String anuncio ="CREATE TABLE `anuncio` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`idcategoria`\tTEXT,\n" +
                "\t`fecha`\tTEXT,\n" +
                "\t`condicion`\tTEXT,\n" +
                "\t`precio`\tREAL,\n" +
                "\t`titulo`\tTEXT,\n" +
                "\t`ubicacion`\tTEXT,\n" +
                "\t`detalle`\tTEXT,\n" +
                "\t`idusuario`\tINTEGER\n" +
                ");";

        String cat=




    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //abrir la db
    public void abrir() {
        this.getWritableDatabase().getClass();

    }

    //cerrar la db
    public void cerrar() {
        this.close();

    }

    //metodo insertar registros en la tabla usuarios
    public void insertarRegistros(String nom, String ident, String tel, String cla, String correo, String tipo, Integer status) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", nom);
        valores.put("identificacion", ident);
        valores.put("telefono", tel);
        valores.put("clave", cla);
        valores.put("email", correo);
        valores.put("tipousuario", tipo);
        valores.put("estatus", status);

this.getWritableDatabase().insert("usuario",null,valores);
    }






}
