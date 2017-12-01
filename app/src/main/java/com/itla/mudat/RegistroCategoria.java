package com.itla.mudat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.itla.mudat.Entity.Categoria;
import com.itla.mudat.dao.DbConection;
import com.itla.mudat.dao.categoriaDbo;

public class RegistroCategoria extends AppCompatActivity {
    EditText categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_categoria);
    }


    public void Guardar(View view) {

        //opteniendo los objetos campos
        categoria = (EditText) findViewById(R.id.editCategoria);
        //instanciando la clase
        Categoria ca= new Categoria();
        ca.setNombre( categoria.getText().toString());

        categoriaDbo db = new categoriaDbo(this);
        db.crear(ca);





    }



    public void consulta(View view){

    }



}
