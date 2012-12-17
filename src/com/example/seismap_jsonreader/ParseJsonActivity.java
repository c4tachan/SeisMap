package com.example.seismap_jsonreader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Menu;

public class ParseJsonActivity extends Activity {

	public final static String MAP_POINTS = "com.example.seismap_jsonreader.MAP_POINTS";
	
	private PointParcel allPoints;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parse_json);
		Intent intent = getIntent();
		String jsonLoc = intent.getStringExtra(MainActivity.JSON_STREAM);
		InputStream stream = null;    	
    	try {
			URL jsonURL = new URL(jsonLoc);
			URLConnection jsonCon = jsonURL.openConnection();
			stream = jsonCon.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			  //do nothing?
			System.out.println("Accessed the URL requested!");
		}
		
		try {
			allPoints = parseJSON(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_parse_json, menu);
		return true;
	}

	@Override
	public void onResume() {
		
		Intent intent = new Intent(this, DisplayPoints.class);
		 
		intent.putExtra(MAP_POINTS, allPoints);
		startActivity(intent);
	}
	
	public PointParcel parseJSON(InputStream strm) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(strm, "utf-8"));
		try {
			return readPointsBundle(reader);
		} finally{
				reader.close();
		
		}
	}
	
	public PointParcel readPointsBundle(JsonReader reader) throws IOException {
		List<VibePoint> VibePoints = new ArrayList<VibePoint>();
		List<ShotPoint> ShotPoints = new ArrayList<ShotPoint>();
		List<RecPoint> RcvrPoints = new ArrayList<RecPoint>();
		
		PointParcel points;
		
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if(name.equals("vibe")) {
				VibePoints.add(new VibePoint(reader));
			} else if (name.equals("shot")) {
				ShotPoints.add(new ShotPoint(reader));
			} else if (name.equals("rcvr")) {
				RcvrPoints.add(new RecPoint(reader));
			} else {
				reader.skipValue();
			}
		}
		
//		points.add(VibePoints);
//		points.add(ShotPoints);
//		points.add(RcvrPoints);
//		
		points = new PointParcel(ShotPoints, VibePoints, RcvrPoints);
		reader.endObject();
		return points;
	}
	
	
	

}
