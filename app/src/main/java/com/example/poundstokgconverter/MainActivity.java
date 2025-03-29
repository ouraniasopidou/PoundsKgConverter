package com.example.poundstokgconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText inputPounds;
    TextView outputKg;
    Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Συνδέουμε τα στοιχεία του XML με τα Java αντικείμενα
        inputPounds = findViewById(R.id.inputPounds);
        outputKg = findViewById(R.id.outputKg);
        convertButton = findViewById(R.id.convertButton);

        // Όταν πατιέται το κουμπί
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String poundsStr = inputPounds.getText().toString();

                // Έλεγχος αν είναι κενό
                if (!poundsStr.isEmpty()) {
                    double pounds = Double.parseDouble(poundsStr);
                    double kilograms = pounds * 0.453592; // μετατροπή
                    outputKg.setText(String.format("%.2f", kilograms)); // εμφάνιση
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
