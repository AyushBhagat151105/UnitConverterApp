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
    private Button button;
    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            button = findViewById(R.id.button);
            textView = findViewById(R.id.textView);
            editText = findViewById(R.id.editText);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this, "Hi Click listener works", Toast.LENGTH_SHORT).show();
                    String s = editText.getText().toString();
                    if (s.isEmpty()){
                        Toast.makeText(MainActivity.this, "Enter the value", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        int kg = Integer.parseInt(s);
                        double pound = 2.205 * kg;
                        textView.setText("The curresponding value is Pound is " + pound);
                    }





                }
            });

            return insets;



        });
    }
}