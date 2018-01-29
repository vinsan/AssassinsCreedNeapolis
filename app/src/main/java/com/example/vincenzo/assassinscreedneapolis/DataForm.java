package com.example.vincenzo.assassinscreedneapolis;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DataForm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
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
        //nc.setHintTextColor(Color.BLACK);
        if(!NomeCognome.equals("null")){
            nc.setText(NomeCognome);
        }

        final TextView nt = findViewById(R.id.editText2);
        nt.setHint("Numero tessera:");
        //nt.setHintTextColor(Color.BLACK);
        if(!numeroTessera.equals("null")){
            nt.setText(numeroTessera);
        }

        final TextView pg1 = findViewById(R.id.editText3);
        pg1.setHint("Nome pg 1:");
        //pg1.setHintTextColor(Color.BLACK);
        if(!npg1.equals("null")){
            pg1.setText(npg1);
        }

        final TextView pg2 = findViewById(R.id.editText4);
        pg2.setHint("Nome pg 2:");
        //pg2.setHintTextColor(Color.BLACK);
        if(!npg2.equals("null")){
            pg2.setText(npg2);
        }

        final TextView pg3 = findViewById(R.id.editText5);
        pg3.setHint("Nome pg 3:");
        //pg3.setHintTextColor(Color.BLACK);
        if(!npg3.equals("null")){
            pg3.setText(npg3);
        }

        final TextView fb = findViewById(R.id.editText6);
        fb.setHint("Indirizzo facebook:");
        //fb.setHintTextColor(Color.BLACK);
        if(!facebook.equals("null")){
            fb.setText(facebook);
        }

        final TextView cell = findViewById(R.id.editText7);
        cell.setHint("Numero di Cellulare:");
        //cell.setHintTextColor(Color.BLACK);
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

                setResult(DataForm.RESULT_OK);
                finish();
            }
        });

    }
}
