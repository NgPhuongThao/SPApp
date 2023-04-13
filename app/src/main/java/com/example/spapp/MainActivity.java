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
    public Context context;
    public Resources resources;

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

}

