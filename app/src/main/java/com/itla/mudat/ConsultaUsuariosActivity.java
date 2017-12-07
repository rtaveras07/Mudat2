package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.View.ListAdapters.UsuarioListAdapter;
import com.itla.mudat.dao.usuarioDbo;

public class ConsultaUsuariosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_usuarios);

        usuarioDbo u=new usuarioDbo(this);
        ListView list= findViewById(R.id.listausuario);
        UsuarioListAdapter a=new UsuarioListAdapter(u.buscar(),ConsultaUsuariosActivity.this);
        list.setAdapter(a);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Usuario usr = (Usuario)adapterView.getItemAtPosition(i);

                Intent kk= new Intent(ConsultaUsuariosActivity.this,RegistroUsuarioActivity.class);
                kk.putExtra("param",usr);
                startActivity(kk);
            }
        });
        
    }



    public void btnAgregarUsuario_click(View view) {
        startActivity(new Intent(this,RegistroUsuarioActivity.class));
    }




}
