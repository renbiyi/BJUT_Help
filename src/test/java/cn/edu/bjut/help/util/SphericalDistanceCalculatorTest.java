package cn.edu.bjut.help.util;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SphericalDistanceCalculatorTest {

	private Logger logger = Logger.getLogger(SphericalDistanceCalculatorTest.class);
	
	@Test
	public void testDistance() {
		double x1, x2;
		double y1, y2;
		
		x1 = x2 = 116.481194;
		y1 = y2 = 39.875532;
		
		double distance = SphericalDistanceCalculator.distance(x1, y1, x2, y2);
		logger.info(distance);
	}
}
