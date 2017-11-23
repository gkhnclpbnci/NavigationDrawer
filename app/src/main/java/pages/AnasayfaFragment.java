package pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import example.batuhan.www.navigationdrawer.MainActivity;
import example.batuhan.www.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnasayfaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnasayfaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnasayfaFragment extends Fragment {
    ListView list;
    ListViewAdapter adapter;
    private String[] haber_baslik;
    private String[] haber_detay;

    private TypedArray haber_icon;
    private int[] haber_icon_int;
    Activity titleChange;
    public AnasayfaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_anasayfa, container, false);
        haber_baslik  =getResources().getStringArray(R.array.haber_baslik);
        haber_detay  =getResources().getStringArray(R.array.haber_detay_array);
        haber_icon  = getResources().obtainTypedArray(R.array.icon_array);
        haber_icon_int = new int[haber_icon.length()];
        for(int i = 0;i<haber_icon.length();i++){
            haber_icon_int[i] = haber_icon.getResourceId(i, -1);
        }
        haber_icon.recycle();


        list = (ListView) rootView.findViewById(R.id.haberlist);

        adapter = new ListViewAdapter(getContext(), haber_baslik, haber_detay, haber_icon_int);

        list.setAdapter(adapter);

       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

               /* Intent intent=new Intent(getContext(),YonetimFragment.class);
                startActivity(intent);
               /* Intent i = new Intent(getActivity(), HaberDetay.class);

                i.putExtra("haber_detay", haber_detay[position]);
                i.putExtra("image_detay",haber_icon_int[position]);

                getActivity().startActivity(i);*/
            }

        });

        return  rootView;


    }

    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void  onAttach(Activity activity){
        super.onAttach(activity);
        titleChange=(MainActivity) activity;
    }
}
