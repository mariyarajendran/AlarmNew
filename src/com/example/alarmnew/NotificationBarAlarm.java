package com.example.alarmnew;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("SdCardPath")
public class NotificationBarAlarm extends BroadcastReceiver{
	
	
	ArrayList<String> lstid;
	ArrayList<String> porullist;
	 String arrayvalues,porularray;
	 boolean boolean1=true;
	 SharedPreferences preferences;
	 SharedPreferences.Editor editor ;
	 int i;
	 File f;
	 TextView txtkural;
	 SharedPreferences kuralpreference;
	 SharedPreferences.Editor kuraleditor;
	 SharedPreferences kuralporul;
	 SharedPreferences.Editor poruleditor;
	 Resources resources;
	 Resources resporul;
	 Dbforkural dbforkural;
	 Dbforporul dbforporul;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent arg1) {
		
		 Toast.makeText(context, "Alarm Received after 10 seconds.", Toast.LENGTH_SHORT).show();
		 resources=context.getResources();
		 resporul=context.getResources();
			String[] kural = resources.getStringArray(R.array.kurals);
			String[] porul=resporul.getStringArray(R.array.porul);
			dbforkural=new Dbforkural(context);
			dbforporul=new Dbforporul(context);
		
			
			
			        lstid= new ArrayList<String>(Arrays.asList(kural));
			        porullist=new ArrayList<String>(Arrays.asList(porul));
			        Log.i("kurals", "kurals"+lstid.toString());
			        preferences = context.getSharedPreferences("IDS", Context.MODE_PRIVATE);
			        kuralpreference=context.getSharedPreferences("ONEBYONEKURAL",Context.MODE_PRIVATE);
			        kuralporul=context.getSharedPreferences("PORUL", Context.MODE_PRIVATE);
			        
			        
			 		        f = new File(
							"/data/data/com.example.alarmnew/shared_prefs/IDS.xml");
			 		        
			 		        
							if (f.exists()){
								i=preferences.getInt("ids", 0);
								 Log.i("shareddfile", "shareddfile"+i);
								 
								 
								 if(i<lstid.size()){
										
										
											
											arrayvalues=lstid.get(i).toString();
											dbforkural.insert(arrayvalues);
											porularray=porullist.get(i).toString();
											dbforporul.insert(porularray);
											 
												kuraleditor=kuralpreference.edit();
												kuraleditor.remove("kural");
												kuraleditor.clear();
												kuraleditor.commit();
												
												poruleditor=kuralporul.edit();
												poruleditor.remove("porul");
												poruleditor.clear();
												poruleditor.commit();
											 
											 
											 kuraleditor=kuralpreference.edit();
											 kuraleditor.putString("kural", arrayvalues);
											 kuraleditor.commit();
								     		Toast.makeText(context, arrayvalues, Toast.LENGTH_LONG).show();
								     		
								     		
								     		poruleditor=kuralporul.edit();
								     		poruleditor.putString("porul",porularray);
								     		poruleditor.commit();
											
													  
												editor=preferences.edit();
												
													editor.putInt("ids",i+=1);
													 Log.i("incree", "incree"+i);
													
												editor.commit();
												
												 NotificationManager	mNotificationManager = (NotificationManager) context
														.getSystemService(Context.NOTIFICATION_SERVICE);

												Notification notifyDetails = new Notification(R.drawable.ic_launcher,
														"Time Reset!", System.currentTimeMillis());
												Intent i=new Intent(context,Mainnoti.class);
												  i.setAction(Long.toString(System.currentTimeMillis()));

												PendingIntent yIntent = PendingIntent.getActivity(context, 0,
														i,PendingIntent.FLAG_UPDATE_CURRENT);

												notifyDetails.setLatestEventInfo(context, "Time has been Reset",
														"Click on me to view Contacts", yIntent);


												mNotificationManager.notify(9999, notifyDetails);
											
												
											
										}
										
								 
							  }
							else if(!f.exists()){
								
								 i=0;
							
								 if(i<lstid.size()){
									
									  Log.i("kurals", "kurals"+lstid.size());
									 
									
											
											arrayvalues=lstid.get(i).toString();
											dbforkural.insert(arrayvalues);
											porularray=porullist.get(i).toString();
											dbforporul.insert(porularray);
											
											
												kuraleditor=kuralpreference.edit();
												kuraleditor.remove("kural");
												kuraleditor.clear();
												kuraleditor.commit();
												
												
												poruleditor=kuralporul.edit();
												poruleditor.remove("porul");
												poruleditor.clear();
												poruleditor.commit();
											 
											 
											 
											 kuraleditor=kuralpreference.edit();
											 kuraleditor.putString("kural", arrayvalues);
											 kuraleditor.commit();
											Toast.makeText(context, arrayvalues, Toast.LENGTH_LONG).show();
											
											
											poruleditor=kuralporul.edit();
								     		poruleditor.putString("porul",porularray);
								     		poruleditor.commit();
											
											
												editor=preferences.edit();
													
												 Log.i("befoteincree", "beforeincree"+i);
													editor.putInt("ids", i+=1);
													 Log.i("incree", "incree"+i);
													
												editor.commit();
												
												
												 NotificationManager	mNotificationManager = (NotificationManager) context
															.getSystemService(Context.NOTIFICATION_SERVICE);

													Notification notifyDetails = new Notification(R.drawable.ic_launcher,
															"Time Reset!", System.currentTimeMillis());
													Intent i=new Intent(context,Mainnoti.class);
													  i.setAction(Long.toString(System.currentTimeMillis()));
													PendingIntent yIntent = PendingIntent.getActivity(context, 0,
															i, PendingIntent.FLAG_UPDATE_CURRENT);

													notifyDetails.setLatestEventInfo(context, "Time has been Reset",
															"Click on me to view Contacts", yIntent);

													mNotificationManager.notify(9999, notifyDetails);
													
											
										}
			
			
				
				
				
				
		}
							
							
							
							
							
							
							 
							}
	
	
		
		


		 
		 
	}


