package pages;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.batuhan.www.navigationdrawer.Baslik1Activity;
import example.batuhan.www.navigationdrawer.BaslikBaseActivity;
import example.batuhan.www.navigationdrawer.MainActivity;
import example.batuhan.www.navigationdrawer.R;



public class Baslik1Fragment extends Fragment {
    Activity titleChange;
    public Baslik1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.content_baslik1, container, false);

        getActivity().setTitle("Üretim Yönetimi Danışmanlığı");

        return rootView;
    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange= activity;
    }


}
