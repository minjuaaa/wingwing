package com.cookandroid.proj_demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class End2 extends Activity {

    Button Back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twork_1);

        Back2 = findViewById(R.id.back2);

        Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(End2.this, MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
