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
 * {@link KobiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KobiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KobiFragment extends Fragment {
    Activity titleChange;
    public KobiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_kobi, container, false);
        getActivity().setTitle("KOBİ Kurum Kültürü Geliştirme Envanteri Yazılımı");


        return rootView;
    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange= activity;
    }
}
