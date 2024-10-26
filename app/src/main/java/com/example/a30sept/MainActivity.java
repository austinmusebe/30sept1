package com.example.a30sept;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText editTextText, editTextText2, editTextText3, editTextText4;
        Button button;

        editTextText=findViewById(R.id.editTxt1);
        editTextText2=findViewById(R.id.editTxt2);
        editTextText3=findViewById(R.id.editTxt3);
        editTextText4=findViewById(R.id.editTxt4);
        button=findViewById(R.id.btnCalculate);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create object for bmi class
                bmi b = new bmi();

                //read values for weight and height

                b.weight = Double.parseDouble(editTextText.getText().toString());
                b.height = Double.parseDouble(editTextText2.getText().toString());
                Double finalBMI = b.calculateBMI(b.weight, b.height);


                editTextText3.setText(finalBMI.toString());
                editTextText4.setText(HealthStatus(finalBMI));

                Toast.makeText(MainActivity.this,"The class worked well", Toast.LENGTH_LONG).show();

            }
        });

    }
    public String HealthStatus(double bmi){
        String health="1.8";

        if (bmi<18.5){
            health="underweight";
        }
        if (bmi>18.6 && bmi<27.0){
            health="healthy";
        }
        if (bmi>27.0){
            health="Obese";
        }

        return health;

    }
}

