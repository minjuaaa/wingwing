package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tMoney extends Activity {

    Button yMon, nMon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t02_2);

        yMon = findViewById(R.id.ymoney);
        nMon = findViewById(R.id.nmoney);



        yMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tMoney.this, End4.class );
                startActivity(intent);
            }
        });

        nMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tMoney.this, End5.class );
                startActivity(intent);
            }
        });




    }
}
