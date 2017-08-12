package com.swipejobs.utils;


/**
 * Utility class for doing Number calculations
 * @author Girish Jung
 *
 */
public class CommonNumberUtils {
	
	/**
	 * This methods takes two different Locations on the Earth and calculates the distance between them in kilometers.
	 * @param latitude1
	 * @param longitude1
	 * @param latitude2
	 * @param longitude2
	 * @return
	 */
	public static double distanceBetweenTwoLocations(double latitude1, double longitude1, double latitude2, double longitude2) {
		double earthRadius = 6371000; //meters
		double dLat = Math.toRadians(latitude2-latitude1);
		double dLng = Math.toRadians(longitude2-longitude1);
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
				Math.sin(dLng/2) * Math.sin(dLng/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dist = earthRadius * c;
		
		return (dist / 1000);  //kilometeres
	}
	
	
}
