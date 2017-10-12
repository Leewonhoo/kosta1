package pack1;

public class Other {
	void callTest() {
		Parent p = new Parent();   //상속을 받지 않을 경우 객체 생성을 해주어야 한다.
		p.m1();
		p.m2();
		p.m3();
	}
}
