package com.example.sitioturistico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoSitios extends AppCompatActivity {
    ArrayList <Sitios> st = new ArrayList<>();
    ListView listado;
    EditText busqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_sitios);
        listado = findViewById(R.id.listado);
        busqueda = findViewById(R.id.busqueda);
        Intent i = getIntent();
        st = i.getParcelableArrayListExtra("sitios");

        if (st!=null && st.size()>0){
            SitioAdapter adapter = new SitioAdapter(this, st);
            listado.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            busqueda.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        else{
            Toast.makeText(this,"No hay datos" , Toast.LENGTH_LONG).show();
        }

    }
}