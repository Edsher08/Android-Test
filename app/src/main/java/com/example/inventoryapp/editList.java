package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class editList extends AppCompatActivity {
    EditText name, unit, price, date, inventory ;
    TextView cost;
    Button save, delete, back;
    ImageView image;
    DBHelper DB;
    SQLiteDatabase sqLiteDatabase;
    itemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_list);
        getSupportActionBar().hide();

        name = findViewById(R.id.etName);
        unit = findViewById(R.id.etUnit);
        price = findViewById(R.id.etPrice);
        date = findViewById(R.id.etDate);
        inventory = findViewById(R.id.etInv);
        cost = findViewById(R.id.etCost);
        image = findViewById(R.id.etImage);
        save = findViewById(R.id.ebtnSave);
        delete = findViewById(R.id.btnDelete);
        back = findViewById(R.id.ebtnBack);



        DB = new DBHelper(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(editList.this, MainActivity.class));

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameTxt = name.getText().toString();
                String unitTxt = unit.getText().toString();
                String priceTxt = price.getText().toString();
                String dateTxt = date.getText().toString();
                String inventoryTxt = inventory.getText().toString();

                String costTxt = cost.getText().toString();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.id.image);

                Boolean checkUpdateData = DB.updateData(nameTxt,unitTxt,priceTxt,dateTxt,inventoryTxt,costTxt);
                if (checkUpdateData==true){
                    Toast.makeText(editList.this, "Item Updated", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(editList.this, "Item not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.id.image);

                Boolean checkDeleteData = DB.deleteData(nameTxt);
                if (checkDeleteData==true){
                    Toast.makeText(editList.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(editList.this, "Item not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent = getIntent();
        String sName = intent.getExtras().getString("name");
        String sUnit = intent.getExtras().getString("unit");
        String sPrice = intent.getExtras().getString("price");
        String sDate = intent.getExtras().getString("date");
        String sInv  = intent.getExtras().getString("inv");
        String sCost = intent.getExtras().getString("cost");

        name.setText(sName);
        unit.setText(sUnit);
        price.setText(sPrice);
        date.setText(sDate);
        inventory.setText(sInv);
        cost.setText(sCost);
        calculate();

    }
    public void calculate(){
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (price.getText().toString().equals("") && inventory.getText().toString().equals("")) {
                    int temp1 = Integer.parseInt(price.getText().toString());
                    int temp2 = Integer.parseInt(inventory.getText().toString());
                    cost.setText(String.valueOf(temp1 * temp2));
                }else{
                    int temp1 = Integer.parseInt(price.getText().toString());
                    int temp2 = Integer.parseInt(inventory.getText().toString());
                    cost.setText(String.valueOf(temp1 * temp2));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        price.addTextChangedListener(textWatcher);
        inventory.addTextChangedListener(textWatcher);
    }
}