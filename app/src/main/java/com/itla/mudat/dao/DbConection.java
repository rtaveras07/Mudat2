package com.itla.mudat.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Owner on 11/25/2017.
 */

public class DbConection extends SQLiteOpenHelper{
    public DbConection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
     public static String DATABASE_NAME="mudat.db";
    public static String LOG_T="DbConnetion";

    public DbConection(Context context) {
        super(context, DATABASE_NAME,  null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // Log.i(LOG_T, "Iniciando onCreate");
        db.execSQL(SQLiteHelperSchema.USUARIO_TABLE);
        db.execSQL(SQLiteHelperSchema.CATEGORIA_TABLE);
      db.execSQL(SQLiteHelperSchema.ANUNCIO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
