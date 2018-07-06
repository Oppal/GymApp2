package com.example.android.gymapp2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

        int height = 100;
        int width = 100;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(R.drawable.gymlocation);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        // Add a marker in Sydney and move the camera
        LatLng prestige = new LatLng(-1.3003821, 36.78705860000002);
        mMap.addMarker(new MarkerOptions().position(prestige).title("Fit gym at prestige plaza")).setIcon(BitmapDescriptorFactory.fromBitmap(smallMarker));

        LatLng tmall = new LatLng(-1.3124449,  36.81666180000002);
        mMap.addMarker(new MarkerOptions().position(tmall).title("Fit gym at tmall"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tmall));

        LatLng kibera = new LatLng(-1.3114845,  36.78794749999997);
        mMap.addMarker(new MarkerOptions().position(kibera).title("Fit gym at Kibera"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kibera));
    }
}
