package com.example.spapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                break;
            case R.id.francais:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}