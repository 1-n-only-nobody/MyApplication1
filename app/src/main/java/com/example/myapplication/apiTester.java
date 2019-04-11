package com.example.myapplication;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class apiTester extends AppCompatActivity {
    TextView tv,ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_tester);
        tv = findViewById(R.id.responseText);
        ev = findViewById(R.id.error);
        RequestQueue ExampleRequestQueue = Volley.newRequestQueue(this);
        ExampleRequestQueue.add(ExampleStringRequest);
    }

    String url = "https://api.altmetric.com/v1/doi/10.1016/j.envres.2018.01.035";
    StringRequest ExampleStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Toast.makeText(apiTester.this, "Success", Toast.LENGTH_LONG).show();
            try {
                JSONObject json = new JSONObject(response);
                tv.setText(json.toString());
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
