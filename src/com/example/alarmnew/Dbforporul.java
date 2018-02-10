package com.example.alarmnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbforporul extends SQLiteOpenHelper {
	  SQLiteDatabase db;
	public Dbforporul(Context context) {
		super(context, "DBPORUL", null, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	
		try {
			
	        db.execSQL("CREATE TABLE PORUL(ID INTEGER PRIMARY KEY AUTOINCREMENT,PORULLIST TEXT );");
	      } catch (SQLException e) {
	    	 
	        e.printStackTrace();
	      }
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public void insert(String porul){
		SQLiteDatabase db=getWritableDatabase();
	
	ContentValues	 contentValues=new ContentValues();
		contentValues.put("PORULLIST", porul);
	
		db.insert("PORUL", null, contentValues);
	}
	
	
	public Cursor display(){
		
		SQLiteDatabase sql=this.getWritableDatabase();
		  Cursor c;
	    String query = "SELECT * FROM PORUL";

	  c = sql.rawQuery(query, null);
	    
	   return c;
		
	}

}
