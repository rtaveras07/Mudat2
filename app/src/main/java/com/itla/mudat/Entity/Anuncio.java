package com.itla.mudat.Entity;

import java.util.Date;

/**
 * Created by Owner on 11/18/2017.
 */

public class Anuncio {
   Integer idAnuncio;

    Categoria categoria;
    Usuario idUsuario;
    Date fecha;
    String condicion;
    Double precio;
    String titulo;
    String ubicacion;
    String detalle;

 public Integer getIdAnuncio() {
  return idAnuncio;
 }

 public void setIdAnuncio(Integer idAnuncio) {
  this.idAnuncio = idAnuncio;
 }

 public Categoria getCategoria() {
  return categoria;
 }

 public void setCategoria(Categoria categoria) {
  this.categoria = categoria;
 }

 public Usuario getIdUsuario() {
  return idUsuario;
 }

 public void setIdUsuario(Usuario idUsuario) {
  this.idUsuario = idUsuario;
 }



 public Date getFecha() {
  return fecha;
 }

 public void setFecha(Date fecha) {
  this.fecha = fecha;
 }

 public String getCondicion() {
  return condicion;
 }

 public void setCondicion(String condicion) {
  this.condicion = condicion;
 }

 public Double getPrecio() {
  return precio;
 }

 public void setPrecio(Double precio) {
  this.precio = precio;
 }

 public String getTitulo() {
  return titulo;
 }

 public void setTitulo(String titulo) {
  this.titulo = titulo;
 }

 public String getUbicacion() {
  return ubicacion;
 }

 public void setUbicacion(String ubicacion) {
  this.ubicacion = ubicacion;
 }

 public String getDetalle() {
  return detalle;
 }

 public void setDetalle(String detalle) {
  this.detalle = detalle;
 }
}
