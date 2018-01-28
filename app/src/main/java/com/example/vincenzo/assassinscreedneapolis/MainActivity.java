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
        SharedPreferences.Editor editor = prefs.edit();
        String NomeCognome = prefs.getString("NomeCognome", "null");
        if(NomeCognome.equals("null")){
            Intent intent = new Intent(this, DataForm.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Bentornato "+NomeCognome+"!", Toast.LENGTH_SHORT).show();
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

        Button button3 = findViewById(R.id.button3);
        button3.setText("aclracn@gmail.com");

        Button button4 = findViewById(R.id.button4);
        button4.setText("acn.soa@gmail.com");
        Button button5 = findViewById(R.id.button5);
        button5.setText("acn.soa.background@gmail.com");
        Button button6 = findViewById(R.id.button6);
        button6.setText("acn.soa.arbitri@gmail.com");
        Button button7 = findViewById(R.id.button7);
        button7.setText("acn.probiviri@gmail.com");
        Button button8 = findViewById(R.id.button8);
        button8.setText("acn.soa.iscrizioneeventi@gmail.com");
        Button button9 = findViewById(R.id.button9);
        button9.setText("acn.puntimerito@gmail.com");
        Button button10 = findViewById(R.id.button10);
        button10.setText("acn.soa.narrazione@gmail.com");

        Button button11 = findViewById(R.id.button11);
        button11.setText("Coming Soon");
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Questo bottone non fà ancora niente ma sarà implementato in futuro!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
