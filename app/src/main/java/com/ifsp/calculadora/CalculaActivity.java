package com.ifsp.calculadora;

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

public class CalculaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcula);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnVoltar) {
            finish();
        } else if (v.getId() == R.id.btnCalcular) {
            EditText etPeso = findViewById(R.id.etPeso);
            EditText etAltura = findViewById(R.id.etAltura);

            int peso = Integer.parseInt(etPeso.getText().toString());
            int altura = Integer.parseInt(etAltura.getText().toString());


            float alturaEmMetros = altura / 100f;


            float resultado = peso / (alturaEmMetros * alturaEmMetros);


            Toast.makeText(CalculaActivity.this,
                    "O resultado é: " + resultado,
                    Toast.LENGTH_SHORT).show();
        }
    }
}







