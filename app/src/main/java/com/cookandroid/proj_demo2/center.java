package com.cookandroid.proj_demo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;


public class center extends FragmentActivity implements OnMapReadyCallback {

    EditText edit;
    private static NaverMap naverMap;
    TextView text, Example;
    private Marker marker1 = new Marker();

    XmlPullParser xpp;
    String key = "F0uWjz5Os0tnCmOvJC5t";
//Naver 개발자센터 검색 키

    String data;
    Double mLogt, mLat;
    StringBuffer bLogt, bLat;
    String sLogt, sLat;
    Button btn;
    int a = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.center);

        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.result);
        btn = findViewById(R.id.button);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);


    }

    //Button을 클릭했을 때 자동으로 호출되는 callback method....
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.button:

                //Android 4.0 이상 부터는 네트워크를 이용할 때 반드시 Thread 사용해야 함
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        data = getXmlData();//아래 메소드를 호출하여 XML data를 파싱해서 String 객체로 얻어오기

                        //UI Thread(Main Thread)를 제외한 어떤 Thread도 화면을 변경할 수 없기때문에
                        //runOnUiThread()를 이용하여 UI Thread가 TextView 글씨 변경하도록 함
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                text.setText(data); //TextView에 문자열  data 출력
                            }
                        });
                    }
                }).start();
                break;
        }

        btn.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v){
                setMarker(marker1, 37.4194676, 127.1258895);




            }
        });



    }//mOnClick method..


    //XmlPullParser를 이용하여 Naver 에서 제공하는 OpenAPI XML 파일 파싱하기(parsing)
    String getXmlData() {

        StringBuffer buffer = new StringBuffer();
        StringBuffer logt = new StringBuffer();
        StringBuffer lat = new StringBuffer();

        String str = edit.getText().toString();//EditText에 작성된 Text얻어오기
        String location = URLEncoder.encode(str);//한글의 경우 인식이 안되기에 utf-8 방식으로 encoding..
        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";


        String queryUrl = "https://openapi.gg.go.kr/YoungBoyAndGirsWelfareConsult/?KEY=c2ff04d27fb9434499b071e011d57a3f&pIndex=1&SIGUN_NM="+location;


        try {
            URL url = new URL(queryUrl);//문자열로 된 요청 url을 URL 객체로 생성.
            InputStream is = url.openStream(); //url위치로 입력스트림 연결

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8")); //inputstream 으로부터 xml 입력받기

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();//테그 이름 얻어오기

                        if (tag.equals("item")) ;// 첫번째 검색결과
                        else if (tag.equals("CONSLTN_CENTER_OPERT_GRP_NM")) {
                            buffer.append("센터명 : ");
                            xpp.next();
                            buffer.append(xpp.getText());//category 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        } else if (tag.equals("CENTER_TELNO")) {
                            buffer.append("전화번호 :");
                            xpp.next();
                            buffer.append(xpp.getText());//description 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");//줄바꿈 문자 추가
                        } else if (tag.equals("REFINE_LOTNO_ADDR")) {
                            buffer.append("주소 :");
                            xpp.next();
                            buffer.append(xpp.getText());//telephone 요소의 TEXT 읽어와서 문자열버퍼에 추가
                            buffer.append("\n");
                        } else if (tag.equals("HMPG_ADDR")) {
                                buffer.append("홈페이지 :");
                                xpp.next();
                                buffer.append(xpp.getText());//telephone 요소의 TEXT 읽어와서 문자열버퍼에 추가
                                buffer.append("\n");//줄바꿈 문자 추가
                        } else if (tag.equals("REFINE_WGS84_LOGT")) {
                            xpp.next();
                            bLogt.append(xpp.getText());
                            sLogt = bLogt.toString();
                            mLogt = Double.parseDouble(sLogt);

                        }  else if (tag.equals("REFINE_WGS84_LAT")) {
                            sLat = xpp.getText();
                            mLat = Double.parseDouble(sLat);

                        }
                        break;




                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); //테그 이름 얻어오기

                        if (tag.equals("item")) buffer.append("\n");// 첫번째 검색결과종료..줄바꿈
                        break;
                }

                eventType = xpp.next();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch blocke.printStackTrace();
        }



        return buffer.toString();//StringBuffer 문자열 객체 반환




    }

    private void setMarker(Marker marker, double a, double b)
    {
        //마커의 투명도
        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(a, b));
        //마커 우선순위
        //마커 표시
        marker.setMap(naverMap);
    }


    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {

            this.naverMap = naverMap;

            CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(37.4194676, 127.1258895))
                    .animate(CameraAnimation.Easing);
            naverMap.moveCamera(cameraUpdate);


        }




    }

