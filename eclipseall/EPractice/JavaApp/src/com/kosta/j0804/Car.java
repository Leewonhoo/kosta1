package com.kosta.j0804;

public class Car {
	
	String carName;
	int wheelNum, velocity;
	
	public Car(String carName, int wheelNum, int velocity) {
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}
	
	@Override    //��� ���� �ʾƵ� ������ ��� �� �θ� Ŭ������ �ִ��� ���� Ȯ���Ѵ�.
	public String toString() {
		return "Car [carName=" + carName + ", wheelNum=" + wheelNum + ", velocity=" + velocity + "]";
	}
	
	public boolean equals(Car c) {
		if(carName.equals(c.carName)&&
				wheelNum == c.wheelNum &&
				velocity == c.velocity) { 
			return true;
		}else {
			return false;
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("�ҳ�Ÿ", 33, 100);
		Car c2 = new Car("�׷���", 40, 120);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		
		String s1 = new String("java");
		String s2 = new String("java");
		System.out.println("s1==s2 ��� : "+(s1==s2));          //�ּҰ�(�޸�) ��
		System.out.println("s1.euqal(s2) ��� : "+s1.equals(s2));   //��(������) ��
	}

}
