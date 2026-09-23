package com.example.lab1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Code for revert

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView displayText = findViewById(R.id.displayText);
        Button changeTextButton = findViewById(R.id.changeTextButton);
        Button changeColourButton = findViewById(R.id.changeColourButton);
        Button changeBackgroundButton = findViewById(R.id.changeBackgroundButton);

        changeTextButton.setOnClickListener(v -> {
            displayText.setText("Changed Text");
        });

        changeColourButton.setOnClickListener(v -> {
            displayText.setTextColor(Color.BLUE);
        });

        changeBackgroundButton.setOnClickListener( v -> {
            findViewById(R.id.main).setBackgroundColor(Color.YELLOW);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}