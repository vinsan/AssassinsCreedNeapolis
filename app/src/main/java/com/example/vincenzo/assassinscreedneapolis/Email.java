package com.example.vincenzo.assassinscreedneapolis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String NomeCognome = prefs.getString("NomeCognome", "null");
        String numeroTessera = prefs.getString("Tessera", "null");
        String npg1 = prefs.getString("pg1", "null");
        String npg2 = prefs.getString("pg2", "null");
        String npg3 = prefs.getString("pg3", "null");
        String fb = prefs.getString("Facebook", "null");
        String cellulare = prefs.getString("Cellulare", "null");
        //SharedPreferences.Editor editor = prefs.edit();

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
                Toast.makeText(getApplicationContext(), "Questo bottone non fà ancora niente ma sarà implementato in futuro!", Toast.LENGTH_SHORT).show();
            }
        });

        Button button14 = findViewById(R.id.button14);
        button14.setText("Indietro");
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Email.RESULT_OK);
                finish();
            }
        });

    }
}
