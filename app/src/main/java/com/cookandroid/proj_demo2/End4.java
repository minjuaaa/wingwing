package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class End4 extends Activity {

    Button Back4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tmoney_y);

        Back4 = findViewById(R.id.back4);

        Back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End4.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
