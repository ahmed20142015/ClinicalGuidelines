package com.marvelwall.ahmedpc.clinicalguidelines.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.marvelwall.ahmedpc.clinicalguidelines.R;
import com.marvelwall.ahmedpc.clinicalguidelines.activities.MainActivity;

import java.util.ArrayList;


public class MangmentFragment extends Fragment {


    MaterialSpinner bacterialInfection,meningitis,streptococcus,adult;
    TextView examination ;

    private OnFragmentInteractionListener mListener;

    public MangmentFragment() {
        // Required empty public constructor
    }


    public static MangmentFragment newInstance(String param1, String param2) {
        MangmentFragment fragment = new MangmentFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mangment, container, false);
        MainActivity.currentFragment = "MangmentFragment";
        bacterialInfection = view.findViewById(R.id.spinner_bacterial);
        meningitis = view.findViewById(R.id.spinner_meningitis);
        streptococcus = view.findViewById(R.id.spinner_streptococcus);
        adult = view.findViewById(R.id.spinner_adult);
        examination = view.findViewById(R.id.examination);
        setFristSpinner();

        bacterialInfection.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                setSecSpinner();
            }
        });




        meningitis.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                setThrSpinner();
            }
        });

        streptococcus.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                setFourSpinner();
            }
        });

        adult.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                 examination.setText("Vancomycin plus Cefotaxime for 10-14 days. And can be extended" +
                         "to 3 weeks.");
            }
        });



        return view;
    }

    private void setFristSpinner(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("viral");
        strings.add("parasites");
        strings.add("others");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1,
                strings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bacterialInfection.setAdapter(adapter);

    }
    private void setSecSpinner(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("TB");
        strings.add("brucellosis");
        strings.add("leprosy");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1,
                strings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        meningitis.setAdapter(adapter);
    }
    private void setThrSpinner(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("meningococcal");
        strings.add("Nesseria");
        strings.add("Haemophilus");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1,
                strings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        streptococcus.setAdapter(adapter);
    }
    private void setFourSpinner(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("child");
        strings.add("neonates");
        strings.add("pregnant");
        strings.add("renal impairment");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1,
                strings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adult.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
