package com.example.gmaps.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gmaps.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyInfoAdapter implements GoogleMap.InfoWindowAdapter  {

    private final View mWindow;

    public MyInfoAdapter(Context context) {
        mWindow = LayoutInflater.from(context).inflate(R.layout.maps, null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        TextView lugar = mWindow.findViewById(R.id.Nombrelugar);
        TextView direccion = mWindow.findViewById(R.id.Nombredireccion);
        lugar.setText(marker.getTitle());
        direccion.setText(marker.getSnippet());
        return mWindow;
    }


    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }
}
