package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends AdoptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String intent = getIntent().getStringExtra("texteListe");

        TextView animal = findViewById(R.id.textView10);
        animal.setText(intent);
        TextView personne = findViewById(R.id.textView14);
        TextView phone = findViewById((R.id.textView16));

        Button retour = findViewById(R.id.button3);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(DescriptionActivity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

        Button adopter = findViewById(R.id.button4);
        adopter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","mettre_le_truc_pour_supprimer_de_la_bdd");
                setResult(DescriptionActivity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
