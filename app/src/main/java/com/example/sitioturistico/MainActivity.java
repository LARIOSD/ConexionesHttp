package com.example.sitioturistico;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button conetar, listar;
    TextView dato;
    String url = "https://www.datos.gov.co/resource/jj37-fvz6.json";
    //String url = "https://www.datos.gov.co/resource/ajwu-p33t.json";
    ArrayList <Sitios> st = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conetar = findViewById(R.id.btnconectar);
        listar = findViewById(R.id.btnlistado);
        dato = findViewById(R.id.btndato);


        conetar.setOnClickListener(v -> {resquestDatos();});

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ListadoSitios.class);
                i.putParcelableArrayListExtra("sitios", st);
                startActivity(i);
            }
        });

    }
        public void  resquestDatos(){
            RequestQueue cola = Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                   dato.setText(response.toString());
                   parserJson(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),"Error al conectar",Toast.LENGTH_LONG).show();
                }

        });
            cola.add(jsonArrayRequest);
        }

        public void parserJson(JSONArray response){
            //String cadena = "";
            //for (int i = 0; i < response.length(); i++) {
                try {
                    String cadena = "";
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        String nombresitio = jsonObject.getString("nombresitio");
                        String tipo = jsonObject.getString("tipo");
                        String descripcion = jsonObject.getString("descripcion");
                        String nombremunicipio = jsonObject.getString("nombremunicipio");

                        cadena = cadena + tipo + "\n" + nombresitio + "," + nombremunicipio + "\n" + descripcion + "\n\n";
                        Sitios sitio = new Sitios(nombresitio, tipo, descripcion, nombremunicipio);

                        st.add(sitio);

                    }
                    dato.setText(cadena);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

        }

}