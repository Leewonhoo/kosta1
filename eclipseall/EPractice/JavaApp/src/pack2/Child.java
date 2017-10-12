package pack2;

import pack1.Parent;   //다른 패키지의 클래스를 상속 받기 위해서 import 선언을 해준다.
//parent 클래스가 public이 아닐 시 사용 불가

public class Child extends Parent{
	void callTest() {
		m1();
		m2();   //같은 패키지 또는 상속을 받으면 사용 가능
//		m3();   //같은 패키지 내에서 접근하는 것이 아니기 때문에 에러 발생
//		m4();   //같은 패키지 내에서 접근 및 같은 클래스 내에서의 접근이 아니기 때문에 에러 발생
	}
}
