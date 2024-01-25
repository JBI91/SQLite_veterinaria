package com.example.sqlite_veterinaria.Controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sqlite_veterinaria.Model.Perro;
import com.example.sqlite_veterinaria.Model.Propietario;

import java.util.ArrayList;
import java.util.List;

public class CtrlVeterinaria {
    private List<Propietario> listPropietario = new ArrayList<>();
    private List<Perro> listPerros = new ArrayList<>();
    static long propietario_id;

    public static List<Propietario> getListaPropietario(Context context) {
        List<Propietario> list = new ArrayList<>();
        SQLiteDatabase db = new DBSQLite(context).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM propietario", null);

        if (cursor.getCount() == 0) {
            Log.i("ERROR", "NO SE HAN ENCONTRADO REGISTROS EN LA BD");
        } else {
            cursor.moveToFirst();
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String apellidos = cursor.getString(cursor.getColumnIndexOrThrow("apellidos"));
                String telefeno = cursor.getString(cursor.getColumnIndexOrThrow("telefono"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("eMail"));
                Propietario p = new Propietario(id, nombre, apellidos, telefeno, email);
                list.add(p);
            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return list;
    }

    public static List<Perro> getListaPerros(Context context) {
        List<Perro> list = new ArrayList<>();
        SQLiteDatabase db = new DBSQLite(context).getReadableDatabase();

        String[] projection = {
                "id",
                "nombre",
                "fecha_nacimiento",
                "estaVacunado",
                "esMacho",
                "comentarios",
                "raza_id"
        };

        String selection = "propietario_id = ?";
        String[] selectionArgs = {String.valueOf(propietario_id)};

        Cursor cursor = db.query(
                "perro",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.getCount() == 0) {
            Log.i("ERROR", "NO SE HAN ENCONTRADO PERROS PARA EL PROPIETARIO CON ID: " + propietario_id);
        } else {
            cursor.moveToFirst();
            do {
                if (cursor.getInt(cursor.getColumnIndexOrThrow("propietario_id")) == propietario_id) {
                    long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                    String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                    //String fecha_nacimiento = cursor.getString(cursor.getColumnIndexOrThrow("fecha_nacimiento"));
                    boolean estaVacunado = cursor.getInt(cursor.getColumnIndexOrThrow("estaVacunado")) == 1;
                    boolean esMacho = cursor.getInt(cursor.getColumnIndexOrThrow("esMacho")) == 1;
                    String comentarios = cursor.getString(cursor.getColumnIndexOrThrow("comentarios"));
                    long raza_id = cursor.getLong(cursor.getColumnIndexOrThrow("raza_id"));

                    Perro perro = new Perro(id, raza_id, propietario_id, nombre, comentarios, esMacho, estaVacunado);
                    list.add(perro);
                }

            } while (cursor.moveToNext());
            cursor.close();
            db.close();
        }
        return list;
    }

}
