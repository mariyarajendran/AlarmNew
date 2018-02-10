package com.example.alarmnew;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Mainnoti extends Activity {
TextView textview1;
SharedPreferences kuralpreference;
ImageButton share;

String kural,porul,kuralporul;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainnoti);
		textview1=(TextView)findViewById(R.id.textView1);
		share=(ImageButton)findViewById(R.id.share);
		
		
		kuralpreference=getApplicationContext().getSharedPreferences("ONEBYONEKURAL", 0);
				kural=kuralpreference.getString("kural", null);
				kuralpreference=getApplicationContext().getSharedPreferences("PORUL",0);
		porul=kuralpreference.getString("porul", null);
				textview1.setText(kural+"\n"+porul);
			kuralporul=	textview1.getText().toString();
				
				share.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						 Intent sendIntent = new Intent();
					        sendIntent.setAction(Intent.ACTION_SEND);
					        sendIntent.putExtra(Intent.EXTRA_TEXT, kuralporul);
					        sendIntent.setType("text/plain");
					        startActivity(sendIntent);
					}
				});
				
		
	}

	

}
