package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.Anuncio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/30/2017.
 */

public class anuncioDbo {

    private DbConection connetion;//creando el

    public anuncioDbo(Context context) {
        connetion = new DbConection(context);

    }

    public void crear(Anuncio an) {

        SQLiteDatabase db = connetion.getWritableDatabase();
        ContentValues cv = new ContentValues();

 /* EditText fecha;
    EditText condicion;
    EditText precio;
    EditText titulo;
    EditText ubicacion;
    EditText detalle;
    EditText idusuario;
    Anuncio anuncio;*/

        cv.put("fecha", an.getFecha().toString());
        cv.put("condicion", an.getCondicion().toString());
        cv.put("precio", an.getPrecio().toString());
        cv.put("titulo", an.getTitulo().toString());
        cv.put("ubicacion", an.getUbicacion().toString());
        cv.put("detalle", an.getDetalle().toString());
        cv.put("idusuario", an.getIdusuario().toString());

        db.insert("anuncio", null, cv);
        db.close();

    }

    public List<Anuncio> buscar() {
        List<Anuncio> anu = new ArrayList<>();
        SQLiteDatabase db = connetion.getWritableDatabase();
        String columnas[] = new String[]{"id", "fecha", "condicion", "precio", "titulo", "ubicacion", "detalle", "idUsuario"};
        Cursor cursor = db.query("anuncio", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Anuncio a = new Anuncio();

            a.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            a.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            a.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            a.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            a.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            a.setDetalle(cursor.getString(cursor.getColumnIndex("detalle")));
            a.setIdusuario(cursor.getString(cursor.getColumnIndex("idUsuario")));


            cursor.moveToNext();
            anu.add(a);


        }
        cursor.close();
        db.close();
        return anu;


    }


}
