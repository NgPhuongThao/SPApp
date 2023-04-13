package com.example.spapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        String[] elements = intent.split("-");

        TextView nomAnimal = findViewById(R.id.textView10);
        nomAnimal.setText(elements[0]);

        TextView animal = findViewById(R.id.textView12);
        animal.setText(elements[1]);

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
                String result = elements[0].substring(0, elements[0].length() - 1);
                returnIntent.putExtra("result", result);
                setResult(DescriptionActivity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
