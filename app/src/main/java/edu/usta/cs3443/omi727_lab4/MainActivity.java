package edu.usta.cs3443.omi727_lab4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

import edu.usta.cs3443.omi727_lab4.model.Fleet;

/**
 * @author Alistair Chambers (omi727)
 * UTSA CS 3443 - Lab 4
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Context context = this;
        Button b1, b2, b3;
        b1 = findViewById(R.id.button2);
        b1.setText("USS Enterprise \n NCC-1701-A");
        b2 = findViewById(R.id.button3);
        b2.setText("USS Enterprise \n NCC-1701-D");
        b3 = findViewById(R.id.button4);
        b3.setText("USS Enterprise \n NCC-74656");
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        b1.setOnClickListener(v ->
        {
            try {
                Fleet f1 = new Fleet("fleet");
                f1.loadStarships("personnel.csv","fleet.csv",context);
                Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
                intent.putExtra("starship", "NCC-1701-A");
                startActivity(intent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        b2.setOnClickListener(view -> {
                    Fleet f2 = new Fleet("fleet.csv");
                    try {
                        f2.loadStarships("personnel.csv","fleet.csv",context);
                        Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
                        intent.putExtra("starship", "NCC-1701-D");
                        startActivity(intent);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        b3.setOnClickListener(view -> {
                    Fleet f3 = new Fleet("fleet.csv");
                    try {
                        f3.loadStarships("personnel.csv","fleet.csv",context);
                        Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
                        intent.putExtra("starship", "NCC-74656");
                        startActivity(intent);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}