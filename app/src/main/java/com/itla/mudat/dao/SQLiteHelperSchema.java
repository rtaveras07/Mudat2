package com.itla.mudat.dao;

/**
 * Created by Owner on 11/25/2017.
 */

public class SQLiteHelperSchema {
    public static final String USUARIO_TABLE="\n" +
            "CREATE TABLE `usuario` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`nombre`\tTEXT,\n" +
            "\t`identificacion`\tTEXT,\n" +
            "\t`telefono`\tTEXT,\n" +
            "\t`clave`\tTEXT,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`tipousuario`\tTEXT,\n" +
                "\t`estatus`\tINTEGER\n" +
            ");";

    public static final String CATEGORIA_TABLE="CREATE TABLE `categoria` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`nombre`\tTEXT\n" +
            ");";


    public static final String ANUNCIO_TABLE="CREATE TABLE `anuncio` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`fecha`\tTEXT,\n" +
            "\t`condicion`\tTEXT,\n" +
            "\t`precio`\tREAL,\n" +
            "\t`titulo`\tTEXT,\n" +
            "\t`ubicacion`\tTEXT,\n" +
            "\t`detalle`\tTEXT,\n" +
            "\t`idusuario`\tINTEGER\n" +
            ");";



}