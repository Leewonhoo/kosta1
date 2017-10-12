package com.kosta.j0804;

public class Car {
	
	String carName;
	int wheelNum, velocity;
	
	public Car(String carName, int wheelNum, int velocity) {
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
	}
	
	@Override    //사용 하지 않아도 되지만 사용 시 부모 클래스에 있는지 먼저 확인한다.
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
		Car c1 = new Car("소나타", 33, 100);
		Car c2 = new Car("그랜저", 40, 120);
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		
		String s1 = new String("java");
		String s2 = new String("java");
		System.out.println("s1==s2 결과 : "+(s1==s2));          //주소값(메모리) 비교
		System.out.println("s1.euqal(s2) 결과 : "+s1.equals(s2));   //값(데이터) 비교
	}

}
