package pages;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ideaktif.mobile.www.gokhan.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link B2BFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link B2BFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class B2BFragment extends Fragment {
    Activity titleChange;
    public B2BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_b2_b, container, false);
        getActivity().setTitle("İdeaktif B2B Müşteri Web Portalı Yazılımı");

        return rootView;
    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange= activity;
    }
}
