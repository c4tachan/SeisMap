package com.example.seismap_jsonreader;

import java.io.IOException;

import android.util.JsonReader;


public class SourcePoint extends MapPoint {
	/* enum status stores the state of the source point, used to color it */
	public enum state { dormant, activated, pulled }

	public state status;
	
	SourcePoint(JsonReader reader) throws IOException {
		/* 
		 * Call the MapPoint constructor to read the Point Name
		 * and coordinates.
		 */
		super(reader);
		
		/*
		 * Attempt to read the activation status of this point.
		 */
		String stts; //I need to convert the status string to an enum!
		
		while (reader.hasNext()) {
			String name = reader.nextName();
			
			if(name.equals("status")) {
				stts = reader.nextString();
				
				if(stts.equals("dormant")) {
					status = state.dormant;
				} else if (stts.equals("activated")) {
					status = state.activated;
				} else if (stts.equals("pulled")) {
					status = state.pulled;
				}
			} else {
				return;
			}
		}
		
	}

	/* Standard 'getter' methods. */
	public state getstatus()	{ return status;	}
	
}

