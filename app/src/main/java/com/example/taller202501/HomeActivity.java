package com.example.taller202501;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
  Button matematicas, fisica, estadistica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
      matematicas = (Button) findViewById(R.id.btnmatematicas);
      fisica = (Button) findViewById(R.id.btnfisica);
      estadistica = (Button) findViewById(R.id.btnestadistica);

      matematicas.setOnClickListener(this);
      fisica.setOnClickListener(this);
      estadistica.setOnClickListener(this);

    }
  @Override
  public void onClick(View view) {
    Intent i;
    if (view.getId()==R.id.btnmatematicas){
      i= new Intent(this, MatematicasActivity.class);
      startActivity(i);
    }else{
      if (view.getId()==R.id.btnfisica){
        Toast.makeText(this, "Actividad fisica", Toast.LENGTH_LONG).show();
      }
      else{
        Toast.makeText(this, "Actividad estadistica", Toast.LENGTH_LONG).show();
      }
    }
  }
}
