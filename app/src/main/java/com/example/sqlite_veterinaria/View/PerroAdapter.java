package com.example.sqlite_veterinaria.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_veterinaria.Controller.CtrlVeterinaria;
import com.example.sqlite_veterinaria.Model.Perro;
import com.example.sqlite_veterinaria.R;

import java.util.List;

public class PerroAdapter extends RecyclerView.Adapter<PerroAdapter.ViewHolder> {

    private List<Perro> perrosList;
    private Context context;

    public PerroAdapter(Context context) {
        this.perrosList = CtrlVeterinaria.getListaPerros(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_perro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Perro perro = perrosList.get(position);

        holder.tvNombrePerro.setText(perro.getNombre());
        //holder.tvFechaNacimientoPerro.setText((CharSequence) perro.getFecha_nacimiento());
        holder.tvEstaVacunadoPerro.setText(perro.isEstaVacunado() ? "Vacunado" : "No Vacunado");
        holder.tvEsMachoPerro.setText(perro.isEsMacho() ? "Macho" : "Hembra");
        holder.tvComentariosPerro.setText(perro.getComentarios());
    }

    @Override
    public int getItemCount() {
        return perrosList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombrePerro, tvFechaNacimientoPerro, tvEstaVacunadoPerro, tvEsMachoPerro, tvComentariosPerro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombrePerro = itemView.findViewById(R.id.tvNombrePerro);
            tvFechaNacimientoPerro = itemView.findViewById(R.id.tvFechaNacimientoPerro);
            tvEstaVacunadoPerro = itemView.findViewById(R.id.tvEstaVacunadoPerro);
            tvEsMachoPerro = itemView.findViewById(R.id.tvEsMachoPerro);
            tvComentariosPerro = itemView.findViewById(R.id.tvComentariosPerro);
        }
    }
}