package cn.edu.bjut.help.util;

public class SphericalDistanceCalculator {

	private final static double RADUIS = 6378.127;
	
	public static double distance(double x1, double y1, double x2, double y2) {
		double distance = RADUIS * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
		return distance;
	}
}
