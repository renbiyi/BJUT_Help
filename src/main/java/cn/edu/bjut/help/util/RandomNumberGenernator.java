package cn.edu.bjut.help.util;

import java.util.Date;
import java.util.Random;

public class RandomNumberGenernator {

	public static String next() {
		Long timestamp = new Date().getTime();
		int random = new Random().nextInt(5);
		StringBuilder filename = new StringBuilder();
		filename.append(timestamp).append(random);
		return filename.toString();
	}
}
