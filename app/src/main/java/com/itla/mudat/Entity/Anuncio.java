package com.itla.mudat.Entity;

import android.widget.EditText;

import java.util.Date;

/**
 * Created by Owner on 11/18/2017.
 */

public class Anuncio {
 Integer id;
 String fecha;
 String condicion;
 Double precio;
 String titulo;
 String ubicacion;
 String detalle;
 String idusuario;


 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getFecha() {
  return fecha;
 }

 public void setFecha(String fecha) {
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

 public String getIdusuario() {
  return idusuario;
 }

 public void setIdusuario(String idusuario) {
  this.idusuario = idusuario;
 }
}
