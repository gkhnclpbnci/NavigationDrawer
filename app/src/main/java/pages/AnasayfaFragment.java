package pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ideaktif.mobile.www.gokhan.BaslikBaseActivity;
import ideaktif.mobile.www.gokhan.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnasayfaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnasayfaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnasayfaFragment extends Fragment {

    Activity titleChange;

    public AnasayfaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_anasayfa, container, false);
        getActivity().setTitle("Anasayfa");


        LinearLayout linearLayout1 = (LinearLayout) rootView.findViewById(R.id.baslik_1_linear_layout);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity(1);
            }
        });
        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.baslik_2_linear_layout);

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity(2);
            }
        });
        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.baslik_3_linear_layout);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity(3);
            }
        });


        return rootView;


    }

    private void goToDetailActivity(int i) {
        switch (i) {
            case 1:

                Intent intent = new Intent(getActivity(), BaslikBaseActivity.class);
                intent.putExtra("baslikIndex",7);
                getActivity().startActivity(intent);
                break;

            case 2:
                Intent intent2 = new Intent(getActivity(), BaslikBaseActivity.class);
                intent2.putExtra("baslikIndex",8);

                getActivity().startActivity(intent2);

                break;
            case 3:
                Intent intent3 = new Intent(getActivity(), BaslikBaseActivity.class);
                intent3.putExtra("baslikIndex",9);

                getActivity().startActivity(intent3);

                break;


            default:
                break;
        }
    }


    //Activity metodunu fragment içinde kullanmak için attach işlemi yapıyoruz
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        titleChange = activity;
    }
}
