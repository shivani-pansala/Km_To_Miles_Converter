//package com.example.km_to_miles;
//
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.text.DecimalFormat;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    private EditText milesInput;
//    private EditText kmInput;
//    private Button convKmToMiles;
//    private Button convMilesToKm;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main2);
//
//
//        // registering selectors
//        this.milesInput = findViewById(R.id.milesInput);
//        this.kmInput = findViewById(R.id.kmInput);
//        this.convKmToMiles = findViewById(R.id.convKmToMiles);
//        this.convMilesToKm = findViewById(R.id.convMilesToKm);
//
//        this.convKmToMiles.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                try {
//                    double km = Double.valueOf(kmInput.getText().toString());
//                    double milesAns = ConversionService.kmToMiles(km);
//                    milesInput.setText(new DecimalFormat("##.##").format(milesAns));
//                } catch (java.lang.NumberFormatException e) {
//                    CharSequence msg = "Please enter a valid KM value";
//                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        this.convMilesToKm.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                try {
//                    double miles = Double.valueOf(milesInput.getText().toString());
//                    double kmAns = ConversionService.milesToKm(miles);
//                    kmInput.setText(new DecimalFormat("##.##").format(kmAns));
//                } catch (java.lang.NumberFormatException e) {
//                    CharSequence msg = "Please enter a valid miles value";
//                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu resource file (mymenu.xml)
//        getMenuInflater().inflate(R.menu.mymenu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(android.view.MenuItem item) {
//        // Get the ID of the selected menu item
//        int id = item.getItemId();
//
//        if (id == R.id.action_about) {
//            // Handle the "About" option
//            Toast.makeText(this, "KM to Miles Converter v1.0", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}


package com.example.km_to_miles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    private EditText milesInput;
    private EditText kmInput;
    private Button convKmToMiles;
    private Button convMilesToKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        // Registering selectors
        milesInput = findViewById(R.id.milesInput);
        kmInput = findViewById(R.id.kmInput);
        convKmToMiles = findViewById(R.id.convKmToMiles);
        convMilesToKm = findViewById(R.id.convMilesToKm);

        // Set the click listener for converting KM to Miles
        convKmToMiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double km = Double.parseDouble(kmInput.getText().toString());
                    double milesAns = ConversionService.kmToMiles(km);
                    milesInput.setText(new DecimalFormat("##.##").format(milesAns));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid KM value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set the click listener for converting Miles to KM
        convMilesToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double miles = Double.parseDouble(milesInput.getText().toString());
                    double kmAns = ConversionService.milesToKm(miles);
                    kmInput.setText(new DecimalFormat("##.##").format(kmAns));
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid Miles value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if present
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here
        int id = item.getItemId();

        // Handle "About" menu option
        if (id == R.id.action_about) {

            Intent intent = new Intent(this, About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
