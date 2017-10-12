package com.kosta.j0808;

import java.util.Vector;


//Vector �߰�, ����, ����, ��ȸ

public class VectorTest2 {
	public static void main(String[] args) {
		Vector<String> vs = new Vector<>();
		
		//�߰� : add, addElement
//		vs.add(13);     //���׸���� ������ ����� �ڷ����� �Է°���
		vs.add("Lee");  //index 0
		vs.add("won");  //index 1
		vs.add("ho");  //index 2
		vs.add("won");

		//��ȸ : get, elementAt
		System.out.println("���� �� ȣ�� : "+vs.get(1));
		System.out.println("���� �� ȣ�� : "+vs.elementAt(2));
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("���� for�� ȣ�� : "+vs.get(i));
		}
		
		//���� : set, setElementAt
		vs.set(1, "one");
		vs.setElementAt("Ah!", 2);
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("������ ���� for�� ȣ�� : "+vs.get(i));
		}
		
		
		//���� : remove, removeElement, removeElementAt
		//��ü���� : removeAllElements, clear
		vs.remove("one");     //vs.remove(1);
//		vs.removeElement(obj)
//		vs.removeElementAt(index);
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("������ ���� for�� ȣ�� : "+vs.get(i));
		}
		vs.clear();
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("��ü ������ ���� for�� ȣ�� : "+vs.get(i));
		}
		
		System.out.println("====================\n");
		Vector pp = new Vector();
//		pp.add(new Person("�̿�ȣ", 25, "�л�"));
		Object result = pp.get(0);
		System.out.println("per 0�� ���� : "+((Person)result).getAge());
		
		
		System.out.println("====================\n");
		Vector<Person> v3 = new Vector<>();
//		Person p = new Person("lee", 32, "sa");
//		v3.add(p);
		System.out.println("per 0�� ���� : "+v3.get(0).getAge());
		
		
		System.out.println("====================\n");
	}
}
