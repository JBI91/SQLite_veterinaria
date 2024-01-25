package com.example.sqlite_veterinaria.View;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_veterinaria.Controller.CtrlVeterinaria;
import com.example.sqlite_veterinaria.Model.Propietario;
import com.example.sqlite_veterinaria.R;

import java.util.List;

public class PropietarioAdapter extends RecyclerView.Adapter<PropietarioAdapter.ViewHolder> {
    private List<Propietario> propietarioList;
    private Context context;

    public PropietarioAdapter(Context context) {
        this.propietarioList = CtrlVeterinaria.getListaPropietario(context);
    }

    @NonNull
    @Override
    public PropietarioAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_propietario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Propietario propietario = propietarioList.get(position);

            holder.tvNombre.setText(propietarioList.get(position).getNombre());
            holder.tvApellido.setText(propietarioList.get(position).getApellidos());
            holder.tvEmail.setText(propietarioList.get(position).getEmail());
            holder.tvTelefono.setText(propietarioList.get(position).getTelefono());
            holder.cv.setOnClickListener(v -> {
                Intent intent = new Intent(context, PerrosListActivity.class);
                intent.putExtra("id_propietario", propietario.getId());
                context.startActivity(intent);
            });
    }

    @Override
    public int getItemCount() {
        return propietarioList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tvNombre, tvApellido, tvEmail, tvTelefono;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvApellido = itemView.findViewById(R.id.tvApellidos);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
        }
    }
}
