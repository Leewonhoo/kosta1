package study;

public class Parent {
	int p1;
	String p2;
	
	public Parent() {
		System.out.println("parent �⺻ ������");
	}
	public Parent(int n) {
		System.out.println("parent ���� ������ : "+n);
	}
	public Parent(String str) {
		System.out.println("parent ���ڿ� ������ : "+str);
	}
	
	public void first() {
		System.out.println("�θ�Ŭ���� public");
	}
	protected void second() {
		System.out.println("�θ�Ŭ���� protected");
	}
	void third() {
		System.out.println("�θ�Ŭ���� default");
	}
	private void forth() {
		System.out.println("�θ�Ŭ���� private");
	}
}
