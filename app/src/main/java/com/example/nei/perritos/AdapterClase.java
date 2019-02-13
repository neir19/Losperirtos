package com.example.nei.perritos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClase extends RecyclerView.Adapter<AdapterClase.ViewHolderClases> implements View.OnClickListener {
    ArrayList<String> listdatos;
    private  View.OnClickListener listener;

    public AdapterClase(ArrayList<String> listdatos) {
        this.listdatos = listdatos;
    }

    @NonNull
    @Override
    public ViewHolderClases onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);

         itemView.setOnClickListener(this);
        return new ViewHolderClases(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClases holder, int position) {
    holder.asignardatos(listdatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listdatos.size();
    }
    public  void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
    if(listener!= null){
        listener.onClick(v);
    }
    }

    public class ViewHolderClases extends RecyclerView.ViewHolder {
        TextView tNombre;
        public ViewHolderClases(View itemView) {
            super(itemView);
            tNombre= itemView.findViewById(R.id.tNombre);

        }

        public void asignardatos(String s) {
         tNombre.setText(s);
        }
    }
}
