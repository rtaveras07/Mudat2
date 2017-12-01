package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void lanzar(View view) {
        Intent i = new Intent(this, RegistroUsuario.class );
        startActivity(i);
    }
    public void categoria(View view) {
        Intent i = new Intent(this, RegistroCategoria.class );
        startActivity(i);
    }

    public void regAnuncio(View view) {
        Intent i = new Intent(this, RegistroAnuncio.class );
        startActivity(i);
    }


}
