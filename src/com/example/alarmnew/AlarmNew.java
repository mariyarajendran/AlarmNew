package com.example.alarmnew;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmNew extends Activity {
	

	
	
	 File f;
	 TextView txtkural;
	 Dbforkural dbforkural;
	 Dbforporul dbforporul;
	 Cursor cursor;
	 
	 ExpandableListView lvExp;
		ExpandableListAdapter listAdapter;
	 List<String> listDataHeader;
	 List<String> fakelistDataHeader;
	 List<String> listchild;
	 String fakelistchild;
	 HashMap<String, String> listDataChild;
	 HashMap<String, String> fakelistDataChild;
	 private PendingIntent pendingIntent;
	@SuppressLint("SdCardPath")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm_new);
		
		dbforkural=new Dbforkural(getApplicationContext());
		dbforporul=new Dbforporul(getApplicationContext());
		lvExp = (ExpandableListView) findViewById(R.id.lvExp);
		
		
		
		fakelistDataHeader=new ArrayList<String>();
		fakelistDataChild=new HashMap<String, String>();
		
		
		
		

		
		
		 listDataHeader = new ArrayList<String>();
		 listchild=new ArrayList<String>();
		 listDataChild = new HashMap<String, String>();
		   f = new File(
					"/data/data/com.example.alarmnew/shared_prefs/IDS.xml");
		   
		  
		   
		   
		if(f.exists()){
		kural();
		porul();
		expand();
		
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		lvExp.setAdapter(listAdapter);}
		
		else{
		
      
		  Intent alarmIntent = new Intent(AlarmNew.this, AlarmReceiver.class);
	        pendingIntent = PendingIntent.getBroadcast(AlarmNew.this, 0, alarmIntent, 0);
	       AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	       manager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
	       Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
	       
		//Intent intent=new Intent(AlarmNew.this,Startpage.class);
		//finish();
		//startActivity(intent);
	       fakelistDataHeader.add("Yo Nav indha header la neenga instruction add pannigonga ya.yo idhu app start agum pothu display agum. oru kural receive anathuk appram idhu display aggarthu ya");
	       fakelistchild="yo indha child la neenga add panikonga ya.idha click pannunga child irrukum.idhula edathavathu add pannikonga ya";
	  	 fakelistDataChild.put(fakelistDataHeader.get(0), fakelistchild);
	 	listAdapter = new ExpandableListAdapter(this, fakelistDataHeader, fakelistDataChild);
	
		lvExp.setAdapter(listAdapter);
		
		}
		
		
		lvExp.setOnChildClickListener(new OnChildClickListener() {
			 
			 @Override
			 public boolean onChildClick(ExpandableListView parent, View v,
			 int groupPosition, int childPosition, long id) {
			 // TODO Auto-generated method stub
			 
			 final String porul = (String) listAdapter.getChild(
			 groupPosition, childPosition);
			 
			 // Switch case to open selected child element activity on child element selection.
			 final String kural = (String) listAdapter.getGroup(groupPosition);
		
			 
			 
			
			 
			  Intent intent=new Intent(AlarmNew.this,Sharelink.class);
			  intent.putExtra("kural", kural);
			  intent.putExtra("porul", porul);
			  startActivity(intent);
			 
			 return true;
			 }
			 });
		
		

	}
		
		

	
	public boolean onChildClick(ExpandableListView arg0, View arg1,
			int groupPosition, int childPosition, long arg4) {
		// TODO Auto-generated method stub
		
		   Toast.makeText(
	                getApplicationContext(),
	               "Hi", Toast.LENGTH_SHORT)
	               .show();
		return false;
	}

	

	
	 public void kural(){
		
		
		 cursor=dbforkural.display();
		 cursor.moveToFirst();
			
		  Log.d("viewcont","startsins1"+cursor);
		  
		 do{
			  if(cursor.isAfterLast()){
				  return;
			  }
			  else{
				    listDataHeader.add(cursor.getString(1));
		   		      cursor.moveToNext();
		  		      Log.d("viewcont","startsins1"+listDataHeader);
		  		   //   Toast.makeText(getApplicationContext(), ""+listDataHeader, Toast.LENGTH_LONG).show();
		  	}
		  }while(true);

		 }
	 
	 public void porul(){
			
			
		 cursor=dbforporul.display();
		 cursor.moveToFirst();
			
		  Log.d("viewcont","startsins1"+cursor);
		  
		 do{
			  if(cursor.isAfterLast()){
				  return;
			  }
			  else{
				    listchild.add(cursor.getString(1));
		   		      cursor.moveToNext();
		  		      Log.d("viewcont","startsins1"+listDataHeader);
		  		   //   Toast.makeText(getApplicationContext(), ""+listchild, Toast.LENGTH_LONG).show();
		  	}
		  }while(true);

		 }
	 
	 public void expand(){
	 for(int i=0;i<listDataHeader.size();i++){
		 
		Log.i("loop", "loop"+listchild.get(i));
		 
		 listDataChild.put(listDataHeader.get(i), listchild.get(i));}
		 
	  
	
	 }
	
		
		
}	