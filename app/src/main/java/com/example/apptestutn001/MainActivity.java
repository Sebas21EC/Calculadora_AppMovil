package com.example.apptestutn001;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText result_txt;

    EditText n1_txt;
    EditText n2_txt;

   Spinner operation_sp;

   Button cmdOk;





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

        //start view components
        result_txt = findViewById(R.id.resultado_txt);
        n1_txt = findViewById(R.id.number1_txt);
        n2_txt = findViewById(R.id.number2_txt);
        cmdOk = findViewById(R.id.operacion_btn);
        operation_sp = (Spinner) findViewById(R.id.opciones_cbbox);
        //INICIAR SPINNER
        initSpinner();

    }



    private void initSpinner() {

        //arrary con los operadores
        List operaciones = new ArrayList();
        operaciones.add("+");
        operaciones.add("-");
        operaciones.add("/");
        operaciones.add("*");

        //adaptador para el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, operaciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operation_sp.setAdapter(adapter);

        //CAMBIAR DE COLOR AL BOTON EN TONO ROJO
        cmdOk.setBackgroundColor(getResources().getColor(R.color.red));

    }

    public void cmdOk_OnClick(View view) {

        //tomar los valores y operarlos en base a la opcin escogida

        String n1 = n1_txt.getText().toString();
        String n2 = n2_txt.getText().toString();

        String operacion = operation_sp.getSelectedItem().toString();

        double result = 0;

        try {
            switch (operacion) {
                case "+":
                    result = Double.parseDouble(n1) + Double.parseDouble(n2);
                    break;
                case "-":
                    result = Double.parseDouble(n1) - Double.parseDouble(n2);
                    break;
                case "*":
                    result = Double.parseDouble(n1) * Double.parseDouble(n2);
                    break;
                case "/":
                    result = Double.parseDouble(n1) / Double.parseDouble(n2);
                    break;
            }

            result_txt.setText(String.valueOf(result));
        } catch (Exception e) {
            result_txt.setText("Error en la operacion");

        }




    }

}