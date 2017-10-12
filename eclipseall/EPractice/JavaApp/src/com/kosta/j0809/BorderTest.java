package com.kosta.j0809;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest extends Frame{
	//필요한 컴포넌트, 컨테이너 선언
	Button b1, b2, b3, b4, b5;
	BorderLayout bl;

	public BorderTest(String title) {
		//상위 클래스 생성자 호출
		super(title);
		//this.setTitle("보더레이아웃");

		//컴포넌트, 컨테이너 초기화
		b1=new Button("버튼1");
		b2=new Button("버튼2");
		b3=new Button("버튼3");
		b4=new Button("버튼4");
		b5=new Button("버튼5");

		//속성지정
		//bl = new BorderLayout();
		bl = new BorderLayout(50, 50);
		
		this.setLayout(bl);   //frame으로부터 상속받으므로 this 사용
		this.add(b1, bl.CENTER);
		this.add("North", b2);
		this.add(b3, bl.PAGE_END);
		add(b4, bl.EAST);
		//this를 생략하여도 현재 클래스에서 사용하지 않기 때문에
		//상속해주는 Frame으로 올라간다. 따라서 생략 가능.
		add(b5, bl.LINE_START);

		//마무리(메소드 호출- 프레임크기 및 보이기)
		this.setSize(300,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderTest("보더레이아웃");    //new Frame 생성
	}

}
