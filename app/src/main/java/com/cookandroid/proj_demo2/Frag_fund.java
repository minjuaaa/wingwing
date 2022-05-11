package com.cookandroid.proj_demo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class Frag_fund extends Fragment {

    ImageView M1;
    ImageView M2;
    ImageView M3;
    ImageView M4;
    ImageView M5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_fund, container, false);


        M1 = v.findViewById(R.id.m01);
        M2 = v.findViewById(R.id.m02);
        M3 = v.findViewById(R.id.m03);
        M4 = v.findViewById(R.id.m04);
        M5 = v.findViewById(R.id.m05);


        Spinner spinner = (Spinner)v.findViewById(R.id.spin_fund);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( adapterView.getItemAtPosition(i).toString().equals("자립수당")){
                    M1.setVisibility(android.view.View.VISIBLE);
                    M2.setVisibility(android.view.View.INVISIBLE);
                    M3.setVisibility(android.view.View.INVISIBLE);
                    M4.setVisibility(android.view.View.INVISIBLE);
                    M5.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("자립정착금")){
                    M1.setVisibility(android.view.View.INVISIBLE);
                    M2.setVisibility(android.view.View.VISIBLE);
                    M3.setVisibility(android.view.View.INVISIBLE);
                    M4.setVisibility(android.view.View.INVISIBLE);
                    M5.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("디딤씨앗통장(CDA)")){
                    M1.setVisibility(android.view.View.INVISIBLE);
                    M2.setVisibility(android.view.View.INVISIBLE);
                    M3.setVisibility(android.view.View.VISIBLE);
                    M4.setVisibility(android.view.View.INVISIBLE);
                    M5.setVisibility(android.view.View.INVISIBLE);

                }

                if( adapterView.getItemAtPosition(i).toString().equals("국민기초생활보장제도")){
                    M1.setVisibility(android.view.View.INVISIBLE);
                    M2.setVisibility(android.view.View.INVISIBLE);
                    M3.setVisibility(android.view.View.INVISIBLE);
                    M4.setVisibility(android.view.View.VISIBLE);
                    M5.setVisibility(android.view.View.INVISIBLE);

                }

                if( adapterView.getItemAtPosition(i).toString().equals("긴급지원")){
                    M1.setVisibility(android.view.View.INVISIBLE);
                    M2.setVisibility(android.view.View.INVISIBLE);
                    M3.setVisibility(android.view.View.INVISIBLE);
                    M4.setVisibility(android.view.View.INVISIBLE);
                    M5.setVisibility(android.view.View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        return v;
    }



}