package com.kosta.j0807;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "java";
		String s2 = "JAVA";
		
		if(s1.equals(s2))
			System.out.println("같습니다");
		else
			System.out.println("다릅니다.");
		
		System.out.println("=======================");
		
		if(s1.equalsIgnoreCase(s2))
			System.out.println("문자열 같음");
		else
			System.out.println("문자열 다름");
		
		System.out.println("=======================");
		
		String str = "Java Programming";
		//index =>    0123456789012345
		//                      111111
		System.out.println("문자열 출력 : "+str);                               //문자열 출력
		System.out.println("문자열 길이 : "+str.length());                      //문자열 길이
		System.out.println("대문자 변환 : "+str.toUpperCase());                 //대문자 변환
		System.out.println("소문자 변환 : "+str.toLowerCase());                 //소문자 변환
		System.out.println("문자열 대체 : "+str.replace('a', 'c'));             //문자열 대체
		System.out.println("문자열 대체 : "+str.replaceAll("Java", "자바"));
		System.out.println("문자열 가져오기 : "+str.charAt(2));                  //문자 가져오기
		System.out.println("문자열 인덱스리턴 : "+str.indexOf('P'));              //인덱스 가져오기
		System.out.println("문자열 중복 첫번째 인덱스 : "+str.indexOf('a',1));       //인덱스 1 이후
		System.out.println("문자열 중복 두번째 인덱스 : "+str.indexOf('a',2));       //인덱스 2 이후
		System.out.println("문자열 마지막 인덱스 출력 : "+str.lastIndexOf('a'));
		System.out.println("문자열 부분출력 : "+str.substring(4));               //인덱스 4이후 출력
		System.out.println("문자열 부분출력 : "+str.substring(str.indexOf('a',1)));
		System.out.println("문자열 부분출력 : "+str.substring(str.indexOf('a',2)));
		str="   "+str;
		System.out.println("추가된 문자열 확인 : "+str);
		System.out.println("추가된 문자열 길이 확인 : "+str.length());
		System.out.println("불필요 공백 길이 제거 : "+str.trim().length());
		System.out.println("불필요 공백 제거 : "+str.trim());                     //불필요 공백 제거 (앞 뒤만 제거)
	}

}
