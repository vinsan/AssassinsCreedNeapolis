package com.example.vincenzo.assassinscreedneapolis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Gruppi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gruppi);

        Button sportello = findViewById(R.id.button);
        sportello.setText("Sportello Ospiti");
        sportello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/317701312079449/"));
                startActivity(i);
            }
        });

        Button gruppo = findViewById(R.id.button2);
        gruppo.setText("Gruppo Narrazione e Role");
        gruppo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/aclracn/"));
                startActivity(i);
            }
        });

        Button associati = findViewById(R.id.button13);
        associati.setText("Gruppo Associati");
        associati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/128797747751735/"));
                startActivity(i);
            }
        });

        Button button15 = findViewById(R.id.button15);
        button15.setText("Indietro");
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Gruppi.RESULT_OK);
                finish();
            }
        });



    }
}
