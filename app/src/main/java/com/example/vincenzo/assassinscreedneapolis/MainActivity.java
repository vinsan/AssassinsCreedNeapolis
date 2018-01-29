package com.example.vincenzo.assassinscreedneapolis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String NomeCognome = prefs.getString("NomeCognome", "null");
        String numeroTessera = prefs.getString("Tessera", "null");
        String npg1 = prefs.getString("pg1", "null");
        String npg2 = prefs.getString("pg2", "null");
        String npg3 = prefs.getString("pg3", "null");
        String fb = prefs.getString("Facebook", "null");
        String cellulare = prefs.getString("Cellulare", "null");
        //SharedPreferences.Editor editor = prefs.edit();

        if(NomeCognome.equals("null")||cellulare.equals("null")){
            Intent intent = new Intent(this, DataForm.class);
            startActivity(intent);
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int larghezza = (size.x/2);
        int altezza = (size.y/3);

        ImageView facebook = findViewById(R.id.imageView2);
        facebook.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.facebooklogo), larghezza*30/100, altezza*40/100, true));
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/acneapolis/"));
                startActivity(i);
            }
        });

        Button gruppi = findViewById(R.id.button);
        gruppi.setText("Gruppi");
        gruppi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Gruppi.class);
                startActivity(intent);
            }
        });

        Button button15 = findViewById(R.id.button15);
        button15.setText("Mail Associative");
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Email.class);
                startActivity(intent);
            }
        });


        Button button13 = findViewById(R.id.button13);
        button13.setText("Modifica Dati");
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DataForm.class);
                startActivity(intent);
            }
        });

    }
}
