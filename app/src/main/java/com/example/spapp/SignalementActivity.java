package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignalementActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signalement);
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
            case R.id.adoption:
                intent = new Intent(SignalementActivity.this, AdoptionActivity.class);
                startActivity(intent);
                break;
            case R.id.accueil:
                intent = new Intent(SignalementActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.english:
                break;
            case R.id.francais:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
