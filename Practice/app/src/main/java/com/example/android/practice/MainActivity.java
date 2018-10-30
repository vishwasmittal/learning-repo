package com.example.android.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        String g = "Mother";
        display(g);
    }
    public void display(String s){
        TextView message = (TextView) findViewById(R.id.gali);
        message.setText(s);
    }
}
