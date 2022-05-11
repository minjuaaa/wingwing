package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class End5 extends Activity {

    Button Back5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tmoney_n);

        Back5 = findViewById(R.id.back1);

        Back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End5.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
