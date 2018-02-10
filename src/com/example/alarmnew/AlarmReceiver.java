package com.example.alarmnew;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent arg1) {
		
		Toast.makeText(context, "Alarm Receiver.", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(context, Startservice.class);
		context.startService(intent);
	}
	
	

}


