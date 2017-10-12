package work.util;

import java.util.Random;

public class Utility {
	// 아규먼트로 전달받은 길이만큼 영문대문자 문자열
	public static String getSecureAlphaString(int length) {
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		StringBuilder data = new StringBuilder();
		for (int index=0; index < length; index++) {
			data.append((char)(random.nextInt(26) + 65));
		}
		
		return data.toString();
	}	
	
	// 기본 4자리 길이만큼 영문대문자 문자열
	public static String getSecureAlphaString() {
		return getSecureAlphaString(4);
	}
	
	// 아규먼트로 전달받은 길이만큼 숫자형식의 문자열
	public static String getSecureNumberString(int length) {
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		StringBuilder data = new StringBuilder();
		for (int index=0; index < length; index++) {
			//data.append(random.nextInt(10));  // "0345", 345
			data.append(random.nextInt(10) + 1);  // "0345" => "1456", 1456 => 0을 사용하지 않음 
		}
		
		return data.toString();
	}
	
	// 기본 4자리 숫자형식의 문자열
	public static String getSecureNumberString() {
		return getSecureNumberString(4);
	}
	
	// 기본 4자리 숫자 반환
	public static int getSecureNumber() {
		return Integer.parseInt(getSecureNumberString());
	}
	
	// 아규먼트로 전달받은 자리의 숫자 반환
	public static long getSecureNumber(int length) {
		return Long.parseLong(getSecureNumberString(length));
	}
	
	public static void main(String[] args) {
		System.out.println(Utility.getSecureNumberString());
		System.out.println(Utility.getSecureNumberString(6));
		System.out.println(Utility.getSecureNumberString(8));
		System.out.println(Utility.getSecureNumberString(10));
		
		System.out.println(Utility.getSecureAlphaString());
		System.out.println(Utility.getSecureAlphaString(6));
		System.out.println(Utility.getSecureAlphaString(8));
		System.out.println(Utility.getSecureAlphaString(10));
		
		System.out.println(Utility.getSecureNumber() + 100);
		System.out.println(Utility.getSecureNumber(6) + 100);
		System.out.println(Utility.getSecureNumber(8));
		System.out.println(Utility.getSecureNumber(10));
	}
}
