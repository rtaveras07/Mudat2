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
    private DbConection connetion;//creando el

    public categoriaDbo(Context context) {
        connetion = new DbConection(context);

    }

    public void crear(Categoria ca) {

        SQLiteDatabase db = connetion.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", ca.getNombre());

        db.insert("categoria", null, cv);
        db.close();

    }

    public List<Categoria> buscar() {
        List<Categoria> cat = new ArrayList<>();
        SQLiteDatabase db = connetion.getWritableDatabase();
        String columnas[] = new String[]{"id", "nombre"};
        Cursor cursor = db.query("categoria", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Categoria u = new Categoria();

            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));

            cursor.moveToNext();
            cat.add(u);


        }
        cursor.close();
        db.close();
        return cat;


    }
}
