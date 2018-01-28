package com.example.vincenzo.assassinscreedneapolis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vincenzo on 28/01/2018.
 */

public class DataForm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String NomeCognome = prefs.getString("NomeCognome", "null");

        TextView nc = findViewById(R.id.editText);
        nc.setHint("Nome e Cognome:");

        TextView nt = findViewById(R.id.editText2);
        nt.setHint("Numero tessera:");

        TextView pg1 = findViewById(R.id.editText3);
        pg1.setHint("Nome pg 1:");

        TextView pg2 = findViewById(R.id.editText4);
        pg2.setHint("Nome pg 2:");

        TextView pg3 = findViewById(R.id.editText5);
        pg3.setHint("Nome pg 3:");

        TextView fb = findViewById(R.id.editText6);
        fb.setHint("Indirizzo facebook:");

        TextView cell = findViewById(R.id.editText7);
        cell.setHint("Numero di Cellulare:");

        Button salva = findViewById(R.id.button12);
        salva.setText("Salva");
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });


                /*
Nome e cognome:
Numero tessera: (campo non obbligatorio)
Nome pg 1: (campo non obbligatorio)
Nome pg 2: (campo non obbligatorio)
Nome pg 3: (campo non obbligatorio)
Indirizzo facebook: (campo non obbligatorio)
Numero di cellulare:
        */

                /*
                Toast.makeText(MainActivity.this, "Benvenuto "+NomeCognome+"!", Toast.LENGTH_SHORT).show();
            editor.putString("NomeCognome", null);
            editor.commit();
                */

    }
}
