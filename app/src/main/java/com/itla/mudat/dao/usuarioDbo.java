package com.itla.mudat.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.itla.mudat.Entity.TipodeUsuario;
import com.itla.mudat.Entity.Usuario;

import java.sql.SQLInput;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/25/2017.
 */

public class usuarioDbo {
    private DbConection connetion;//creando el

    public usuarioDbo(Context context) {
        connetion = new DbConection(context);

    }

    public void crear(Usuario usuario) {

        SQLiteDatabase db = connetion.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nombre", usuario.getNombre());
        cv.put("identificacion", usuario.getIdIdentificacion());
        cv.put("telefono", usuario.getTelefono());
        cv.put("clave", usuario.getClave());
        cv.put("email", usuario.getEmail());
        cv.put("tipousuario",  usuario.getTipoUsuario().toString());
        cv.put("estatus", usuario.getEstatus());
        db.insert("usuario", null, cv);
        db.close();

    }

    public List<Usuario> buscar() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = connetion.getWritableDatabase();
        String columnas[] = new String[]{"id", "nombre","identificacion","telefono","clave","email","tipousuario","estatus"};
        Cursor cursor = db.query("usuario", columnas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Usuario u = new Usuario();
            u.setIdUsuario(cursor.getInt(cursor.getColumnIndex("idUsuario")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setIdIdentificacion(cursor.getInt(cursor.getColumnIndex("identificacion")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setClave(cursor.getString(cursor.getColumnIndex("clave")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTipoUsuario(TipodeUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipousuario"))));
            u.setEstatus(Boolean.valueOf(cursor.getString(cursor.getColumnIndex("estatus"))));
            cursor.moveToNext();
            usuarios.add(u);


        }
        cursor.close();
        db.close();
        return usuarios;


    }


}
