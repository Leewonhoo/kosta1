package Test2;

public class Service {
	
	void printNumber(int length) {
		for(int i=0; i<length; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	
	String getNumber(int length) {
		String result = String.valueOf(length);
		return result;
	}
}
