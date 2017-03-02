package com.avenueinfotech.flashlight;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    ImageView imagebtn;
    private Camera caml;
    Camera.Parameters params;
    private  boolean isOn;
    TextView textView;


    long time = 0;
    private float cpv_contourSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        caml = Camera.open();
        imagebtn = (ImageView)findViewById(R.id.imagebtn);
        textView = (TextView)findViewById(R.id.textView);
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn){

                    params = caml.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    caml.setParameters(params);
                    caml.stopPreview();
                    isOn=false;
                    imagebtn.setImageResource(R.drawable.flash);
                    textView.setText("Flash Light is OFF");
                }
                else {

                    params=caml.getParameters();
                    params = caml.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    caml.setParameters(params);
                    caml.stopPreview();
                    isOn=true;
                    imagebtn.setImageResource(R.drawable.flashon);
                    textView.setText("Flash Light is ON");
                }
            }
        });
    }




}
