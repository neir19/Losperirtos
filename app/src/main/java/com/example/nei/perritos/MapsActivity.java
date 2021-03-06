package com.example.nei.perritos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    MapView mapView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
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

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
}
