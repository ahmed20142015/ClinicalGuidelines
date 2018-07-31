package com.marvelwall.ahmedpc.clinicalguidelines.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marvelwall.ahmedpc.clinicalguidelines.R;
import com.marvelwall.ahmedpc.clinicalguidelines.activities.MainActivity;

import java.util.List;


public class ReportCaseFragment extends Fragment {
    Button sendEmail;
    EditText doctorName, doctorHospital, doctorMobile, doctorEmail,
            patientName, patientId, patientMobile, patientNotes, patientDiagnosis;
    String  _doctorName, _doctorHospital, _doctorMobile, _doctorEmail,
            _patientName, _patientId, _patientMobile, _patientNotes, _patientDiagnosis;
    private OnFragmentInteractionListener mListener;

    public ReportCaseFragment() {
        // Required empty public constructor
    }


    public static ReportCaseFragment newInstance(String param1, String param2) {
        ReportCaseFragment fragment = new ReportCaseFragment();
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
        View view = inflater.inflate(R.layout.fragment_report_case, container, false);
        MainActivity.currentFragment = "ReportCaseFragment";

        doctorName = view.findViewById(R.id.doctor_name);
        doctorHospital = view.findViewById(R.id.doctor_hospital);
        doctorMobile = view.findViewById(R.id.doctor_mobile);
        doctorEmail = view.findViewById(R.id.doctor_email);
        patientName = view.findViewById(R.id.patient_name);
        patientId = view.findViewById(R.id.patient_id);
        patientMobile = view.findViewById(R.id.patient_mobile);
        patientNotes = view.findViewById(R.id.patient_notes);
        patientDiagnosis = view.findViewById(R.id.patient_diagnosis);
        sendEmail = view.findViewById(R.id.send_email);


        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                _doctorName = doctorName.getText().toString();
                _doctorHospital = doctorHospital.getText().toString();
                _doctorMobile = doctorMobile.getText().toString();
                _doctorEmail = doctorEmail.getText().toString();
                _patientName = patientName.getText().toString();
                _patientId = patientId.getText().toString();
                _patientMobile = patientMobile.getText().toString();
                _patientDiagnosis = patientDiagnosis.getText().toString();
                _patientNotes = patientNotes.getText().toString();

                if (_doctorName.isEmpty())
                    doctorName.setError("name can not be empty");

                else if (_doctorHospital.isEmpty())
                    doctorHospital.setError("hospital name can't be empty");

                else if (_doctorMobile.isEmpty())
                    doctorMobile.setError("mobile can can't be empty");

                else if (_doctorEmail.isEmpty())
                    doctorEmail.setError("email can can't be empty");

                else if (_patientName.isEmpty())
                    patientName.setError("name can can't be empty");

                else if (_patientId.isEmpty())
                    patientId.setError("id can't be empty");

                else if (_patientDiagnosis.isEmpty())
                    patientDiagnosis.setError("diagnosis can't be empty");

                else if (_patientNotes.isEmpty())
                    patientNotes.setError("notes can't be empty");
                else if (_patientMobile.isEmpty())
                    patientMobile.setError("mobile can can't be empty");

                else if ( _patientMobile.length()!=11 || _patientMobile.charAt(0)!='0'|| _patientMobile.charAt(1)!='1')
                    patientMobile.setError("mobile number not valid");

                else if ( _doctorMobile.length()!=11 || _doctorMobile.charAt(0)!='0'|| _doctorMobile.charAt(1)!='1')
                    doctorMobile.setError("mobile number not valid");

                else if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(_doctorEmail).matches())
                {
                    doctorEmail.setError("email not valid");

                }


                else {
                    Intent i = new Intent(Intent.ACTION_SEND);
//                    i.setType("message/rfc822");
//                    //i.setData(Uri.parse("mailto:"));
//                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"amg287640@gmail.com"});
//                    i.putExtra(Intent.EXTRA_SUBJECT, "Clinical Guidelines email");
//                    i.putExtra(Intent.EXTRA_TEXT   , "doctor information \nname:"+_doctorName+"\nhospital:"+_doctorHospital+"\nmobile:"+_doctorMobile
//                                                            +"\nemail:"+_doctorEmail+"\npatient information"+"\nname:"+_patientName+"\nid:"+_patientId
//                                                            +"\nmobile:"+_patientMobile+"\ndiagnosis:"+_patientDiagnosis+"\nnotes:"+_patientNotes+"\n");
//                    try {
//                        startActivity(Intent.createChooser(i, "Send mail..."));
//                    } catch (android.content.ActivityNotFoundException ex) {
//                        Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
//                    }

//                    Intent gmailIntent = new Intent();
//                    gmailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
//                    gmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"amg287640@gmail.com"});
//                    gmailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Clinical Guidelines email");
//                    gmailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "doctor information \nname:"+_doctorName+"\nhospital:"+_doctorHospital+"\nmobile:"+_doctorMobile
//                                                            +"\nemail:"+_doctorEmail+"\npatient information"+"\nname:"+_patientName+"\nid:"+_patientId
//                                                            +"\nmobile:"+_patientMobile+"\ndiagnosis:"+_patientDiagnosis+"\nnotes:"+_patientNotes+"\n");

                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("text/html");
                    final PackageManager pm = getActivity().getPackageManager();
                    final List<ResolveInfo> matches = pm.queryIntentActivities(emailIntent, 0);
                    String className = null;
                    for (final ResolveInfo info : matches) {
                        if (info.activityInfo.packageName.equals("com.google.android.gm")) {
                            className = info.activityInfo.name;

                            if(className != null && !className.isEmpty()){
                                break;
                            }
                        }
                    }
                    emailIntent.setClassName("com.google.android.gm", className);
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"amg287640@gmail.com"});
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Clinical Guidelines email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "doctor information \nname:"+_doctorName+"\nhospital:"+_doctorHospital+"\nmobile:"+_doctorMobile
                                                            +"\nemail:"+_doctorEmail+"\npatient information"+"\nname:"+_patientName+"\nid:"+_patientId
                                                            +"\nmobile:"+_patientMobile+"\ndiagnosis:"+_patientDiagnosis+"\nnotes:"+_patientNotes+"\n");

                    try {
                        startActivity(emailIntent);
                    } catch(ActivityNotFoundException ex) {
                        // handle error
                    }

                }
            }
        });



        return view;
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
