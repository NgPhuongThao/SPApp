package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignalementActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signalement);

        Button btnValider = findViewById(R.id.button2);
        EditText entreePrenom = findViewById(R.id.editTextTextPersonName3);
        EditText entreePhone = findViewById(R.id.editTextTextPersonName4);
        RadioButton chien = findViewById(R.id.radio_chien);
        RadioButton chat = findViewById(R.id.radio_chat);
        RadioButton autre = findViewById(R.id.radio_autre);
        EditText entreeAutre = findViewById(R.id.espece);


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prenom = entreePrenom.getText().toString();
                String telephone = entreePhone.getText().toString();
                String animal = entreeAutre.getText().toString();
                if (chien.isChecked()) {
                    animal = "Chien";
                } else if (chat.isChecked()) {
                    animal = "Chat";
                }

                SQLClient bd = new SQLClient(SignalementActivity.this);
                bd.insererDonnees(prenom, telephone, animal);

                entreePrenom.setText("");
                entreePhone.setText("");
                entreeAutre.setText("");
                chien.setChecked(false);
                chat.setChecked(false);
                autre.setChecked(false);

                Toast.makeText(getApplicationContext(), "Animal enregistré", Toast.LENGTH_LONG).show();
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
            case R.id.adoption:
                intent = new Intent(SignalementActivity.this, AdoptionActivity.class);
                startActivity(intent);
                break;
            case R.id.accueil:
                intent = new Intent(SignalementActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.english:
                LocaleHelper.setLocale(SignalementActivity.this, "");
                finish();
                startActivity(getIntent());
                break;
            case R.id.francais:
                LocaleHelper.setLocale(SignalementActivity.this, "fr");
                finish();
                startActivity(getIntent());
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
