package study;

public class Child extends Parent{
	int c1;
	String c2;
	
	public Child() {
		super("aa");
		System.out.println("child�� �⺻������");
	}
	public Child(int n) {
		super("aa");
		System.out.println("child�� ���������� : "+n);
	}
	public Child(String str) {
		System.out.println("child�� ���ڿ������� : "+str);
	}
	
	public void first() {
		super.first();
		System.out.println("�ڽ� public �޼ҵ�");
	}
	protected void second() {
		System.out.println("�ڽ� protected �޼ҵ�");
	}
	void third() {
		System.out.println("�ڽ� default �޼ҵ�");
	}
	private void forth() {
		System.out.println("�ڽ� private �޼ҵ�");
	}

}
