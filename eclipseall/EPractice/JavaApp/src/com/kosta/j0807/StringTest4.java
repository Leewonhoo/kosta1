package com.kosta.j0807;

public class StringTest4 {
	public static void main(String[] args) {
		//외부 데이터에 대한 유효성 검사
		String str = args[0];
		
		int su1 = Integer.parseInt(args[0]);
		int su2 = 100;
		
		String suPattern = "[0-9]+";
		
		System.out.println(su1+su2);
		System.out.println(str.matches(suPattern));   //str.matches(String regex);   //regex 패턴 정의
		
		if(str.matches(suPattern)) {
			System.out.println(su1+su2);
		}else {
			System.out.println("잘못 입력");
		}
		
		System.out.println("==================");
		String juminP = "[\\d]{6}-[\\d]{7}";      //[0-9]{6}-[0-9]{7} 와 같다.
		String jumin = "930212-1542312";
		System.out.println("주민번호 검사 : "+jumin.matches(juminP));
	}
}
