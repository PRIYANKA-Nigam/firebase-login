package com.example.newstoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b;
    private FirebaseFirestore  db=FirebaseFirestore.getInstance();@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editTextTextPersonName2);
        e2=(EditText)findViewById(R.id.editTextNumberPassword2);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String pass=e2.getText().toString();
                    Map<String, Object> n = new HashMap<>();
                    n.put("user", name);
                    n.put("pass", pass);
                    db.collection("student").document("the notes").set(n)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {@Override
                                public void onSuccess(Void aVoid) { if (e1.getText().toString().equals("oilindia") && e2.getText().toString().equals("12345")) {
                                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "wrong login credentials", Toast.LENGTH_SHORT).show();
                                } }
                            })
                            .addOnFailureListener(new OnFailureListener() { @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this, "data not stored", Toast.LENGTH_SHORT).show(); }}); }



        });

    }
}