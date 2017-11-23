package pages;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import example.batuhan.www.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IletisimFragment extends Fragment implements OnMapReadyCallback {


    private GoogleMap mMap;

    public IletisimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_iletisim, container, false);



        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(38.366125, 27.207569);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("İdeaktif"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15));
        googleMap.getUiSettings().setZoomControlsEnabled(true);

    }
}
