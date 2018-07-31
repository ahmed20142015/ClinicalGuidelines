package com.marvelwall.ahmedpc.clinicalguidelines.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.marvelwall.ahmedpc.clinicalguidelines.R;
import com.marvelwall.ahmedpc.clinicalguidelines.activities.MainActivity;
import com.marvelwall.ahmedpc.clinicalguidelines.adapter.CategoryAdapter;
import com.marvelwall.ahmedpc.clinicalguidelines.model.Category;
import com.marvelwall.ahmedpc.clinicalguidelines.model.Index;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener {
    private FragmentManager manager;
    private FragmentTransaction transaction;

    SearchView search;
  //  LinearLayout feverLayout;
   // EditText searchFever;
    ExpandableListView categoriesList;
    private OnFragmentInteractionListener mListener;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        MainActivity.currentFragment = "HomeFragment";
        //feverLayout = view.findViewById(R.id.fever);
      //  searchFever = view.findViewById(R.id.search_fever);
        categoriesList = view.findViewById(R.id.list_categories);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        search = (SearchView)view.findViewById(R.id.search);
        search.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setOnCloseListener(this);

//        feverLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Fragment fragment = new FeverFragment();
//                manager = getActivity().getSupportFragmentManager();
//                if(manager == null)
//                    manager  =  getActivity().getSupportFragmentManager();
//                transaction = manager.beginTransaction();
//
//                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
//                transaction.replace(R.id.mainContent, fragment, "home").addToBackStack("home").commit();
//
//            }
//        });

        fillCategoriesList();

        search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                search.setFocusableInTouchMode(true);

                return false;
            }
        });

        // Listview on child click listener
        categoriesList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                //lood frament
                MainActivity.currentFragment = "viewPDF";

                Fragment fragment = ViewPdfFragment.newInstance("book.pdf",
                                    Integer.parseInt(categories.get(groupPosition).getIndexs().get(childPosition).getPageNumb()));
                manager = getActivity().getSupportFragmentManager();
                if (manager == null)
                    manager = getActivity().getSupportFragmentManager();
                transaction = manager.beginTransaction();

                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                // transaction.replace(R.id.mainContent, fragment, "login").commit();
                transaction.replace(R.id.mainContent, fragment, "ViewPdf").addToBackStack("ViewPdf").commit();

                return false;
            }
        });

        return view;
    }

    private void fillCategoriesList() {


        //faver category

        ArrayList<Index> feverIndex = new ArrayList<>();

        feverIndex.add(new Index("Fever introduction","1"));
        feverIndex.add(new Index("Heat Illness","4"));

        categories.clear();
        categories.add(new Category("Fever",R.drawable.fever_icon,feverIndex));

        //Common Bacterial Diseases
        ArrayList<Index> bacterialIndex = new ArrayList<>();

        bacterialIndex.add(new Index("Typhoid Fever","15"));
        bacterialIndex.add(new Index("Brucellosis","19"));
        bacterialIndex.add(new Index("Bacterial Meningitis","22"));
        bacterialIndex.add(new Index("T.B. Meningitis","26"));
        bacterialIndex.add(new Index("The Extra-pulmouary Tuberculosis","28"));
        bacterialIndex.add(new Index("Lebrosy","29"));
        bacterialIndex.add(new Index("Tetanus","30"));
        bacterialIndex.add(new Index("Diphtheria","33"));
        bacterialIndex.add(new Index("Food Born Diseases","34"));
        bacterialIndex.add(new Index("Botulism","41"));
        bacterialIndex.add(new Index("Cholera","43"));
        bacterialIndex.add(new Index("Plague","46"));
        bacterialIndex.add(new Index("Erysipelas","48"));
        bacterialIndex.add(new Index("Scarlet Fever","49"));
        bacterialIndex.add(new Index("Gas Gangrene","50"));

        categories.add(new Category("Common Bacterial Diseases",R.drawable.bacterial_icon,bacterialIndex));

        //Common Viral Disease
        ArrayList<Index> viralIndex = new ArrayList<>();
        viralIndex.add(new Index("CMV","53"));
        viralIndex.add(new Index("Ebstein Barr Virus","54"));
        viralIndex.add(new Index("Measles","56"));
        viralIndex.add(new Index("Rubella (German measles)","58"));
        viralIndex.add(new Index("Mumps","60"));
        viralIndex.add(new Index("Chicken pox","61"));
        viralIndex.add(new Index("Rabies","63"));
        viralIndex.add(new Index("Viral Haemorrhagic Fevers","66"));
        viralIndex.add(new Index("Dengue Fever","68"));
        viralIndex.add(new Index("Rift Valley Fever","71"));
        viralIndex.add(new Index("Yellow Fever","73"));
        viralIndex.add(new Index("Avian Influenza (H5N1)","76"));
        viralIndex.add(new Index("Influenza Virus (seasonal influnza)","78"));
        viralIndex.add(new Index("Community Acquired Pneumonia (CAP)","80"));
        viralIndex.add(new Index("Viral Pneumonia","82"));
        viralIndex.add(new Index("Acute Viral Encephalitis","84"));
        viralIndex.add(new Index("Poliomyelitis","86"));
        viralIndex.add(new Index("Middle East Respiratory Syndrome","88"));
        viralIndex.add(new Index("HIV","90"));
        viralIndex.add(new Index("Ebola","99"));
        viralIndex.add(new Index("Leptospirosis","109"));
        viralIndex.add(new Index("Acute Viral Hepatitis ( Hepatitis A)","111"));
        viralIndex.add(new Index("Chronic HBVs","113"));
        viralIndex.add(new Index("Hepatitis C Treatment Protocol","117"));
        viralIndex.add(new Index("Cirrhotic Ascites","124"));
        viralIndex.add(new Index("Hepatitic Encephalopathy","126"));
        viralIndex.add(new Index("Hepatorenal Syndrome","128"));
        viralIndex.add(new Index("Portal Hypertension","131"));

        categories.add(new Category("Common Viral Disease",R.drawable.viral_icon,viralIndex));

        //Common parasitic disease

        ArrayList<Index> parasiticIndex = new ArrayList<>();
        parasiticIndex.add(new Index("Toxoplasmosis","135"));
        parasiticIndex.add(new Index("Malaria","140"));
        parasiticIndex.add(new Index("Leishmania","143"));
        parasiticIndex.add(new Index("Fascioliasis","145"));
        parasiticIndex.add(new Index("Filariasis","147"));

        categories.add(new Category("Common Parasitic Disease",R.drawable.parasitic_icon,parasiticIndex));

        //Miscellaneous
        ArrayList<Index> miscellaneousIndex = new ArrayList<>();
        miscellaneousIndex.add(new Index("Fungal Pneumonia","150"));
        miscellaneousIndex.add(new Index("Anthrax","151"));
        miscellaneousIndex.add(new Index("Familial Mediterranean Fever","153"));
        miscellaneousIndex.add(new Index("Fever of Unknown Origin (FUO)","155"));
        miscellaneousIndex.add(new Index("Fever With Rash","158"));

        categories.add(new Category("Miscellaneous",R.drawable.miscellaneous,miscellaneousIndex));

        // set adapter
        categoryAdapter = new CategoryAdapter(getActivity(),categories);
        categoriesList.setAdapter(categoryAdapter);
        //expandAll();
    }
    private void expandAll() {
        int count = categoryAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            categoriesList.expandGroup(i);
        }
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

    @Override
    public boolean onClose() {
        categoryAdapter.filterData("");
        expandAll();
        return false;     }

    @Override
    public boolean onQueryTextSubmit(String s) {
        categoryAdapter.filterData(s);
        expandAll();
        return false;
          }

    @Override
    public boolean onQueryTextChange(String s) {
        categoryAdapter.filterData(s);
        expandAll();
        return false;    }

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
