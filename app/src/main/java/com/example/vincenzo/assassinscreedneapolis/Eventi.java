package com.example.vincenzo.assassinscreedneapolis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Eventi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventi);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String NomeCognome = prefs.getString("NomeCognome", "null");
        String numeroTessera = prefs.getString("Tessera", "null");
        String npg1 = prefs.getString("pg1", "null");
        String npg2 = prefs.getString("pg2", "null");
        String npg3 = prefs.getString("pg3", "null");
        String fb = prefs.getString("Facebook", "null");
        String cellulare = prefs.getString("Cellulare", "null");
        //SharedPreferences.Editor editor = prefs.edit();
        String mail = "acn.soa.iscrizioneeventi@gmail.com";    //<- TARGET EMAIL

        Button button3 = findViewById(R.id.button3);
        button3.setText("Iscrizione PG");

        Button button4 = findViewById(R.id.button4);
        button4.setText("Iscrizione PNG");

        Button button5 = findViewById(R.id.button5);
        button5.setText("Iscrizione Staff");

        Button button6 = findViewById(R.id.button6);
        button6.setText("Iscrizione Spettatore");

        Button button7 = findViewById(R.id.button7);
        button7.setText("Iscrizione PG in Prova");

        Button button8 = findViewById(R.id.button8);
        button8.setText("Iscrizione PNG in Prova");

        Button button14 = findViewById(R.id.button14);
        button14.setText("Indietro");
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Eventi.RESULT_OK);
                finish();
            }
        });

    }
}
