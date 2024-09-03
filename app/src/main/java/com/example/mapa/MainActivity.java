package com.example.mapa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gmaps.adaptador.MyInfoAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMap();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        setupMapFeatures();
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
    }
    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private void setupMapFeatures() {
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng UTEQLocation = new LatLng(-1.0109242630680952, -79.46842649490726);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UTEQLocation, 16));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        addMapMarker(new LatLng(-1.01350399309634, -79.46815845233768), "CAFE KIMO", "Cafeteria", R.mipmap.ic_cafe);
        addMapMarker(new LatLng(-1.0108414790287659, -79.47047791799375), "KONITOS PIZZA", "Pizza", R.mipmap.ic_pizza);
        addMapMarker(new LatLng(-1.0116926846991625, -79.4668864858666), "BUNKER FRUIT", "Restaurante", R.mipmap.ic_heladito);
        addMapMarker(new LatLng(-1.0116926846991625, -79.46668349447533),"Encebollado Pique y Pase","Restaurante", R.mipmap.ic_restaurant);
        addMapMarker(new LatLng(-1.0134964709572454, -79.46930492745352),"Lokos D' Asar","Restaurante", R.mipmap.ic_restaurant);
        addMapMarker(new LatLng(-1.0141128250964173, -79.46832758691284),"Sweet Land - Quevedo","Heladeria", R.mipmap.ic_heladito);
        addMapMarker(new LatLng(-1.0141242636177403, -79.46831397754428),"Las Delicias Del Olimpo","Restaurante", R.mipmap.ic_cafe);
        addMapMarker(new LatLng(-1.0098749690620858, -79.46939479855095),"Pizza Hut Quevedo","Restaurante", R.mipmap.ic_pizza);
        mMap.setInfoWindowAdapter(new MyInfoAdapter(this));
    }
    private void addMapMarker(LatLng pos, String titleText, String detailText, int resourceIcon) {
        MarkerOptions marker = new MarkerOptions()
                .position(pos)
                .title(titleText)
                .snippet(detailText)
                .icon(BitmapDescriptorFactory.fromResource(resourceIcon));
        mMap.addMarker(marker);
    }
}