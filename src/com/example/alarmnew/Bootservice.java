package com.example.alarmnew;

import java.io.File;
import java.util.Calendar;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.widget.Toast;

public class Bootservice extends Service{
	SharedPreferences preferences;
	Editor editor;
	 File f;
	 String sharedday,  currentday;
	 
	
	
@SuppressLint({ "SdCardPath", "SimpleDateFormat" })
@Override
public void onStart(Intent intent, int startid) {
	
			Intent i = new Intent(Bootservice.this, NotificationBarAlarm.class);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(Bootservice.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
	            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
	            Calendar firingCal= Calendar.getInstance();
	            firingCal.set(Calendar.HOUR_OF_DAY, 5); 
	            firingCal.set(Calendar.MINUTE, 0); 
	            firingCal.set(Calendar.SECOND, 0); 
	            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, firingCal.getTimeInMillis(), 24*60*60*1000, pendingIntent);
	            Toast.makeText(Bootservice.this,"Alarm Started",Toast.LENGTH_LONG).show();
	        
	
}
	

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
