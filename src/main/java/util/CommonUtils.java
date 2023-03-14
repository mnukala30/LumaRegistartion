package util;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;

public class CommonUtils {
	
	public static String randomString(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	public static String randomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	public static String randomEmail() {
		return "aqa_automation"+randomString(3).toLowerCase() + "@gmail.com";
	}
	public static String randomName(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
		

}
