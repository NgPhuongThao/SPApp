package com.example.spapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdoptionActivity extends AppCompatActivity {
    public static final int LAUNCH_DESCRIPTION_ACTIVITY = 1;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> data;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);

        ListView liste = findViewById(R.id.liste);

        SQLClient bdd = new SQLClient(this);
        this.data = bdd.getAnimal();
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.data);
        liste.setAdapter(this.adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valeurItem = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(AdoptionActivity.this, DescriptionActivity.class);
                intent.putExtra("texteListe", valeurItem);

                startActivityForResult(intent, LAUNCH_DESCRIPTION_ACTIVITY);
            }
        });

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
                LocaleHelper.setLocale(AdoptionActivity.this, "");
                finish();
                startActivity(getIntent());
                break;
            case R.id.francais:
                LocaleHelper.setLocale(AdoptionActivity.this, "fr");
                finish();
                startActivity(getIntent());
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_DESCRIPTION_ACTIVITY) {
            if(resultCode == AdoptionActivity.RESULT_OK){
                String result = data.getStringExtra("result");

                SQLClient bdd = new SQLClient(this);
                SQLiteDatabase db = bdd.getReadableDatabase();
                db.execSQL("DELETE FROM sauveurs WHERE nomAnimal = '" + result + "'");
                Log.v("Activity","DELETE FROM sauveurs WHERE nomAnimal = '" + result + "'");
                db.close();

                this.data.clear();
                this.data = bdd.getAnimal();
                this.adapter.notifyDataSetChanged();
            }
        }
    } //onActivityResult
}
