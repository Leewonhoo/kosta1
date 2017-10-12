package com.kosta.j0808;

class D{
	int i=11;
}
class E extends D{
	int j=22;
}
class F extends E{
	int k=33;
}

public class InstanceofTest {
	public static void main(String[] args) {
		//instanceof type => boolean 출력
		D d=new D();
		E e=new E();
		F f=new F();
		
		if(d instanceof D) {
			System.out.println("d는 클래스 D의 객체이다.");
		}else {
			System.out.println("d는 클래스 D의 객체가 아니다.");			
		}
		
		if(d instanceof F) {
			System.out.println("d는 클래스 F의 객체이다.");
		}else {
			System.out.println("d는 클래스 F의 객체가 아니다.");			
		}
		if(f instanceof D) {
			System.out.println("f는 클래스 D의 객체이다.");
		}else {
			System.out.println("f는 클래스 D의 객체가 아니다.");			
		}
		
		int su=25;
		String result = (su%2==0) ? "여성" : "남성" ;
		System.out.println("상항연산자 결과 : "+result);
	}
}
