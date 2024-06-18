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
        planets.add(new Planet(getString(R.string.mercurio), getString(R.string.mercurio_description), R.drawable.mercurio));
        planets.add(new Planet(getString(R.string.venus), getString(R.string.venus_description), R.drawable.venus));
        planets.add(new Planet(getString(R.string.tierra), getString(R.string.tierra_description), R.drawable.tierra));
        planets.add(new Planet(getString(R.string.marte), getString(R.string.marte_description), R.drawable.marte));
        planets.add(new Planet(getString(R.string.jupiter), getString(R.string.jupiter_description), R.drawable.jupiter));
        planets.add(new Planet(getString(R.string.saturno), getString(R.string.saturno_description), R.drawable.saturno));
        planets.add(new Planet(getString(R.string.urano), getString(R.string.urano_description), R.drawable.urano));
        planets.add(new Planet(getString(R.string.neptuno), getString(R.string.neptuno_description), R.drawable.neptuno));

        ArrayAdapter<Planet> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, planets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);

        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Planet selectedPlanet = (Planet) parent.getItemAtPosition(position);
                planetDescription.setText(selectedPlanet.getDescription());
                planetImage.setImageResource(selectedPlanet.getImageResourceId());
                Toast.makeText(MainActivity.this, getString(R.string.planet_selected, selectedPlanet.getName()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                planetDescription.setText("");
                planetImage.setImageDrawable(null);
            }
        });
    }
}

