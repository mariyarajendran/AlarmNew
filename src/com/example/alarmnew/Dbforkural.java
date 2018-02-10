package com.example.alarmnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbforkural extends SQLiteOpenHelper{
	  SQLiteDatabase db;
	public Dbforkural(Context context) {
		super(context, "DBKURAL", null, 2);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		
		try {
					
	        db.execSQL("CREATE TABLE KURAL(ID INTEGER PRIMARY KEY AUTOINCREMENT,KURALLIST TEXT );");
	      } catch (SQLException e) {
	    	 
	        e.printStackTrace();
	      }
	
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
		
	}

	
	public void insert(String kural){
		SQLiteDatabase db=getWritableDatabase();
	
	ContentValues	 contentValues=new ContentValues();
		contentValues.put("KURALLIST", kural);
	
		db.insert("KURAL", null, contentValues);
	}
	
	
public Cursor display(){
		
	SQLiteDatabase sql=this.getWritableDatabase();
	  Cursor c;
  String query = "SELECT * FROM KURAL";

c = sql.rawQuery(query, null);
  
 return c;
	
	}
	
}
