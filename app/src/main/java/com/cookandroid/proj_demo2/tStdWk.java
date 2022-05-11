package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tStdWk extends Activity {


    Button std, work;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t02_1);

        std = findViewById(R.id.btnstd);
        work = findViewById(R.id.btnwork);



        std.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tStdWk.this, End1.class );
                startActivity(intent);
            }
        });

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(tStdWk.this, tWork.class );
                startActivity(intent);
            }
        });




    }
}
