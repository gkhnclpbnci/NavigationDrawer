package pages;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.batuhan.www.navigationdrawer.MainActivity;
import example.batuhan.www.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HakkimizdaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HakkimizdaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HakkimizdaFragment extends Fragment {
    Activity titleChange;
    public HakkimizdaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_hakkimizda, container, false);

        return rootView;
    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }
}
