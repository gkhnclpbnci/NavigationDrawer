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
 * {@link DepoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DepoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepoFragment extends Fragment {
    Activity titleChange;
    public  DepoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_depo, container, false);
        getActivity().setTitle("Depo Yönetim Sistemi Yazılımı");

        return rootView;
    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange= activity;
    }
}
