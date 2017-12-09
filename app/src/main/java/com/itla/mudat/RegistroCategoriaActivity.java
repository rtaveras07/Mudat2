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

public class RegistroCategoriaActivity extends AppCompatActivity {
    EditText categoria;
EditText nombre;
EditText id;

Categoria ca=new Categoria();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_categoria);




    //capturando los campos de la actividad
    nombre = (EditText) findViewById(R.id.editCategoria);

    //anuncioDbo a = new anuncioDbo(this);
    //a.buscarAnuncio();

    Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
        ca = (Categoria) bundle.getSerializable("parametro");
        id.setText(ca.getIdCategoria().toString());
        nombre.setText(ca.getNombre().toString());


    } }
    public void Guardar(View view) {

        //opteniendo LOS OBJETOS
        categoria = (EditText) findViewById(R.id.editCategoria);
        //instanciando la clase DE LA ENTIDAD GETTER Y SETTER
        Categoria ca= new Categoria();
        ca.setNombre( categoria.getText().toString());//SETTER DE LA CLASE

        categoriaDbo db = new categoriaDbo(this);//INSERTAR LOS DATOS EN LA CLASE
        db.crear(ca);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ca = (Categoria) bundle.getSerializable("param");

            nombre = (EditText) findViewById(R.id.editCategoria);

        }



    }


    public void consulta(View view){

        Categoria ca = new Categoria();
        ca.setNombre(ca.getNombre().toString());
        categoriaDbo dbo= new categoriaDbo(this);
        dbo.buscarc();


    }



}
