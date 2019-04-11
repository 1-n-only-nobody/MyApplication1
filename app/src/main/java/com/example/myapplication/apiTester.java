package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class apiTester extends AppCompatActivity {
    Context context;
    TextView tv,ev;
    String fact;
    String url = "https://catfact.ninja/facts?limit=10&max_length=150";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_tester);
        tv = findViewById(R.id.responseText);
        ev = findViewById(R.id.error);
        RequestQueue ExampleRequestQueue = Volley.newRequestQueue(this);
        ExampleRequestQueue.add(ExampleStringRequest);
    }

    StringRequest ExampleStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Toast.makeText(apiTester.this, "Success", Toast.LENGTH_LONG).show();
            try {
                JSONObject json = new JSONObject(response);
                JSONArray jarray = json.getJSONArray("data");
                JSONObject object = jarray.getJSONObject(0);
                fact = object.getString("fact");
                tv.setText(fact);
            } catch (JSONException e) {
                Toast.makeText(apiTester.this, "error", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
        @Override
        public void onErrorResponse(VolleyError error) {
            //This code is executed if there is an error.
            ev.setText(error.toString());
            Toast.makeText(apiTester.this, error.toString(), Toast.LENGTH_LONG).show();
        }
    });
}
