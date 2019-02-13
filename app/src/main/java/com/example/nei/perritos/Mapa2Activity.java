package com.example.nei.perritos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa2Activity extends AppCompatActivity implements OnMapReadyCallback {
    double n1,n2;
    MapView mapView2;
    GoogleMap mMap;
    TextView tTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa2);

        tTexto=findViewById(R.id.tTexto);
        mapView2 = (MapView)findViewById(R.id.mapView2);
        mapView2.onCreate(savedInstanceState);
        mapView2.getMapAsync((OnMapReadyCallback) this);




        //sabaneta
        //lleras
        //belen
        //udea
        //laureles
        //los colores


    } @Override
    protected void onResume() {
        mapView2.onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mapView2.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView2.onLowMemory();
        super.onLowMemory();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Bundle bundle = getIntent().getExtras();


        Toast.makeText(this,""+bundle.getString("nombre"),Toast.LENGTH_SHORT).show();
        if (bundle != null) {
            if (bundle.getString("nombre").equals("Sabaneta")) {
                n1 = 6.1531373;
                n2 = -75.6132984;
                tTexto.setText("Dirección: Cra 44 N°66 Sur 08 Barrio Aliadas.\n" +
                        "Número único: (+57) (4) 448 9464\n" +
                        "Email: info@losperritoscr.com");
                LatLng local = new LatLng(n1, n2);
                mMap.addMarker(new MarkerOptions().
                        position(local).
                        title("los perritos").
                        snippet(bundle.getString("nombre")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 12));


            } else if (bundle.getString("nombre").equals("Lleras")) {
                n1 = 6.2100114;
                n2 = -75.5687587;
                tTexto.setText("Dirección: Calle 10 N° 41-04\n" +
                        "Número único: (+57) (4) 448 9464\n" +
                        "Email: info@losperritoscr.com");
                LatLng local = new LatLng(6.2100114,-75.5687587);

                mMap.addMarker(new MarkerOptions().
                        position(local).
                        title("los perritos").
                        snippet(bundle.getString("nombre")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 12));



            } else if (bundle.getString("nombre").equals("Belén")) {
                n1 = 6.2205383;
                n2 = -75.5985349;
                tTexto.setText("Dirección: Carrera 76 Calle 12 esquina, diagonal al Colegio de la Inmaculada.\n" +
                        "Número único: (+57) (4) 448 9464\n" +
                        "Email: info@losperritoscr.com");
                LatLng local = new LatLng(n1, n2);
                mMap.addMarker(new MarkerOptions().
                        position(local).
                        title("los perritos").
                        snippet(bundle.getString("nombre")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 12));

            } else if (bundle.getString("nombre").equals("UdeA")) {
                n1 = 6.264009;
                n2 = -75.5713;
                tTexto.setText("Dirección: Carrera 58 No 65 – 10.\n" +
                        "Número único: (+57) (4) 448 9464\n" +
                        "Email: info@losperritoscr.com");
                LatLng local = new LatLng(n1, n2);
                mMap.addMarker(new MarkerOptions().
                        position(local).
                        title("los perritos").
                        snippet(bundle.getString("nombre")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 12));

            } else if (bundle.getString("nombre").equals("Laureles")) {
                n1 = 6.224573;
                n2 = -75.591784;
                tTexto.setText("Dirección: Cra 73 N°41-61 cerca a San Juan.\n" +
                        "Número único: (+57) (4) 448 9464\n" +
                        "Email: info@losperritoscr.com");
                LatLng local = new LatLng(n1, n2);
                mMap.addMarker(new MarkerOptions().
                        position(local).
                        title("los perritos").
                        snippet(bundle.getString("nombre")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 12));
            } else {
                n1 = 6.266656;
                n2 = -75.594737;
                tTexto.setText("Dirección: Calle 53 No 79 – 02.\n" +
                        "Número único: (+57) (4) 448 9464\n" +
                        "Email: info@losperritoscr.com");
                LatLng local = new LatLng(n1, n2);
                mMap.addMarker(new MarkerOptions().
                        position(local).
                        title("los perritos").
                        snippet(bundle.getString("nombre")));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local, 12));
            }





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
}
