package com.kosta.j0808;

import java.util.Vector;


//Vector 추가, 수정, 삭제, 조회

public class VectorTest2 {
	public static void main(String[] args) {
		Vector<String> vs = new Vector<>();
		
		//추가 : add, addElement
//		vs.add(13);     //제네릭명시 때문에 명시한 자료형만 입력가능
		vs.add("Lee");  //index 0
		vs.add("won");  //index 1
		vs.add("ho");  //index 2
		vs.add("won");

		//조회 : get, elementAt
		System.out.println("벡터 값 호출 : "+vs.get(1));
		System.out.println("벡터 값 호출 : "+vs.elementAt(2));
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("벡터 for문 호출 : "+vs.get(i));
		}
		
		//수정 : set, setElementAt
		vs.set(1, "one");
		vs.setElementAt("Ah!", 2);
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("수정후 벡터 for문 호출 : "+vs.get(i));
		}
		
		
		//삭제 : remove, removeElement, removeElementAt
		//전체삭제 : removeAllElements, clear
		vs.remove("one");     //vs.remove(1);
//		vs.removeElement(obj)
//		vs.removeElementAt(index);
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("삭제후 벡터 for문 호출 : "+vs.get(i));
		}
		vs.clear();
		for (int i = 0; i < vs.size(); i++) {
			System.out.println("전체 삭제후 벡터 for문 호출 : "+vs.get(i));
		}
		
		System.out.println("====================\n");
		Vector pp = new Vector();
//		pp.add(new Person("이원호", 25, "학생"));
		Object result = pp.get(0);
		System.out.println("per 0의 나이 : "+((Person)result).getAge());
		
		
		System.out.println("====================\n");
		Vector<Person> v3 = new Vector<>();
//		Person p = new Person("lee", 32, "sa");
//		v3.add(p);
		System.out.println("per 0의 나이 : "+v3.get(0).getAge());
		
		
		System.out.println("====================\n");
	}
}
