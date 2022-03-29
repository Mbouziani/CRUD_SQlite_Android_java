package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class Db_healpear extends SQLiteOpenHelper {

    public static String  database = "Database.db";
    public static String  tablenam = "user";
    public static String  Nam = "nam";
    public static String  Age = "age";


    public Db_healpear(Context context)
    {
        super(context,database,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create Table user (nam Text primary key ,age NUMBER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists user");
    }

    public void insertdata(String nam , String age)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(Nam,nam);
        CV.put(Age,age);
        db.insert(tablenam,null,CV);
        db.close();
    }
     public void update(String nam , String age)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(Age,age);
        db.update(tablenam,CV, Nam =nam,null);
        db.close();
    }



    public Cursor readData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor CU = db.rawQuery("SELECT * From "+tablenam,null);
        return CU;
    }

    public void Delete (String nam)
    {
        SQLiteDatabase db = getWritableDatabase();
         db.delete(tablenam ,"nam='"+nam+"'",null);
         db.close();
    }


}
