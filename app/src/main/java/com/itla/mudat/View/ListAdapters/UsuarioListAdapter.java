package com.itla.mudat.View.ListAdapters;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itla.mudat.Entity.Usuario;
import com.itla.mudat.R;

import java.util.List;

/**
 * Created by Owner on 12/02/2017.
 */

public class UsuarioListAdapter  extends BaseAdapter{
private List<Usuario> usuarios;
private Activity context;

    public UsuarioListAdapter(List<Usuario> usuarios, Activity context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return usuarios.get(i).getIdUsuario();
    }

    public String getItemnombre(int i){
        return usuarios.get(i).getNombre();

    }

    public String getItememail(int i){
        return usuarios.get(i).getEmail();

    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null){
            view=View.inflate(context.getApplicationContext(), R.layout.lista_usuario_row,null);


        }

        TextView nombre=view.findViewById(R.id.luNombre);
        TextView email=view.findViewById(R.id.luEmail);


        nombre.setText(getItemnombre(i));
        email.setText(getItememail(i));


        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
