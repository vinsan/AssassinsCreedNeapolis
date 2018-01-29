package com.example.vincenzo.assassinscreedneapolis;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DataForm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = prefs.edit();
        String NomeCognome = prefs.getString("NomeCognome", "null");
        String numeroTessera = prefs.getString("Tessera", "null");
        String npg1 = prefs.getString("pg1", "null");
        String npg2 = prefs.getString("pg2", "null");
        String npg3 = prefs.getString("pg3", "null");
        String facebook = prefs.getString("Facebook", "null");
        String cellulare = prefs.getString("Cellulare", "null");

        final TextView nc = findViewById(R.id.editText);
        nc.setHint("Nome e Cognome:");
        nc.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        if(!NomeCognome.equals("null")){
            nc.setText(NomeCognome);
        }

        final TextView nt = findViewById(R.id.editText2);
        nt.setHint("Numero tessera:");
        nt.setInputType(InputType.TYPE_CLASS_NUMBER);
        if(!numeroTessera.equals("null")){
            nt.setText(numeroTessera);
        }

        final TextView pg1 = findViewById(R.id.editText3);
        pg1.setHint("Nome pg 1:");
        if(!npg1.equals("null")){
            pg1.setText(npg1);
        }

        final TextView pg2 = findViewById(R.id.editText4);
        pg2.setHint("Nome pg 2:");
        if(!npg2.equals("null")){
            pg2.setText(npg2);
        }

        final TextView pg3 = findViewById(R.id.editText5);
        pg3.setHint("Nome pg 3:");
        if(!npg3.equals("null")){
            pg3.setText(npg3);
        }

        final TextView fb = findViewById(R.id.editText6);
        fb.setHint("Indirizzo facebook:");
        fb.setInputType(InputType.TYPE_TEXT_VARIATION_URI);
        if(!facebook.equals("null")){
            fb.setText(facebook);
        }

        final TextView cell = findViewById(R.id.editText7);
        cell.setHint("Numero di Cellulare:");
        cell.setInputType(InputType.TYPE_CLASS_PHONE);
        if(!cellulare.equals("null")){
            cell.setText(cellulare);
        }

        Button salva = findViewById(R.id.button12);
        salva.setText("Salva");
        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NomeCognome = nc.getText().toString();
                String numeroTessera = nt.getText().toString();
                String npg1 = pg1.getText().toString();
                String npg2 = pg2.getText().toString();
                String npg3 = pg3.getText().toString();
                String facebook = fb.getText().toString();
                String cellulare = cell.getText().toString();

                editor.putString("NomeCognome", NomeCognome);
                editor.putString("Tessera", numeroTessera);
                editor.putString("pg1", npg1);
                editor.putString("pg2", npg2);
                editor.putString("pg3", npg3);
                editor.putString("Facebook", facebook);
                editor.putString("Cellulare", cellulare);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Dati salvati con successo!", Toast.LENGTH_SHORT).show();
                setResult(DataForm.RESULT_OK);
                finish();
            }
        });

    }
}
