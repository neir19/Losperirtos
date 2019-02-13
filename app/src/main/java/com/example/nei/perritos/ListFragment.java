package com.example.nei.perritos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private  ArrayList<String> listdatos;
    private  RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;
    private  android.support.design.widget.FloatingActionButton bMapa;
    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView= view.findViewById(R.id.Rlocales);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        final ArrayList<String> listdatos= new ArrayList<>();
        listdatos.add("Sabaneta");
        listdatos.add("Lleras");
        listdatos.add("Belén");
        listdatos.add("UdeA");
        listdatos.add("Laureles");
        listdatos.add("Los colores");
        bMapa= view.findViewById(R.id.bMapa);
        bMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=  new Intent( getActivity().getApplication(),MapsActivity.class );
                startActivity(intent2);
            }
        });

        AdapterClase adapter= new AdapterClase(listdatos);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent( getActivity().getApplication(),Mapa2Activity.class );

                intent.putExtra("nombre", listdatos.get(recyclerView.getChildAdapterPosition(v)).toString());
                startActivity(intent);

            }
        });

        return view;

    }

}
