package com.cookandroid.proj_demo2;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private View drawerView;

    TextView news, home, test, center, more, scdtext;
    ViewFlipper mFlipper;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCalendarView materialCalendarView = findViewById(R.id.calendarView);
        OneDayDecorator oneDayDecorator = new OneDayDecorator();
        materialCalendarView.addDecorators(oneDayDecorator);
        materialCalendarView.setSelectedDate(CalendarDay.today());
        materialCalendarView.addDecorator(new EventDecorator(Color.RED, Collections.singleton(CalendarDay.today())));





        int images[] = {
                R.drawable.slide1,
                R.drawable.slide01,
                R.drawable.slide2,
                R.drawable.slide3
        };

        mFlipper = findViewById(R.id.mSlide);

        for(int image : images){
            fllipperImages(image);
        }


        scdtextview();


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawerView);
        drawerLayout.setDrawerListener(listener);


        home = findViewById(R.id.nav_home);

        test = findViewById(R.id.nav_test);
        center = findViewById(R.id.nav_center);
        news = findViewById(R.id.nav_new);
        more = findViewById(R.id.txt_more);


        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, news.class );
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, setting.class );
                startActivity(intent);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, tMain.class );
                startActivity(intent);
            }
        });

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, center.class );
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, news.class );
                startActivity(intent);
            }
        });


    }





    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }

        @Override
        public void onDrawerStateChanged(int newState) {
        }

    };




    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        mFlipper.addView(imageView);      // ????????? ??????
        mFlipper.setFlipInterval(4000);       // ?????? ????????? ???????????? ???????????????(1000 ??? 1???)
        mFlipper.setAutoStart(true);          // ?????? ?????? ?????? ??????

        // animation
        mFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        mFlipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void scdtextview(){
        scdtext = (TextView)findViewById(R.id.scdText);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");


        Date date = new Date();
        String time1 = simpleDateFormat.format(date);


        switch (time1){
            case "202201":
                scdtext.setText("1??? ????????????\n\n1???07???   ??????????????? ?????? ?????????\n1???12???   ??????????????? ???????????? ????????? ??????\n1???20???   LH????????? ???????????? ??????\n1???27???   ?????????????????? ???????????? ????????? ?????????");
                break;
            case "202202":
                scdtext.setText("2??? ????????????\n\n2???01???   ???????????? ??????????????? ????????? ??????\n2???10???   ?????? ????????? ?????????\n2???16???   ????????? ?????????????????? ?????? ??????\n2???21???   ???????????? ????????? ???????????? ??????\n2???25???   ???????????? ?????????????????? ??????????????? ?????????");
                break;
            case "202203":
                scdtext.setText("3??? ????????????\n\n3???13???   ?????????????????? ?????????\n3???18???   ??????????????? 1??? ??????\n3???20???   ???????????? ?????? ??????\n3???20???   ???????????? 3??? ?????????\n3???22???   ?????????????????? ???????????????\n3???29???   ???????????? ???????????? ????????? ??????");
                break;
            case "202204":
                scdtext.setText("4??? ????????????\n\n4???07???   ??????????????? ?????? ?????????\n4???12???   ??????????????? ???????????? ????????? ??????\n4???20???   LH????????? ???????????? ??????\n4???27???   ?????????????????? ???????????? ????????? ?????????");
                break;
            case "202205":
                scdtext.setText("5??? ????????????\n\n5???01???   ???????????? ??????????????? ????????? ??????\n5???10???   ?????? ????????? ?????????\n5???16???   ????????? ?????????????????? ?????? ??????\n5???21???   ???????????? ????????? ???????????? ??????\n5???25???   ???????????? ?????????????????? ??????????????? ?????????");
                break;
            case "202206":
                scdtext.setText("6??? ????????????\n\n6???13???   ?????????????????? ?????????\n6???18???   ??????????????? 1??? ??????\n6???20???   ???????????? ?????? ??????\n6???20???   ???????????? 3??? ?????????\n6???22???   ?????????????????? ???????????????\n6???29???   ???????????? ???????????? ????????? ??????");
                break;
            case "202207":
                scdtext.setText("7??? ????????????\n\n7???07???   ??????????????? ?????? ?????????\n7???12???   ??????????????? ???????????? ????????? ??????\n7???20???   LH????????? ???????????? ??????\n7???27???   ?????????????????? ???????????? ????????? ?????????");
                break;
            case "202208":
                scdtext.setText("8??? ????????????\n\n8???01???   ???????????? ??????????????? ????????? ??????\n8???10???   ?????? ????????? ?????????\n8???16???   ????????? ?????????????????? ?????? ??????\n8???21???   ???????????? ????????? ???????????? ??????\n8???25???   ???????????? ?????????????????? ??????????????? ?????????");
                break;
            case "202209":
                scdtext.setText("9??? ????????????\n\n9???13???   ?????????????????? ?????????\n9???18???   ??????????????? 1??? ??????\n9???20???   ???????????? ?????? ??????\n9???20???   ???????????? 3??? ?????????\n9???22???   ?????????????????? ???????????????\n9???29???   ???????????? ???????????? ????????? ??????");
                break;
            case "202210":
                scdtext.setText("10??? ????????????\n\n1???07???   ??????????????? ?????? ?????????\n10???12???   ??????????????? ???????????? ????????? ??????\n10???20???   LH????????? ???????????? ??????\n10???27???   ?????????????????? ???????????? ????????? ?????????");
                break;
            case "202211":
                scdtext.setText("11??? ????????????\n\n11???01???   ???????????? ??????????????? ????????? ??????\n11???10???   ?????? ????????? ?????????\n11???16???   ????????? ?????????????????? ?????? ??????\n11???21???   ???????????? ????????? ???????????? ??????\n11???25???   ???????????? ?????????????????? ??????????????? ?????????");
                break;
            case "202212":
                scdtext.setText("12??? ????????????\n\n12???13???   ?????????????????? ?????????\n12???18???   ??????????????? 1??? ??????\n12???20???   ???????????? ?????? ??????\n12???20???   ???????????? 3??? ?????????\n12???22???   ?????????????????? ???????????????\n12???29???   ???????????? ???????????? ????????? ??????");
                break;






        }




    }





}

