package com.example.ejercicios;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etEdad, etSaldo;
    private Button btnRegistrar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etEdad = findViewById(R.id.etEdad);
        etSaldo = findViewById(R.id.etSaldo);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvResultado = findViewById(R.id.tvResultado);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                int edad = Integer.parseInt(etEdad.getText().toString());
                double saldo = Double.parseDouble(etSaldo.getText().toString());

                if (edad < 18) {
                    tvResultado.setText("No se permiten menores de 18 años.");
                } else if (edad >= 30){
                    double descuento = edad >= 30 ? saldo * 0.2 : 0;
                    double saldoFinal = saldo - descuento;
                    tvResultado.setText("Nombre: " + nombre + "\nEdad: " + edad + "\nMayor de 30 plica para descuento del 20%" +"\nSaldo a pagar: $" + saldoFinal);
                } else if (edad >= 25 && edad <=29){
                    double descuento3 = edad >= 25 && edad <=29 ? saldo * 0.1 : 0;
                    double saldoFinal3 = saldo - descuento3;
                    tvResultado.setText("Nombre: " + nombre + "\nEdad: " + edad + "\nEdad entre 25 y 29 aplica para descuento de 10%" +"\nSaldo a pagar: $" + saldoFinal3);
                } else {
                    double descuento2 = edad >= 20 && edad <=24 ? saldo * 0.05 : 0;
                    double saldoFinal2 = saldo - descuento2;
                    tvResultado.setText("Nombre: " + nombre + "\nEdad: " + edad + "\nEdad entre 20 y 24 aplica para descuento de 5%" +"\nSaldo a pagar: $" + saldoFinal2);
                }

            }
        });
    }
}