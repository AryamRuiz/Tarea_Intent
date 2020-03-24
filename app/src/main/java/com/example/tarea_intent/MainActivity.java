package com.example.tarea_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public clsObjeto objeto = new clsObjeto();
    static boolean primera = true;
    String nombre, apellido, sexo, auxedad, info;
    Integer edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spEdad = (Spinner)findViewById(R.id.spEdad);
        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        final EditText txtApellido = (EditText)findViewById(R.id.txtApellido);
        final TextView txtResultado = (TextView)findViewById(R.id.txtResultado);
        final Button btnEnviar = (Button)findViewById(R.id.btnEnviar);
        final Button btnLimpiar = (Button)findViewById(R.id.btnLimpiar);

        final RadioGroup rgSexos = (RadioGroup) findViewById(R.id.rgSexos);

        if(primera == false) {
            Bundle extras = getIntent().getExtras();
            info = extras.getString("objeto");
            info = info.toUpperCase();
            txtResultado.setText(info);
        }else{
            primera = false;
        }
        //int radio = rgSexos.indexOfChild();

        final List edades = new ArrayList<Integer>();
        for(int i = 0; i<=50; i++)
        {
            edades.add(Integer.toString(i));
        }
        ArrayAdapter<Integer> spinnerArrayAdapter  = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, edades);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEdad.setAdapter(spinnerArrayAdapter);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtiene los valores de los campos.
                nombre = txtNombre.getText().toString();
                apellido = txtApellido.getText().toString();

                int radioButtonID = rgSexos.getCheckedRadioButtonId();
                View radioButton = rgSexos.findViewById(radioButtonID);
                int index = rgSexos.indexOfChild(radioButton);
                RadioButton Aux = (RadioButton) rgSexos.getChildAt(index);

                sexo = Aux.getText().toString();

                auxedad = spEdad.getSelectedItem().toString();
                edad = Integer.parseInt(auxedad);

                //Set los valores al objeto creado.
                objeto.setNombre(nombre);
                objeto.setApellido(apellido);
                objeto.setSexo(sexo);
                objeto.setEdad(edad);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("objeto", objeto);
                startActivity(intent);
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtApellido.setText("");
                rgSexos.clearCheck();
                edad = 0;
            }
        });
    }
}
