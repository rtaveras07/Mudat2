package com.itla.mudat.dao;

/**
 * Created by Owner on 11/25/2017.
 */

public class SQLiteHelperSchema {
    public static final String USUARIO_TABLE="\n" +
            "CREATE TABLE `usuario` (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
            "\t`nombre`\tTEXT,\n" +
            "\t`identificacion`\tINTEGER,\n" +
            "\t`telefono`\tTEXT,\n" +
            "\t`clave`\tTEXT,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`tipousuario`\tTEXT,\n" +
                "\t`estatus`\tINTEGER\n" +
            ");";
}