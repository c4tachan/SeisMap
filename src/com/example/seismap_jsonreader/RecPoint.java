package com.example.seismap_jsonreader;

import java.io.IOException;

import android.util.JsonReader;

public class RecPoint extends MapPoint {
	/* 
	 * enum status stores the state of the reciever point.
	 * this is used to color it and to help display source
	 * points that are available for activation on the spread.
	 */
	public enum state { laidout, cleared, unlaid }
	public state status;
	
	RecPoint(JsonReader reader) throws IOException {
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
			if (name.equals("status")) {
				stts = reader.nextString();
				if (stts.equals("laidout")) {
					status = state.laidout;
				} else if (stts.equals("cleared")) {
					status = state.cleared;
				} else if (stts.equals("unlaid")) {
					status = state.unlaid;
				}
			} else {
				return;
			}
		}
	}
	
/* Standard 'getter' methods. */
	public state getstatus()	{ return status;	}
	
}
