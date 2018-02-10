package com.example.alarmnew;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Sharelink extends Activity {
String kural,porul,kuralporul;
ImageButton share;
TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sharelink);
		txt=(TextView)findViewById(R.id.txt);
		share=(ImageButton)findViewById(R.id.share);
		
		Intent intent=getIntent();
	kural=intent.getStringExtra("kural");
		porul=intent.getStringExtra("porul");
		
		txt.setText(kural+"\n"+porul);
	kuralporul=	txt.getText().toString();
		
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
