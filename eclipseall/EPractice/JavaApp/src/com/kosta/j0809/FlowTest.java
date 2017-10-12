package com.kosta.j0809;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
	//필요한 컴포넌트, 컨테이너 선언
	Button b1, b2, b3, b4;
	Frame f;
	FlowLayout fl;
	
	public FlowTest() {
		//컴포넌트, 컨테이너 초기화
		b1=new Button("버튼1");
		b2=new Button("버튼2");
		b3=new Button("버튼3");
		b4=new Button("버튼4");
		f=new Frame("플로우레이아웃");
		
		//속성지정
		fl = new FlowLayout();
		f.setLayout(fl);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		
		//마무리(메소드 호출- 프레임크기 및 보이기)
		f.setSize(300, 300);
		f.setVisible(true);
		
	}//생성자
	
	public static void main(String[] args) {
//		FlowTest ft = new FlowTest();
		new FlowTest();
	}
}
