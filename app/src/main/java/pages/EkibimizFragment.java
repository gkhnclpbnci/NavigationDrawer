package pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ideaktif.mobile.www.gokhan.EkibimizBaseActivity;
import ideaktif.mobile.www.gokhan.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnasayfaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnasayfaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EkibimizFragment extends Fragment {

    Activity titleChange;

    public EkibimizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ekibimiz, container, false);
        getActivity().setTitle("Ekibimiz");

/*
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
        LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.baslik_4_linear_layout);
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity(4);
            }
        });
        LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.baslik_5_linear_layout);
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity(5);
            }
        });
        LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.baslik_6_linear_layout);
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetailActivity(6);
            }
        });
*/

        return rootView;


    }

    private void goToDetailActivity(int i) {
        switch (i) {
            case 1:

                Intent intent = new Intent(getActivity(), EkibimizBaseActivity.class);
                intent.putExtra("baslikIndex",10);
                getActivity().startActivity(intent);
                break;

            case 2:
                Intent intent2 = new Intent(getActivity(), EkibimizBaseActivity.class);
                intent2.putExtra("baslikIndex",11);

                getActivity().startActivity(intent2);

                break;
            case 3:
                Intent intent3 = new Intent(getActivity(), EkibimizBaseActivity.class);
                intent3.putExtra("baslikIndex",12);

                getActivity().startActivity(intent3);

                break;
            case 4:
                Intent intent4 = new Intent(getActivity(), EkibimizBaseActivity.class);
                intent4.putExtra("baslikIndex",13);

                getActivity().startActivity(intent4);

                break;
            case 5:
                Intent intent5 = new Intent(getActivity(), EkibimizBaseActivity.class);
                intent5.putExtra("baslikIndex",14);

                getActivity().startActivity(intent5);

                break;
            case 6:
                Intent intent6 = new Intent(getActivity(), EkibimizBaseActivity.class);
                intent6.putExtra("baslikIndex",15);

                getActivity().startActivity(intent6);

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
