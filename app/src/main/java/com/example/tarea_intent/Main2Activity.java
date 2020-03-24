package com.example.tarea_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public clsObjeto newobj = new clsObjeto();
    String nombre, apellido, sexo;
    Integer edad;
    String info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button btnVolver = (Button)findViewById(R.id.btnVolver);
        final TextView txtRespuestaAct = (TextView)findViewById(R.id.txtRespuestaAct);

        newobj = (clsObjeto)getIntent().getExtras().getParcelable("objeto");
        nombre = newobj.getNombre();
        apellido = newobj.getApellido();
        sexo = newobj.getSexo();
        edad = newobj.getEdad();
        txtRespuestaAct.setText(newobj.getInfo());

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                String iNombre= txtRespuestaAct.getText().toString();
                intent.putExtra("objeto",iNombre);
                startActivity(intent);
            }
        });
    }
}
