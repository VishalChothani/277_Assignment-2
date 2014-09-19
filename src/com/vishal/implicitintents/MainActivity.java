package com.vishal.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button close = (Button) findViewById(R.id.closeButton);
        close.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity.this.finish();
				
			}
		});
        
        
        //String url = "www.google.com";
        
        Button launch = (Button) findViewById(R.id.launchButton);
        launch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText get_url = (EditText) findViewById(R.id.urlEditText);
				String url = get_url.getText().toString();
				if(url.length()!=0)
				{
					Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
					startActivity(intent);
				}
				else
				{
					get_url.setError("Please enter proper URI");
				}
			}
		});
        
        Button ring = (Button) findViewById(R.id.ringButton);
        ring.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText get_number = (EditText) findViewById(R.id.phoneNumberEditText);
				String phone_number = get_number.getText().toString();
				if(phone_number.length()!=10)
				{
					get_number.setError("Please Enter a valid number");
				}
				else
				{
					phone_number = "tel:"+phone_number;
					Intent intent = new Intent(Intent.ACTION_CALL).setData(Uri.parse(phone_number));
					startActivity(intent);
				}
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
