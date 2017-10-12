package pack2;

import pack1.Parent;   //다른 패키지의 클래스를 상속 받기 위해서 import 선언을 해준다.
                       //parent 클래스가 public이 아닐 시 사용 불가

public class Other {
	void callTest() {
		Parent p = new Parent();
		p.m1();   //다른 클래스 및 상속을 받지 않을 경우 public 선언만 사용 가능
//		p.m2();   //protected : 같은 패키지 및 상속 관계만 사용 가능
//		p.m3();   //같은 패키지 내에서 사용 가능
//		p.m4();   //private : 같은 클래스 내에서 사용 가능
	}
}
