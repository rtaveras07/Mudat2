package com.itla.mudat.Entity;

import android.text.Editable;

import java.io.Serializable;

/**
 * Created by Owner on 11/18/2017.
 */

public class Usuario implements Serializable {


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", idIdentificacion=" + idIdentificacion +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", clave='" + clave + '\'' +
                ", estatus=" + estatus +
                '}';
    }

    Integer idUsuario;
    String nombre;
    TipodeUsuario tipoUsuario;
    Integer idIdentificacion;
    String email;
    String telefono;
    String clave;
    Boolean estatus;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipodeUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipodeUsuario tipou ) {
        this.tipoUsuario = tipou;
    }


    public Integer getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(int id ) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }



}
