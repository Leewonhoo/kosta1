package study;

public class Parent {
	int p1;
	String p2;
	
	public Parent() {
		System.out.println("parent 기본 생성자");
	}
	public Parent(int n) {
		System.out.println("parent 정수 생성자 : "+n);
	}
	public Parent(String str) {
		System.out.println("parent 문자열 생성자 : "+str);
	}
	
	public void first() {
		System.out.println("부모클래스 public");
	}
	protected void second() {
		System.out.println("부모클래스 protected");
	}
	void third() {
		System.out.println("부모클래스 default");
	}
	private void forth() {
		System.out.println("부모클래스 private");
	}
}
