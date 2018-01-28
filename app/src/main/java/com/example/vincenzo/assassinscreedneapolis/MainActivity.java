package com.example.vincenzo.assassinscreedneapolis;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        ScrollView scroll = findViewById(R.id.scrollView);

        Button sportello = findViewById(R.id.button);
        sportello.setText("Sportello Ospiti");
        sportello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/317701312079449/"));
                startActivity(i);
            }
        });

        Button gruppo = findViewById(R.id.button2);
        gruppo.setText("Gruppo Narrazione e Role");
        gruppo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/1931302960524063/"));
                startActivity(i);
            }
        });

    }
}
