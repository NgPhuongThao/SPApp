package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AdoptionActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);
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
