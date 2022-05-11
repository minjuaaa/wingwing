package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tWork extends Activity {


    Button yWork, nWork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twork);

        yWork = findViewById(R.id.ywork);
        nWork = findViewById(R.id.nwork);



        yWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tWork.this, End2.class );
                startActivity(intent);
            }
        });

        nWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tWork.this, End3.class );
                startActivity(intent);
            }
        });


    }


}
