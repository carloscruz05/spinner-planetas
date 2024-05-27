package com.example.lista_de_planetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner planetSpinner;
    TextView planetDescription;
    ImageView planetImage;

    private List<Planet> planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetSpinner = findViewById(R.id.planet_spinner);
        planetDescription = findViewById(R.id.planet_description);
        planetImage = findViewById(R.id.planet_image);


        planets = new ArrayList<>();
        planets.add(new Planet("Mercurio", "Mercurio es el planeta más pequeño del Sistema Solar y el más cercano al Sol.", R.drawable.mercurio));
        planets.add(new Planet("Venus", "Venus es el segundo planeta desde el Sol. Lleva el nombre de la diosa romana del amor y la belleza.", R.drawable.venus));
        planets.add(new Planet("Tierra", "La Tierra es el tercer planeta desde el Sol y el único objeto astronómico conocido que alberga vida.", R.drawable.tierra));
        planets.add(new Planet("Marte", "Marte es el cuarto planeta desde el Sol y el segundo más pequeño del Sistema Solar.", R.drawable.marte));
        planets.add(new Planet("Júpiter", "Júpiter es el planeta más grande del Sistema Solar y el quinto desde el Sol.", R.drawable.jupiter));
        planets.add(new Planet("Saturno", "Saturno es el sexto planeta desde el Sol y el segundo más grande del Sistema Solar, después de Júpiter.", R.drawable.saturno));
        planets.add(new Planet("Urano", "Urano es el séptimo planeta desde el Sol. Tiene el tercer diámetro planetario más grande y la cuarta masa planetaria más grande del Sistema Solar.", R.drawable.urano));
        planets.add(new Planet("Neptuno", "Neptuno es el octavo y más lejano planeta conocido del Sistema Solar desde el Sol.", R.drawable.neptuno));


        ArrayAdapter<Planet> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, planets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);

        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planet selectedPlanet = (Planet) parent.getItemAtPosition(position);
                planetDescription.setText(selectedPlanet.getDescription());
                planetImage.setImageResource(selectedPlanet.getImageResourceId());
                Toast.makeText(MainActivity.this, "Planeta seleccionado: " + selectedPlanet.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                planetDescription.setText("");
                planetImage.setImageDrawable(null);
            }
        });


      
    }
}

