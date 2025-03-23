package com.example.application1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    Button button2;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        text = findViewById(R.id.textView);



        // Récupération du bouton
        button2 = findViewById(R.id.button2);
        button2.setText(R.string.button2);


        // Récupération du texte
        String reception = getIntent().getStringExtra("text_key");


        // Utilisation de la chaîne localisée pour afficher "Texte reçu : " (ou "Text received :") selon la langue
        String receivedText = getString(R.string.text) + reception;

        text.setText(receivedText); // Affichage du texte dans le TextView

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Création de l'Intent pour ouvrir SecondActivity
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent); // Lancement de la nouvelle activité
            }
        });






    }
}