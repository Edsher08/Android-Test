package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class addItem extends AppCompatActivity {

    EditText name, unit, price, date, inventory ;
    TextView cost;
    Button save, delete, back;
    ImageView image;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        name = findViewById(R.id.atName);
        unit = findViewById(R.id.atUnit);
        price = (EditText) findViewById(R.id.atPrice);
        date = findViewById(R.id.atDate);
        inventory = (EditText)findViewById(R.id.atInv);
        cost = (TextView) findViewById(R.id.atCost);
        image = findViewById(R.id.atImage);
        save = findViewById(R.id.abtnSave);
        delete = findViewById(R.id.btnDelete);
        back = findViewById(R.id.abtnBack);

        calculate();


        DB = new DBHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTxt = name.getText().toString();
                String unitTxt = unit.getText().toString();
                String priceTxt = price.getText().toString();
                String dateTxt = date.getText().toString();
                String inventoryTxt = inventory.getText().toString();
                //calculate();
                String costTxt = cost.getText().toString();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.id.image);


                Boolean checkInsertData = DB.insertData(nameTxt,unitTxt,priceTxt,dateTxt,inventoryTxt,costTxt);
                if (checkInsertData==true){
                    Toast.makeText(addItem.this, "New Item Inserted", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(addItem.this, "New Item not Inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(addItem.this, MainActivity.class));

            }
        });
    }
    public void calculate(){

        int cost1, price1, inv1;
        String priceS, costS, invS;

        //priceS = price.getText().toString();
        //invS = inventory.getText().toString();
        //price1 = Integer.parseInt(priceS);
        //inv1 = Integer.parseInt(invS);

        //cost1 = price1 * inv1;
        //cost.setText(cost1);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!price.getText().toString().equals("") && !inventory.getText().toString().equals("")) {
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