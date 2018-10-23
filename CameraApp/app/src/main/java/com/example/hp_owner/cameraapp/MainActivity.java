package com.example.hp_owner.cameraapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //declare variables
    Button cameraButton;
    ImageView imageView;
    static final int CAMERA_PIC_REQUEST=1024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign
        cameraButton=(Button)findViewById(R.id.button);//R??? Resource
        imageView=(ImageView)findViewById(R.id.imageView);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //declaring intent => to move from one activity to other
                //example new intent(Your Current Activity, To other Activity)
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //start intent, we will be using startActivityForResult,
                //this function requires a **request code**
                //startActivityForResult(intent,1024); just because bad practise
                startActivityForResult(intent,CAMERA_PIC_REQUEST);//always use variables

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        //this function is called by startActivityForResult
        //request code is used to uniquely identify which activity Intent is executed by
        if(requestCode == CAMERA_PIC_REQUEST && resultCode == RESULT_OK){
            Bitmap image =(Bitmap) data.getExtras().get("data");
            //here data is the **key** with image as its value

            imageView.setImageBitmap(image);
            //setting content (here the image we captured)

        }
    }
}
