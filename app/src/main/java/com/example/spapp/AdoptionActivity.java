package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdoptionActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);

        ListView liste = findViewById(R.id.liste);

        List<String> listeValeursDansLaListe = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listeValeursDansLaListe);

        liste.setAdapter(adapter);

        listeValeursDansLaListe.add("Pasha | Chien");
        listeValeursDansLaListe.add("Bouille | Chien");
        listeValeursDansLaListe.add("Jazz | Chat");
        listeValeursDansLaListe.add("Toupie | Lapin");
        listeValeursDansLaListe.add("Parrot | Perroquet");

        adapter.notifyDataSetChanged();
    }
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
            case R.id.accueil:
                intent = new Intent(AdoptionActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.signalement:
                intent = new Intent(AdoptionActivity.this, SignalementActivity.class);
                startActivity(intent);
                break;
            case R.id.english:
                break;
            case R.id.francais:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
