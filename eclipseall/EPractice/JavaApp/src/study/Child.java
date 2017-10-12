package study;

public class Child extends Parent{
	int c1;
	String c2;
	
	public Child() {
		super("aa");
		System.out.println("child의 기본생성자");
	}
	public Child(int n) {
		super("aa");
		System.out.println("child의 정수생성자 : "+n);
	}
	public Child(String str) {
		System.out.println("child의 문자열생성자 : "+str);
	}
	
	public void first() {
		super.first();
		System.out.println("자식 public 메소드");
	}
	protected void second() {
		System.out.println("자식 protected 메소드");
	}
	void third() {
		System.out.println("자식 default 메소드");
	}
	private void forth() {
		System.out.println("자식 private 메소드");
	}

}
