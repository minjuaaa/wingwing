package com.cookandroid.proj_demo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class Frag_home extends Fragment {

    ImageView Home1;
    ImageView Home2;
    ImageView Home3;
    ImageView Home4;
    ImageView Home5;
    ImageView Home6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_home, container, false);


        Home1 = v.findViewById(R.id.home01);
        Home2 = v.findViewById(R.id.home02);
        Home3 = v.findViewById(R.id.home03);
        Home4 = v.findViewById(R.id.home04);
        Home5 = v.findViewById(R.id.home05);
        Home6 = v.findViewById(R.id.home06);

        Spinner spinner = (Spinner)v.findViewById(R.id.spin_home);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( adapterView.getItemAtPosition(i).toString().equals("청년전세임대주택")){
                    Home1.setVisibility(android.view.View.INVISIBLE);
                    Home2.setVisibility(android.view.View.INVISIBLE);
                    Home3.setVisibility(android.view.View.VISIBLE);
                    Home4.setVisibility(android.view.View.INVISIBLE);
                    Home5.setVisibility(android.view.View.INVISIBLE);
                    Home6.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("자립지원시설(자립생활관)")){
                    Home1.setVisibility(android.view.View.INVISIBLE);
                    Home2.setVisibility(android.view.View.VISIBLE);
                    Home3.setVisibility(android.view.View.INVISIBLE);
                    Home4.setVisibility(android.view.View.INVISIBLE);
                    Home5.setVisibility(android.view.View.INVISIBLE);
                    Home6.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("주거지원통합서비스")){
                    Home1.setVisibility(android.view.View.VISIBLE);
                    Home2.setVisibility(android.view.View.INVISIBLE);
                    Home3.setVisibility(android.view.View.INVISIBLE);
                    Home4.setVisibility(android.view.View.INVISIBLE);
                    Home5.setVisibility(android.view.View.INVISIBLE);
                    Home6.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("청년매입임대주택")){
                    Home1.setVisibility(android.view.View.INVISIBLE);
                    Home2.setVisibility(android.view.View.INVISIBLE);
                    Home3.setVisibility(android.view.View.INVISIBLE);
                    Home4.setVisibility(android.view.View.VISIBLE);
                    Home5.setVisibility(android.view.View.INVISIBLE);
                    Home6.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("영구임대주택")){
                    Home1.setVisibility(android.view.View.INVISIBLE);
                    Home2.setVisibility(android.view.View.INVISIBLE);
                    Home3.setVisibility(android.view.View.INVISIBLE);
                    Home4.setVisibility(android.view.View.INVISIBLE);
                    Home5.setVisibility(android.view.View.VISIBLE);
                    Home6.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("공동생활가정(그룹홈)")){
                    Home1.setVisibility(android.view.View.INVISIBLE);
                    Home2.setVisibility(android.view.View.INVISIBLE);
                    Home3.setVisibility(android.view.View.INVISIBLE);
                    Home4.setVisibility(android.view.View.INVISIBLE);
                    Home5.setVisibility(android.view.View.INVISIBLE);
                    Home6.setVisibility(android.view.View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        return v;
    }



}