package study;

public class PCmain {

	public static void main(String[] args) {
		System.out.println("parent ������");
		Parent pp = new Parent();
		System.out.println("child ������");
		Child cc = new Child();

		System.out.println("parent �޼ҵ�");
		pp.first();
		pp.second();
		pp.third();

		System.out.println("child �޼ҵ�");
		cc.first();
		cc.second();
		cc.third();
	}

}
