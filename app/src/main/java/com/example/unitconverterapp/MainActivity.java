package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button B1,Reset;
    TextView textView;
    EditText editText;

//    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            B1 = findViewById(R.id.B1);
            textView = findViewById(R.id.textView);
            editText = findViewById(R.id.editText);
            Reset = findViewById(R.id.Reset);

            B1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this, "Hi Click listener works", Toast.LENGTH_SHORT).show();
                    String s = editText.getText().toString();
                    if (s.isEmpty()){
                        Toast.makeText(MainActivity.this, "Enter the value", Toast.LENGTH_SHORT).show();

                    }else {
                        int kg = Integer.parseInt(s);
                        double pound = 2.205 * kg;
                        textView.setText("The curresponding value is Pound is " + pound);
                    }
                }

            });

            Reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Reseted", Toast.LENGTH_SHORT).show();
                    textView.setText(" ");
                    editText.setText(" ");
                }

            });

            return insets;


        });
    }
}