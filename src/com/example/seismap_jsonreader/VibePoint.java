package com.example.seismap_jsonreader;

import java.io.IOException;

import android.util.JsonReader;

public class VibePoint extends SourcePoint {
	int drive;		//The drive percentage used at the point, determined at time of activation.
	int numSweeps;	//The number of sweeps performed at a vibe point.
	int lenSweeps;	//The length of a sweep in seconds.
	int lenPause;	//The length of the pause between sweeps.
	
	/*
	 * Constructor to create a VibePoint from a json stream.
	 */
	VibePoint(JsonReader reader) throws IOException {
		/* 
		 * Call the MapPoint constructor to read the Point Name
		 * and coordinates.
		 */
		super(reader);
		
		/*
		 * Read the drive, numSweeps
		 */
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("drive")) {
				drive = reader.nextInt();
			} else if (name.equals("numSweeps")) {
				numSweeps = reader.nextInt();
			} else if (name.equals("lenSweeps")) {
				lenSweeps = reader.nextInt();
			} else if (name.equals("lenPause")) {
				lenPause = reader.nextInt();
			} else {
				return;
			}
		}
	}
/* Only the drive percentage should need to be modified by the user in the field. */
	public void setDrive(int d) { drive = d; }

/* Stadard 'getter' methods for accessing the member data of this class. */
	public int getDrive() { return drive; }
	public int getnumSweeps() { return numSweeps; }
	public int getlenSweeps() { return lenSweeps; }
	public int getlenPause() { return lenPause; }


}
