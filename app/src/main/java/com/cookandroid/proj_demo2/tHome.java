package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tHome extends Activity {


    Button Y01, N01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t01);

        Y01 = findViewById(R.id.y01);
        N01 = findViewById(R.id.n01);



        Y01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tHome.this, tStdWk.class );
                startActivity(intent);
            }
        });

        N01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tHome.this, tMoney.class );
                startActivity(intent);
            }
        });




    }


}
