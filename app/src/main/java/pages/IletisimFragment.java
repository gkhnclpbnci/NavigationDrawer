package pages;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
public class IletisimFragment extends Fragment {


    private GoogleMap mMap;
    private TabLayout tabLayout;
    private MerkezOfisFragment merkezOfisFragment;
    private SubeOfisFragment subeOfisFragment;

    public IletisimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_iletisim, container, false);

        tabLayout = (TabLayout)v. findViewById(R.id.mainTabLayout);

        ViewPager viewPager = (ViewPager)v. findViewById(R.id.mainViewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());

        createFragments(viewPagerAdapter);

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        return v;
    }


    private void createFragments(ViewPagerAdapter viewPagerAdapter) {

        merkezOfisFragment = new MerkezOfisFragment();
        subeOfisFragment = new SubeOfisFragment();
        viewPagerAdapter.addFragment(merkezOfisFragment, "Merkez");
        viewPagerAdapter.addFragment(subeOfisFragment, "Şube");

    }
}
