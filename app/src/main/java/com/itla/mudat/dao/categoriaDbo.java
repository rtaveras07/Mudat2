package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/29/2017.
 */

public class categoriaDbo {
    private DbConection connetion;//OBJETO CONEXION

    public categoriaDbo(Context context) {
        connetion = new DbConection(context);

    }

    public void crear(Categoria ca) { //PARAMETROS A INSERTAR

        SQLiteDatabase db = connetion.getWritableDatabase();//abre la base de datos en modo solo lectura o lectura y escritura.
        ContentValues cv = new ContentValues(); //para retener los valores de un solo registro, que será el que se insertará.
        cv.put("nombre", ca.getNombre());//UNICO VALOR EN ESTE CASO



        db.insert("categoria", null, cv);//TABLA Y PARAMETROS A INSERTAR
        db.close();//CIERRA LA CONSULTA.

    }

    public List<Categoria> buscarc() {//LISTA DE LA CONSULTA
        List<Categoria> cat = new ArrayList<>();// PARA LISTAR LOS CAMPOS
        SQLiteDatabase db = connetion.getWritableDatabase();//ABRIENDO LA CONEXION
        String columnas[] = new String[]{"id", "nombre"};//CREANDO EL ARREGLO
        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null);
       //ASIGANDO LA CONSULTA AL CURSOR
        cursor.moveToFirst();// MOVER EL CURSOS A

        while (!cursor.isAfterLast()) {//MIENTRAS NO SEA EL ULTIMO REGISTRO
            Categoria u = new Categoria();
            u.setIdCategoria(cursor.getInt(cursor.getColumnIndex("id")));//SE ASIGNAN LOS VALORES
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));//SE ASIGNAN LOS VALORES
            cursor.moveToNext();
            cat.add(u);
        }

        cursor.close();
        db.close();
        return cat;


    }


}
