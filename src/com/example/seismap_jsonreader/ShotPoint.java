package com.example.seismap_jsonreader;

import java.io.IOException;

import android.util.JsonReader;

public class ShotPoint extends SourcePoint {
	double weight;	//The size of the charge.
	double depth;	//The depth of the charge.
	
	ShotPoint(JsonReader reader) throws IOException {
		/* 
		 * Call the MapPoint constructor to read the Point Name
		 * and coordinates.
		 */
		super(reader);
		
		/*
		 * read the weight and depth of the shot charge.
		 */
		while (reader.hasNext()) {
			String name = reader.nextName();
			
			if (name.equals("weight")) {
				weight = reader.nextDouble();
			} else if (name.equals("depth")) {
				depth = reader.nextDouble();
			} else {
				return;
			}
		}
	}

/* Standard 'getter' methods */
	public double getweight()	{ return weight;	}
	public double getdepth()	{ return depth;		}
}


