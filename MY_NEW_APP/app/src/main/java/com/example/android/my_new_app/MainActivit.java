package com.example.android.my_new_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CLICK(View view) {
        TextView txt = (TextView) findViewById(R.id.text);
        txt.setText("I'm so FULL");
        ImageView beforeCookieImageView = (ImageView) findViewById(R.id.image);
        beforeCookieImageView.setImageResource(R.drawable.after_cookie);
    }

}
