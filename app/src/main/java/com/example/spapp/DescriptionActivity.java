package com.example.spapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DescriptionActivity extends AdoptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        String intent = getIntent().getStringExtra("texteListe");
        String[] elements = intent.split("-");

        TextView animal = findViewById(R.id.textView10);
        animal.setText(intent);

        TextView personne = findViewById(R.id.textView14);
        personne.setText(elements[0]);

        TextView phone = findViewById((R.id.textView16));
        phone.setText(elements[1]);

        Button retour = findViewById(R.id.button3);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DescriptionActivity.this, AdoptionActivity.class);
                startActivity(intent);
            }
        });

    }
}
