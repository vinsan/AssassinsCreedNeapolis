package com.example.vincenzo.assassinscreedneapolis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
        final String NomeCognome = prefs.getString("NomeCognome", "null");
        final String numeroTessera = prefs.getString("Tessera", "null");
        String npg1 = prefs.getString("pg1", "null");
        String npg2 = prefs.getString("pg2", "null");
        String npg3 = prefs.getString("pg3", "null");
        final String fb = prefs.getString("Facebook", "null");
        final String cellulare = prefs.getString("Cellulare", "null");
        //SharedPreferences.Editor editor = prefs.edit();
        final String mail = "acn.soa.iscrizioneeventi@gmail.com";    //<- TARGET EMAIL
        //PARAMETRI DA AGGIORNARE OGNI MESE PER MODIFICARE L'EVENTO
        final String nomeEvento = "Taverna";
        final String dataEvento = "13 Febbraio 2018";

        Button button3 = findViewById(R.id.button3);
        button3.setText("Iscrizione PG");

        Button button4 = findViewById(R.id.button4);
        button4.setText("Iscrizione PNG");

        Button button5 = findViewById(R.id.button5);
        button5.setText("Iscrizione Staff");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iscrizioneNoPG(NomeCognome, "Staff", numeroTessera, cellulare, fb, mail, nomeEvento, dataEvento);
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setText("Iscrizione Spettatore");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iscrizioneNoPG(NomeCognome, "Spettatore", numeroTessera, cellulare, fb, mail, nomeEvento, dataEvento);
            }
        });

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

    public void iscrizioneNoPG(String nomeCognome, String tipoPartecipazione, String numeroTessera, String cellulare, String fb, String mail, String nomeEvento, String dataEvento){
        Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Iscrizione " + tipoPartecipazione);
        intent.putExtra(Intent.EXTRA_TEXT, "Nome socio: "+ nomeCognome +"\n" + "Nome pg: Nessuno\n" + "Tipo di partecipazione: "+ tipoPartecipazione +"\n" + "Numero tessera:" + numeroTessera + "\n" + "Numero cellulare: "+ cellulare +"\n" + "Indirizzo facebook: "+ fb + "\n Nome Evento: " + nomeEvento+"\n Data Evento: "+dataEvento);
        intent.setData(Uri.parse("mailto:"+mail));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

        startActivity(intent);
    }

}
