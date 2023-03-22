package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements reyclerViewInterface{

    RecyclerView recyclerView;
    ArrayList<String> name, unit, price, date, inv, cost;
    DBHelper dbHelper;
    itemAdapter adapter;

    Button button,add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new DBHelper(this);
        name = new ArrayList<>();
        unit = new ArrayList<>();
        price = new ArrayList<>();
        date = new ArrayList<>();
        inv = new ArrayList<>();
        cost = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new itemAdapter(this, name, unit, price, date, inv, cost);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        add = findViewById(R.id.addButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, addItem.class));
            }
        });

    }


    private void displayData() {

        Cursor cursor = dbHelper.getData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No item exists", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                unit.add(cursor.getString(1));
                price.add(cursor.getString(2));
                date.add(cursor.getString(3));
                inv.add(cursor.getString(4));
                cost.add(cursor.getString(5));

            }
        }

    }

    @Override
    public void onItemClick(int position) {

    }
}