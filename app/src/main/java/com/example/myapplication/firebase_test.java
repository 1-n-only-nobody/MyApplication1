package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class firebase_test extends AppCompatActivity {
    EditText name;
    Button push;
    ListView lv;
    DatabaseReference dbr;
    List<String> nameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_test);
        FirebaseApp.initializeApp(this);
        dbr = FirebaseDatabase.getInstance().getReference("Videos");
        name = findViewById(R.id.name);
        push = findViewById(R.id.push);
        lv = findViewById(R.id.lv);
        nameList = new ArrayList<>();
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                addData(Name);
            }
        });
    }

    public void addData(String Name) {

        if(!TextUtils.isEmpty(Name)) {
            String id = dbr.push().getKey();
            passTofb ptf = new passTofb(id,Name);
            dbr.child(id).setValue(ptf);
            Toast.makeText(this, "Data added!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Enter something....", Toast.LENGTH_SHORT).show();

    }

    protected  void onStart() {
        super.onStart();
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nameList.clear();
                for(DataSnapshot nameSnapshot : dataSnapshot.getChildren()) {
                    passTofb ptf = nameSnapshot.getValue(passTofb.class);
                    nameList.add(ptf.getName());
                }
                String[] nameListA = new String[nameList.size()];
                nameListA = nameList.toArray(nameListA);
                ArrayAdapter adapter = new ArrayAdapter(firebase_test.this,android.R.layout.simple_list_item_1,nameListA);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
