package com.example.seismap_jsonreader;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class PointParcel implements Parcelable {

	List<ShotPoint> shotPoints;
	List<VibePoint> vibePoints;
	List<RecPoint>	recPoints;
	
	public static final Parcelable.Creator <PointParcel> CREATOR
		= new Parcelable.Creator<PointParcel>() {
		public PointParcel createFromParcel(Parcel in) {
			return new PointParcel(in);
		}

		@Override
		public PointParcel[] newArray(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	PointParcel (List<ShotPoint> s, List<VibePoint> v, List<RecPoint> r) {
		shotPoints = s;
		vibePoints = v;
		recPoints = r;
	}

	public PointParcel(Parcel in) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
