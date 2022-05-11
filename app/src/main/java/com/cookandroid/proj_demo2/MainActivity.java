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

        mFlipper.addView(imageView);      // 이미지 추가
        mFlipper.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        mFlipper.setAutoStart(true);          // 자동 시작 유무 설정

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
                scdtext.setText("1월 주요소식\n\n1월07일   근로장려금 반기 지급일\n1월12일   굿네이버스 자립아동 장학금 신청\n1월20일   LH청년홈 선정결과 발표\n1월27일   해바라기센터 자립아동 보고서 제출일");
                break;
            case "202202":
                scdtext.setText("2월 주요소식\n\n2월01일   초록우산 어린이재단 지원금 신청\n2월10일   문화 지원비 지급일\n2월16일   서울시 아동복지센터 나눔 행사\n2월21일   취약계층 교육비 지원사업 신청\n2월25일   윙윙그룹 사회복지재단 생활지원금 지급일");
                break;
            case "202203":
                scdtext.setText("3월 주요소식\n\n3월13일   청년희망적금 신청일\n3월18일   국가장학금 1차 신청\n3월20일   청년주택 결과 발표\n3월20일   자립수당 3차 지급일\n3월22일   보호종료아동 멘토링데이\n3월29일   국민은행 자립아동 장학금 신청");
                break;
            case "202204":
                scdtext.setText("4월 주요소식\n\n4월07일   근로장려금 반기 지급일\n4월12일   굿네이버스 자립아동 장학금 신청\n4월20일   LH청년홈 선정결과 발표\n4월27일   해바라기센터 자립아동 보고서 제출일");
                break;
            case "202205":
                scdtext.setText("5월 주요소식\n\n5월01일   초록우산 어린이재단 지원금 신청\n5월10일   문화 지원비 지급일\n5월16일   서울시 아동복지센터 나눔 행사\n5월21일   취약계층 교육비 지원사업 신청\n5월25일   윙윙그룹 사회복지재단 생활지원금 지급일");
                break;
            case "202206":
                scdtext.setText("6월 주요소식\n\n6월13일   청년희망적금 신청일\n6월18일   국가장학금 1차 신청\n6월20일   청년주택 결과 발표\n6월20일   자립수당 3차 지급일\n6월22일   보호종료아동 멘토링데이\n6월29일   국민은행 자립아동 장학금 신청");
                break;
            case "202207":
                scdtext.setText("7월 주요소식\n\n7월07일   근로장려금 반기 지급일\n7월12일   굿네이버스 자립아동 장학금 신청\n7월20일   LH청년홈 선정결과 발표\n7월27일   해바라기센터 자립아동 보고서 제출일");
                break;
            case "202208":
                scdtext.setText("8월 주요소식\n\n8월01일   초록우산 어린이재단 지원금 신청\n8월10일   문화 지원비 지급일\n8월16일   서울시 아동복지센터 나눔 행사\n8월21일   취약계층 교육비 지원사업 신청\n8월25일   윙윙그룹 사회복지재단 생활지원금 지급일");
                break;
            case "202209":
                scdtext.setText("9월 주요소식\n\n9월13일   청년희망적금 신청일\n9월18일   국가장학금 1차 신청\n9월20일   청년주택 결과 발표\n9월20일   자립수당 3차 지급일\n9월22일   보호종료아동 멘토링데이\n9월29일   국민은행 자립아동 장학금 신청");
                break;
            case "202210":
                scdtext.setText("10월 주요소식\n\n1월07일   근로장려금 반기 지급일\n10월12일   굿네이버스 자립아동 장학금 신청\n10월20일   LH청년홈 선정결과 발표\n10월27일   해바라기센터 자립아동 보고서 제출일");
                break;
            case "202211":
                scdtext.setText("11월 주요소식\n\n11월01일   초록우산 어린이재단 지원금 신청\n11월10일   문화 지원비 지급일\n11월16일   서울시 아동복지센터 나눔 행사\n11월21일   취약계층 교육비 지원사업 신청\n11월25일   윙윙그룹 사회복지재단 생활지원금 지급일");
                break;
            case "202212":
                scdtext.setText("12월 주요소식\n\n12월13일   청년희망적금 신청일\n12월18일   국가장학금 1차 신청\n12월20일   청년주택 결과 발표\n12월20일   자립수당 3차 지급일\n12월22일   보호종료아동 멘토링데이\n12월29일   국민은행 자립아동 장학금 신청");
                break;






        }




    }





}

