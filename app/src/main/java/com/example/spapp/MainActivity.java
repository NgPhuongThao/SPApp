package com.example.spapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity:LOG";

    //public SQLClient bdd;

//    public void sauveDonnees(SQLClient bdd){
//        SQLiteDatabase dbW = bdd.getWritableDatabase();
//
//        // Pour pouvoir stocker les données envoyées à la BDD sans utilisation de SQL (Avec SQL- cf plus bas)
//        // Info d'une première personne
//        /*ContentValues valeursFormulaire1 = new ContentValues();
//        valeursFormulaire1.put("id", "1");
//        valeursFormulaire1.put("prenom", "Lucille");
//        valeursFormulaire1.put("telephone", "0606060606");
//        valeursFormulaire1.put("animal", "chien");
//        // Insertion dans la BDD
//        dbW.insert("Formulaire", null, valeursFormulaire1);
//
//        //*************************************************************************
//        // Info d'une deuxième personne
//        ContentValues valeursFormulaire2 = new ContentValues();
//        valeursFormulaire2.put("id", "2");
//        valeursFormulaire2.put("prenom", "Thao");
//        valeursFormulaire2.put("telephone", "0707070707");
//        valeursFormulaire2.put("animal", "chat");
//        // Insertion dans la BDD
//        dbW.insert("Formulaire", null, valeursFormulaire2);*/
//
//        // ferme la connexion en écriture à la BDD -- à vous de voir s'il faut ou non conserver la connexion ouverte ... Attention aux ressources...
//        dbW.close();
//    }
//
//    public void litDonnees(SQLClient bdd){
//        // Ouverture d'une connexion en lecture
//        SQLiteDatabase dbR = bdd.getWritableDatabase();
//
//        // Sans SQL (cf plus bas pour SQL)
//        String [] criteresDeProjection = {"id", "prenom", "telephone", "animal"};
//        String [] critereDeSelection = {}; // Aucun critère donc tous les enregistrements
//
//        // Ouvre un curseur avec le(s) résultat(s)
//        Cursor curs = dbR.query("Formulaire", criteresDeProjection, "", critereDeSelection, null, null, "prenom DESC");
//
//        // Traite les réponses contenues dans le curseur
//
//        // Y'a t'il au moins un résultat ?
//        if (curs.moveToFirst()) {
//            // Parcours des résultats
//            do {
//                // Récupération des données par le numéro de colonne
//                //long formulaireID = curs.getLong(0);
//                // ou avec le nom de la colonne (sans doute à privilégier pour la relecture du code)
//                long formulaireID = curs.getLong(curs.getColumnIndexOrThrow("id"));
//                // déclenche une exception si la colonne n'existe pas cf doc pour autres méthodes disponibles
//                String formulairePrenom = curs.getString(curs.getColumnIndexOrThrow("prenom"));
//
//                Log.v(MainActivity.TAG, formulaireID + " - " + formulairePrenom);
//
//            } while (curs.moveToNext());
//        }
//        else{
//            Toast.makeText(this, "Pas de réponses.....", Toast.LENGTH_SHORT).show();
//        }
//
//        //------------------------------------------------------------ Avec SQL
//        Cursor cursSQL = dbR.rawQuery("select id, prenom, telephone, animal from Formulaire order by prenom ASC", null);
//
//        // Le traitement des résultats est similaire à haut dessus.
//        // Y'a t'il au moins un résultat ?
//        if (curs.moveToFirst()) {
//            // Parcours des résultats
//            do {
//                // Récupération des données par le numéro de colonne
//                //long formulaireID = curs.getLong(0);
//                // ou avec le nom de la colonne (sans doute à privilégier pour la relecture du code)
//                long formulaireID = curs.getLong(curs.getColumnIndexOrThrow("id"));
//                // déclenche une exception si la colonne n'existe pas cf doc pour autres méthodes disponibles
//                String formulairePrenom = curs.getString(curs.getColumnIndexOrThrow("prenom"));
//
//                Log.v(MainActivity.TAG, formulaireID + " - " + formulairePrenom);
//
//            } while (curs.moveToNext());
//        }
//        else{
//            Toast.makeText(this, "Pas de réponses.....", Toast.LENGTH_SHORT).show();
//        }
//
//        // ferme la connexion en lecture à la BDD -- à vous de voir s'il faut ou non conserver la connexion ouverte ... Attention aux ressources...
//        //dbR.close();
//    }
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // une instance de SQLClient suffit pour une activité et pour l'ensemble des tables...
//        this.bdd = new SQLClient(this);
//
//        // Illustration de l'écriture de données dans la BDD
//        this.sauveDonnees(bdd);
//
//        //########################################################################
//        // Illustration de la lecture de données dans la BDD
//        this.litDonnees(bdd);
//
//        // FINISH : Ferme l'instance de BDD ainsi que toutes les connexions ouvertes --> Voir onDestroy()
//        //bdd.close();

        Button btnSignalement = (Button) findViewById(R.id.bouton_signalement);
        btnSignalement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignalementActivity.class);
                startActivity(intent);
            }
        });
    }

    // Création du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflaterMenu = getMenuInflater();
        inflaterMenu.inflate(R.menu.my_menu, menu);
        return true;
    }

    // Actions du menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        Intent intent;
        switch(item.getItemId()){
            case R.id.adoption:
                intent = new Intent(MainActivity.this, AdoptionActivity.class);
                startActivity(intent);
                break;
            case R.id.signalement:
                intent = new Intent(MainActivity.this, SignalementActivity.class);
                startActivity(intent);
                break;
            case R.id.english:
                LocaleHelper.setLocale(MainActivity.this, "");
                finish();
                startActivity(getIntent());
                break;
            case R.id.francais:
                LocaleHelper.setLocale(MainActivity.this, "fr");
                finish();
                startActivity(getIntent());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // FINISH : Ferme l'instance de BDD ainsi que toutes les connexions ouvertes
//        bdd.close();
//    }
}

