package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;
    int price;
    String name, so, sc;

    public void decrement(View view) {
        if (quantity > 0) quantity--;
        displayquan(quantity);
    }

    public void increment(View view) {
        quantity++;
        displayquan(quantity);
    }

    public void submitOrder(View view) {

        calculate(quantity);

        // checkbox for cream
        CheckBox cream = (CheckBox) findViewById(R.id.cream);
        boolean cre = cream.isChecked();
        if (cre) {
            so = "Add Wipped cream";
            if (quantity > 0) price = price + 1 * quantity;
        } else so = "Wipped cream not added";

        // checkbox for chocolate
        CheckBox choc = (CheckBox) findViewById(R.id.chocolate);
        boolean cho = choc.isChecked();

        // Get name
        EditText name = (EditText) findViewById(R.id.name);
        String n = name.getText().toString();

        this.name = n;

        if (cho) {
            sc = "Add Chocolate";
            if (quantity > 0) price = price + 2 * quantity;
        } else sc = "Chocolate not added";

        String su = "Name " + n + "\n" + so + "\n" + sc + "\n Price = " + "$" + price;
        displayMessage(su);
    }

    private void calculate(int quantity) {
        price = quantity * 5;
    }

    private void displayquan(int num) {
        TextView quantity = (TextView) findViewById(R.id.quantity);
        quantity.setText("" + num);
    }

    private void displayMessage(String s) {
        TextView str = (TextView) findViewById(R.id.price);
        str.setText("" + s);
    }

    public void mail(View view) {
        Intent inte = new Intent(Intent.ACTION_SEND);
        inte.setData(Uri.parse("mailto:0"));  // only email app handle this
        inte.setType("text/html");
        inte.putExtra(Intent.EXTRA_SUBJECT, "Submit order, NAME " + name);
        inte.putExtra(Intent.EXTRA_TEXT, so + "\n" + sc + "\n Quantity "+quantity+"\n Price = " + "$" + price);
        startActivity(Intent.createChooser(inte, "Send Email"));
        //        if (inte.resolveActivity(getPackageManager()) != null) {
        //            startActivity(inte);
        //        }
    }
}
