package com.example.alarmnew;

import java.util.Calendar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Startservice extends Service{

	private static final String TAG = "MyService";
	
	@Override
	public void onStart(Intent intent, int startid) {
		
		Intent i = new Intent(Startservice.this, NotificationBarAlarm.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(Startservice.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Calendar firingCal= Calendar.getInstance();
            firingCal.set(Calendar.HOUR_OF_DAY, 7); 
            firingCal.set(Calendar.MINUTE, 0); 
            firingCal.set(Calendar.SECOND, 0);

            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, firingCal.getTimeInMillis(), 24*60*60*1000, pendingIntent);
          Toast.makeText(Startservice.this,"Alarm Started" ,
                    Toast.LENGTH_LONG).show();
          
         
	}
	

	@Override
	public IBinder onBind(Intent intent) {
	return null;
	}

	@Override
	public void onDestroy() {
	Toast.makeText(this, "My Service stopped", Toast.LENGTH_LONG).show();
	Log.d(TAG, "onDestroy");
	}


}
