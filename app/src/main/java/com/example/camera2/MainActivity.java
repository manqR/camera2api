package com.example.camera2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Context context;
    Button btnOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        btnOpen = (Button) findViewById(R.id.getpicture);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, CameraActivityCustom.class);
                i.putExtra("key", "1");
                startActivityForResult(i,0);
            }
        });

    }

}
