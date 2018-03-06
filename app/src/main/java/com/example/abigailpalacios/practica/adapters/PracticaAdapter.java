package com.example.abigailpalacios.practica.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abigailpalacios.practica.R;
import java.util.List;

import com.example.abigailpalacios.practica.models.Practica;
/**
 * Created by Abigail Palacios on 20/02/2018.
 */

public class PracticaAdapter extends RecyclerView.Adapter<PracticaAdapter.ViewHolder> {
    private List<Practica> practicas;

    public PracticaAdapter(List<Practica> practicas) {
        this.practicas = practicas;
    }

    @Override
    public PracticaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_practica, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PracticaAdapter.ViewHolder holder, int position) {
        Practica practica = practicas.get(position);

        holder.text.setText(practica.getText());
        holder.price.setText(practica.getPrice());
        holder.type.setText(practica.getPrice());
    }

    @Override
    public int getItemCount() {
        return practicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView price;
        TextView type;

        public ViewHolder(View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            price = itemView.findViewById(R.id.price);
            type = itemView.findViewById(R.id.type);
        }
    }
}
