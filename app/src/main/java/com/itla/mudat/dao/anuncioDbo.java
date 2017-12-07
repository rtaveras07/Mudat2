package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.itla.mudat.Entity.Anuncio;
import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.RegistroAnuncioActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/30/2017.
 */

public class anuncioDbo {

    private DbConection connetion;//creando el
    public boolean error;
    public Anuncio anuncio;

    public anuncioDbo(Context context) {
        connetion = new DbConection(context);

    }

    public boolean crear(Anuncio an) {

        SQLiteDatabase db = connetion.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fecha", an.getFecha());
        cv.put("condicion", an.getCondicion());
        cv.put("precio", an.getPrecio());
        cv.put("titulo", an.getTitulo());
        cv.put("ubicacion", an.getUbicacion());
        cv.put("detalle",an.getDetalle());
        cv.put("idusuario",an.getIdusuario());


        try {
            db.insert("anuncio", null, cv);
            error = false;
        } catch (Error er) {
            error = true;

        }


        db.close();
        return error;


    }

    public List<Anuncio> buscarAnuncio() {
        List<Anuncio> anu = new ArrayList<>();
        SQLiteDatabase db = connetion.getWritableDatabase();
        String columnas[] = new String[]{"fecha", "condicion", "precio", "titulo", "ubicacion", "detalle", "idUsuario"};
        Cursor cursor = db.query("anuncio", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            anuncio = new Anuncio();

            anuncio.setFecha(cursor.getString(cursor.getColumnIndex("fecha")));
            anuncio.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            anuncio.setPrecio(cursor.getDouble(cursor.getColumnIndex("precio")));
            anuncio.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            anuncio.setUbicacion(cursor.getString(cursor.getColumnIndex("ubicacion")));
            anuncio.setDetalle(cursor.getString(cursor.getColumnIndex("detalle")));
            anuncio.setIdusuario(cursor.getInt(cursor.getColumnIndex("idUsuario")));


            cursor.moveToNext();
            anu.add(anuncio);


        }
        cursor.close();
        db.close();
        return anu;


    }


}
