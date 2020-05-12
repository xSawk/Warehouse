package com.example.warehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityAddProduct extends AppCompatActivity {

EditText name,amount;
Button insert;
DatabaseReference reff;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        name = (EditText) findViewById(R.id.editText4);
        amount = (EditText) findViewById(R.id.editText5);
        insert = (Button) findViewById(R.id.button4);
        final Product product = new Product();
        reff=FirebaseDatabase.getInstance().getReference().child("Product");

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwa=name.getText().toString();
                int ilosc=Integer.parseInt(amount.getText().toString());

                product.setAmount(ilosc);
                product.setName(nazwa);
                reff.push().setValue(product);
                Toast.makeText(ActivityAddProduct.this,"Inserted",Toast.LENGTH_LONG).show();
            }
        });



    }







}