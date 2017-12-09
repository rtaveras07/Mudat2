package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.TipodeUsuario;
import com.itla.mudat.Entity.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/25/2017.
 */

public class usuarioDbo {
    private DbConection connetion;//creando el
    public Boolean paso;

    public usuarioDbo(Context context) {
        connetion = new DbConection(context);

    }

    public boolean crear(Usuario usuario) {

        SQLiteDatabase db = connetion.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nombre", usuario.getNombre());
        cv.put("identificacion", usuario.getIdIdentificacion());
        cv.put("telefono", usuario.getTelefono());
        cv.put("clave", usuario.getClave());
        cv.put("email", usuario.getEmail());
        cv.put("tipousuario", usuario.getTipoUsuario().toString());
        cv.put("estatus", usuario.getEstatus());

        try {
            db.insert("usuario", null, cv);

            db.close();
            paso = true;
        } catch (Error e) {
            paso = false;
        }
        return paso;
    }


    public boolean editar(Usuario usuario) {

        SQLiteDatabase db = connetion.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nombre", usuario.getNombre());
        cv.put("identificacion", usuario.getIdIdentificacion());
        cv.put("telefono", usuario.getTelefono());
        cv.put("clave", usuario.getClave());
        cv.put("email", usuario.getEmail());
        cv.put("tipousuario", usuario.getTipoUsuario().toString());
        cv.put("estatus", usuario.getEstatus());



        try {
            db.update("usuario", cv, "id=" + usuario.getIdUsuario(), null);
            db.close();
            paso = false;
        } catch (Error e) {
            paso = true;
        }
        return paso;

    }

    public List<Usuario> buscar() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = connetion.getWritableDatabase();
        String columnas[] = new String[]{"id", "nombre", "identificacion", "telefono", "clave", "email", "tipousuario", "estatus"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Usuario u = new Usuario();
            u.setIdUsuario(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setIdIdentificacion(cursor.getString(cursor.getColumnIndex("identificacion")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setClave(cursor.getString(cursor.getColumnIndex("clave")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTipoUsuario(TipodeUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipousuario"))));
            u.setEstatus(Boolean.valueOf(cursor.getString(cursor.getColumnIndex("estatus"))));
            cursor.moveToNext();
            usuarios.add(u);


            // Log.i("Mudat: ", String.valueOf(u.getIdIdentificacion()));


        }
        cursor.close();
        db.close();
        return usuarios;


    }


}
