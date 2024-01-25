package com.example.sqlite_veterinaria.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sqlite_veterinaria.Controller.CtrlVeterinaria;
import com.example.sqlite_veterinaria.Model.Perro;
import com.example.sqlite_veterinaria.Model.Propietario;
import com.example.sqlite_veterinaria.R;

import java.util.List;

public class PerrosListActivity extends AppCompatActivity {
    private List<Perro> perrosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perros_list);

        long propietario_id = getIntent().getLongExtra("propietario_id", -1);

        if (propietario_id != -1) {
            perrosList = CtrlVeterinaria.getListaPerros(this);
            RecyclerView rvPerros = findViewById(R.id.rvPerros);
            rvPerros.setLayoutManager(new LinearLayoutManager(this));
            PerroAdapter adapter = new PerroAdapter(this);
            rvPerros.setAdapter(adapter);
        }
    }

}