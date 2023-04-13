package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DescriptionActivity extends AdoptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView animal = findViewById(R.id.textView10);
        animal.setText(getIntent().getStringExtra("texteListe"));

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
