package com.example.vincenzo.assassinscreedneapolis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Eventi extends AppCompatActivity {

    String character = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventi);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final String NomeCognome = prefs.getString("NomeCognome", "null");
        final String numeroTessera = prefs.getString("Tessera", "null");
        final String npg1 = prefs.getString("pg1", "null");
        final String npg2 = prefs.getString("pg2", "null");
        final String npg3 = prefs.getString("pg3", "null");
        final String fb = prefs.getString("Facebook", "null");
        final String cellulare = prefs.getString("Cellulare", "null");
        //SharedPreferences.Editor editor = prefs.edit();
        final String mail = "acn.soa.iscrizioneeventi@gmail.com";    //<- TARGET EMAIL

        //PARAMETRI DA AGGIORNARE OGNI MESE PER MODIFICARE L'EVENTO
        final String nomeEvento = "SoAS 0 - River Kings Casinò + Cena di Carnevale";
        final String dataEvento = "13 Febbraio 2018";

        //RADIO BUTTON PER LA SCELTA DEL PG
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);

        if(npg1.equals("null")||npg1.equals("")){
            rb1.setVisibility(View.INVISIBLE);  //se non hai personaggi il bottone diventa invisibile
        }else{
            rb1.setText("PG1: "+npg1);
            rb1.setChecked(true);
        }
        rb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                character = npg1;
            }
        });

        if(npg2.equals("null")||npg2.equals("")){
            rb2.setVisibility(View.INVISIBLE);
        }else{
            rb2.setText("PG2: "+npg2);
        }
        rb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                character = npg2;
            }
        });

        if(npg3.equals("null")||npg3.equals("")){
            rb3.setVisibility(View.INVISIBLE);
        }else{
            rb3.setText("PG3: "+npg3);
        }
        rb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                character = npg3;
            }
        });

        if((!npg1.equals("null")&&!npg1.equals("")) && (npg2.equals("null")||npg2.equals("")) && (npg3.equals("null")||npg3.equals(""))){
            rb1.setVisibility(View.INVISIBLE);  //se hai un sono personaggio il bottone 1 diventa invisibile e di DEFAULT
            character = npg1;
        }

        Button button3 = findViewById(R.id.button3);
        button3.setText("Iscrizione PG");
        final String finalCharacter = character;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((npg1.equals("null")||npg1.equals("")) && (npg2.equals("null")||npg2.equals("")) && (npg3.equals("null")||npg3.equals(""))){
                    Toast.makeText(getApplicationContext(), "Devi prima inserire il nome di un PG per iscriverti all'evento come PG! Modifica i tuoi dati e riprova!", Toast.LENGTH_LONG).show();
                }else{
                    iscrizione(NomeCognome, character,"PG", numeroTessera, cellulare, fb, mail, nomeEvento, dataEvento);
                }
            }
        });


        Button button4 = findViewById(R.id.button4);
        button4.setText("Iscrizione PNG");

        Button button5 = findViewById(R.id.button5);
        button5.setText("Iscrizione Staff");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iscrizione(NomeCognome, "Nessuno","Staff", numeroTessera, cellulare, fb, mail, nomeEvento, dataEvento);
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setText("Iscrizione Spettatore");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iscrizione(NomeCognome, "Nessuno","Spettatore", numeroTessera, cellulare, fb, mail, nomeEvento, dataEvento);
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setText("Iscrizione PG in Prova");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((npg1.equals("null")||npg1.equals("")) && (npg2.equals("null")||npg2.equals("")) && (npg3.equals("null")||npg3.equals(""))){
                    Toast.makeText(getApplicationContext(), "Devi prima inserire il nome di un PG per iscriverti all'evento come PG in prova! Modifica i tuoi dati e riprova!", Toast.LENGTH_LONG).show();
                }else{
                    iscrizione(NomeCognome, character,"PG in Prova", numeroTessera, cellulare, fb, mail, nomeEvento, dataEvento);
                }
            }
        });

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

    public void iscrizione(String nomeCognome, String nomePG, String tipoPartecipazione, String numeroTessera, String cellulare, String fb, String mail, String nomeEvento, String dataEvento){
        Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Iscrizione " + tipoPartecipazione);
        intent.putExtra(Intent.EXTRA_TEXT, "Nome socio: "+ nomeCognome +"\n" + "Nome pg: "+ nomePG +"\n" + "Tipo di partecipazione: "+ tipoPartecipazione +"\n" + "Numero tessera:" + numeroTessera + "\n" + "Numero cellulare: "+ cellulare +"\n" + "Indirizzo facebook: "+ fb + "\n Nome Evento: " + nomeEvento+"\n Data Evento: "+dataEvento);
        intent.setData(Uri.parse("mailto:"+mail));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

        startActivity(intent);
    }

}
