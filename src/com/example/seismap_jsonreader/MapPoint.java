package com.example.seismap_jsonreader;

import java.io.IOException;

import android.util.JsonReader;

/*
 * Class MapPoint is the most basic level of abstraction for the
 * various points that will be drawn on the map. Every single
 * possible type of point will need to have some sort of name,
 * and a set of coordinates to place it on the map. Thus, all
 * other types of points will inherit from this class.
 */


public class MapPoint {
	String	id;		//The name of the point.
	int		lat;	//The latitude coordinate of the point.
	int		lng;	//The longitude coordinate of the point.

	MapPoint(JsonReader reader) throws IOException {
		
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if(name.equals("id")) {
				id = reader.nextString();
			} else if(name.equals("lat")) {
				lat = reader.nextInt();
			} else if(name.equals("lng")) {
				lng = reader.nextInt();
			}
		}
		return;
	}
	
	/* Standard 'getter' methods */
	public String getid()	{ return id;	}
	public int getlat()		{ return lat;	}
	public int getlng()		{ return lng;	}
}