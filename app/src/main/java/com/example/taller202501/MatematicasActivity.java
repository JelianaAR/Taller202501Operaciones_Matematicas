package com.example.taller202501;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MatematicasActivity extends AppCompatActivity implements View.OnClickListener {
  EditText numeroUno, numeroDos;
  Button suma, resta, division, multiplicacion, modulo, potencia;
  TextView resultado;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_matematicas);
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      return insets;
    });

    numeroUno = findViewById(R.id.numero1);
    numeroDos = findViewById(R.id.numero2);
    resultado = findViewById(R.id.resultado);
    suma = findViewById(R.id.btnsuma);
    resta = findViewById(R.id.btnresta);
    multiplicacion = findViewById(R.id.btnmultiplicacion);
    division = findViewById(R.id.btndivision);
    modulo = findViewById(R.id.btnmodulo);
    potencia = findViewById(R.id.btnpotencia);

    suma.setOnClickListener(this);
    resta.setOnClickListener(this);
    multiplicacion.setOnClickListener(this);
    division.setOnClickListener(this);
    modulo.setOnClickListener(this);
    potencia.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    if (numeroUno.getText().toString().isEmpty() || numeroDos.getText().toString().isEmpty()) {
      resultado.setText("Completa los campos");
      return;
    }
    int num1 = Integer.parseInt(numeroUno.getText().toString());
    int num2 = Integer.parseInt(numeroDos.getText().toString());
    if (view.getId() == R.id.btnsuma) {
      resultado.setText(String.valueOf(suma(num1, num2)));
    } else if (view.getId() == R.id.btnresta) {
      resultado.setText(String.valueOf(resta(num1, num2)));
    } else if (view.getId() == R.id.btnmultiplicacion) {
      resultado.setText(String.valueOf(multiplicacion(num1, num2)));
    } else if (view.getId() == R.id.btndivision) {
      if (num2 == 0) {
        resultado.setText("No es posible dividir por 0");
      } else {
        resultado.setText(String.valueOf(division(num1, num2)));
      }
    } else if (view.getId() == R.id.btnmodulo) {
      if (num2 == 0) {
        resultado.setText("No es posible dividir por 0");
      } else {
        resultado.setText(String.valueOf(modulo(num1, num2)));
      }
    } else if (view.getId() == R.id.btnpotencia) {
      resultado.setText(String.valueOf(potencia(num1, num2)));
    }
  }
  public int suma(int a, int b) {
    return a+b;
  }
  public int resta(int a, int b) {
    return a-b;
  }
  public int multiplicacion(int a, int b) {
    return a*b;
  }
  public float division(int a, int b) {
    return (float) a/b;
  }
  public int modulo(int a, int b) {
    return a%b;
  }
  public int potencia(int base, int exponente) {
    return (int) Math.pow(base, exponente);
  }
}




