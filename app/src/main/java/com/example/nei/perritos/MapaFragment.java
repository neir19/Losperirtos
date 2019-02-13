package com.example.nei.perritos;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap mMap;

    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mapa,container,false);
        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync((OnMapReadyCallback) this);
        return view;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sabaneta = new LatLng(6.1531373, -75.6132984);
        mMap.addMarker(new MarkerOptions().
                position(sabaneta).
                title("Los Perritos").
                snippet("Sabaneta"));
        LatLng lleras= new LatLng(6.2100114,-75.5687587);
        mMap.addMarker(new MarkerOptions().
                position(lleras).
                title("Los Perritos").
                snippet("lleras"));
        LatLng belen= new LatLng(6.2205383,-75.5985349);
        mMap.addMarker(new MarkerOptions().
                position(belen).
                title("los perritos").
                snippet("belen"));
        LatLng udea= new LatLng(6.264009,-75.5713);
        mMap.addMarker(new MarkerOptions().
                position(udea).
                title("los perritos").
                snippet("udea"));
        LatLng laureles= new LatLng(6.224573,-75.591784);
        mMap.addMarker(new MarkerOptions().
                position(laureles).
                title("Los perritos").
                snippet("laureles"));
        LatLng loscolores= new LatLng(6.266656,-75.594737);
        mMap.addMarker(new MarkerOptions().
                position(loscolores).
                title("Los perritos").
                snippet("los colores"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sabaneta,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lleras));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(belen));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(udea));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(laureles));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(loscolores));

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}
