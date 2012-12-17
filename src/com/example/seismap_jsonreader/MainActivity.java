package com.example.seismap_jsonreader;

import java.io.IOException;
//import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public final static String JSON_STREAM = "com.example.seismap_jsonreader.JSON_STREAM";
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadJSON(View view) {
    	Intent intent = new Intent(this, ParseJsonActivity.class);
    	
    	EditText edittext = (EditText) findViewById(R.id.json_loc);
    	String jsonLoc = edittext.getText().toString();
    	
    	try {
			URL jsonURL = new URL(jsonLoc);
			URLConnection jsonCon = jsonURL.openConnection();
			/*InputStream stream =*/ jsonCon.getInputStream();
		
			//intent.putExtra(JSON_STREAM, stream);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			  //do nothing?
		}
    	
    	
    	intent.putExtra(JSON_STREAM, jsonLoc);
    	startActivity(intent);
    	
    }
    
}
