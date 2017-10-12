package pack1;

public class Child extends Parent{
	void callTest() {
		m1();
		m2();
		m3();
//		m4();  // private는 해당 클래스에서만 사용 가능
	}
}
