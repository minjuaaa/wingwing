package com.cookandroid.proj_demo2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class setting extends AppCompatActivity {

    Toolbar toolbar;

    Frag_home fragment1;
    Frag_fund fragment2;
    Frag_school fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);


        fragment1 = new Frag_home();
        fragment2 = new Frag_fund();
        fragment3 = new Frag_school();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("주거정보"));
        tabs.addTab(tabs.newTab().setText("지원금안내"));
        tabs.addTab(tabs.newTab().setText("학업/취업"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("setting", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                } else if (position == 2) {
                    selected = fragment3;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }}

