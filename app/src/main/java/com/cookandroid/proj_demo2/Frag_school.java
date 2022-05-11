package com.cookandroid.proj_demo2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class Frag_school extends Fragment {

    ImageView W1;
    ImageView W2;
    ImageView W3;
    ImageView W4;
    ImageView W5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_school, container, false);


        W1 = v.findViewById(R.id.w01);
        W2 = v.findViewById(R.id.w02);
        W3 = v.findViewById(R.id.w03);
        W4 = v.findViewById(R.id.w04);
        W5 = v.findViewById(R.id.w05);


        Spinner spinner = (Spinner)v.findViewById(R.id.spin_school);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if( adapterView.getItemAtPosition(i).toString().equals("국가장학금")){
                    W1.setVisibility(android.view.View.VISIBLE);
                    W2.setVisibility(android.view.View.INVISIBLE);
                    W3.setVisibility(android.view.View.INVISIBLE);
                    W4.setVisibility(android.view.View.INVISIBLE);
                    W5.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("학자금대출")){
                    W1.setVisibility(android.view.View.INVISIBLE);
                    W2.setVisibility(android.view.View.VISIBLE);
                    W3.setVisibility(android.view.View.INVISIBLE);
                    W4.setVisibility(android.view.View.INVISIBLE);
                    W5.setVisibility(android.view.View.INVISIBLE);
                }

                if( adapterView.getItemAtPosition(i).toString().equals("취업성공패키지")){
                    W1.setVisibility(android.view.View.INVISIBLE);
                    W2.setVisibility(android.view.View.INVISIBLE);
                    W3.setVisibility(android.view.View.VISIBLE);
                    W4.setVisibility(android.view.View.INVISIBLE);
                    W5.setVisibility(android.view.View.INVISIBLE);

                }

                if( adapterView.getItemAtPosition(i).toString().equals("내일배움카드")){
                    W1.setVisibility(android.view.View.INVISIBLE);
                    W2.setVisibility(android.view.View.INVISIBLE);
                    W3.setVisibility(android.view.View.INVISIBLE);
                    W4.setVisibility(android.view.View.VISIBLE);
                    W5.setVisibility(android.view.View.INVISIBLE);

                }

                if( adapterView.getItemAtPosition(i).toString().equals("청년희망키움통장")){
                    W1.setVisibility(android.view.View.INVISIBLE);
                    W2.setVisibility(android.view.View.INVISIBLE);
                    W3.setVisibility(android.view.View.INVISIBLE);
                    W4.setVisibility(android.view.View.INVISIBLE);
                    W5.setVisibility(android.view.View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        return v;
    }



}