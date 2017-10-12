package com.kosta.calc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.calc.model.Calculator;
import com.kosta.calc.view.CalcView;

public class CalcController implements ActionListener{   //전체 프로그램의 흐름 제어
	
	// 뷰등록
	CalcView cv;
	
	public CalcController() {
		cv = new CalcView();
		cv.bt1.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new CalcController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {   //컨트롤러 역할
		if(e.getSource()==cv.bt1) {
			String s1 = cv.tf1.getText();
			String s2 = cv.tf2.getText();
			
			String check = "[0-9]*";
			s1.matches(check);
			s2.matches(check);
			
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(s2);
			int result=0;
			String cc = cv.com1.getSelectedItem().toString();
			Calculator cal = new Calculator();
			if(cc.equals("+")) {
				result=cal.add(n1, n2);
			}else if(cc.equals("-")) {
				result=cal.min(n1, n2);
			}else if(cc.equals("*")) {
				result=cal.mul(n1, n2);
			}else if(cc.equals("/")) {
				result=cal.div(n1, n2);
			}
			String restr = "결과값 : "+result;
			cv.la1.setText(restr);
//			cv.setVisible(true);
		}
	}
}
