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
 * {@link YonetimFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link YonetimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YonetimFragment extends Fragment {
    Activity titleChange;
    public YonetimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_yonetim, container, false);
        getActivity().setTitle("Üretim Yönetimi Danışmanlığı");


        return rootView;
    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=activity;
    }
}
