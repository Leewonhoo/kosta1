package Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaTest {
	Service s;

	public JavaTest(String[] in) throws IOException {
		s = new Service();
		String input =null;
		int length=0;

		if(in.length==0) {
			length = 5;
		}else {
			length=Integer.parseInt(in[0]);
		}
		
		System.out.println("출력 길이 : "+s.getNumber(length));
		s.printNumber(length);
	}

	public static void main(String[] args) throws IOException {
		new JavaTest(args);
	}
}
