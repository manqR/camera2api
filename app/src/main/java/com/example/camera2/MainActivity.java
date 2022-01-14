package com.example.camera2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.media.Image;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends Activity {

    Context context;
    Button btnOpen;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        btnOpen = (Button) findViewById(R.id.getpicture);


        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),CameraActivity.class);
//                startActivity(i);
//
//                getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, Camera2BasicFragment.newInstance())
//                            .commit();

                Intent i = new Intent(context, Camera2Activity.class);
                i.putExtra("key", "0");
                startActivityForResult(i,0);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        imgView = (ImageView) findViewById(R.id.imgView);

        if(resultCode == RESULT_OK){

            Bitmap bitmap = null;
            try {
                super.onActivityResult(requestCode,resultCode,data);

                byte[] byteImage = data.getByteArrayExtra("bmp");
                bitmap = BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
                imgView.setImageBitmap(bitmap);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(context, "Capture Canceled", Toast.LENGTH_SHORT).show();
        }



    }
}
