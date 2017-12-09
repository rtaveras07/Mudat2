package com.itla.mudat.Entity;

import android.database.Cursor;

/**
 * Created by Owner on 11/18/2017.
 */

public class Categoria {
    //ESTA CLASE ES PARA LA ENTIDAD Y SUS ATRIBUTOS, GETTER Y SETTER
    Integer idCategoria;
    String nombre;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


