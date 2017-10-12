package study;

public class PCmain {

	public static void main(String[] args) {
		System.out.println("parent 持失切");
		Parent pp = new Parent();
		System.out.println("child 持失切");
		Child cc = new Child();

		System.out.println("parent 五社球");
		pp.first();
		pp.second();
		pp.third();

		System.out.println("child 五社球");
		cc.first();
		cc.second();
		cc.third();
	}

}
