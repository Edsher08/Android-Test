package com.example.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "Itemdate.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Itemdetails(name TEXT primary key, unit TEXT, price TEXT, date TEXT, inv TEXT, cost TEXT, image TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Itemdetails");
    }

    public Boolean insertData(String name, String unit, String price, String date, String inv,String cost ){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("unit", unit);
        contentValues.put("price", price);
        contentValues.put("date", date);
        contentValues.put("inv", inv);
        contentValues.put("cost", cost);
        long result = DB.insert("Itemdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateData(String name, String unit, String price, String date, String inv,String cost ){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("unit", unit);
        contentValues.put("price", price);
        contentValues.put("date", date);
        contentValues.put("inv", inv);
        contentValues.put("cost", cost);
        Cursor cursor = DB.rawQuery("Select * from Itemdetails where name = ?",new String[]{name});
        if (cursor.getCount()>0){

        }

        long result = DB.update("Itemdetails",contentValues,"name=?",new String[]{name});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean deleteData(String name){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Itemdetails where name = ?",new String[]{name});
        if (cursor.getCount()>0){

        }
        long result = DB.delete("Itemdetails","name=?",new String[]{name});
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Itemdetails", null);
        return cursor;
    }



}
