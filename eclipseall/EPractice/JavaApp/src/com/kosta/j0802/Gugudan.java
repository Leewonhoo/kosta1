package com.kosta.j0802;

import java.io.IOException;

import javax.sound.midi.Synthesizer;

public class Gugudan {
	public int danInput() throws IOException {
		System.out.print("����� �� �Է�  => ");
		int dan = System.in.read()-48;
		System.in.read();
		System.in.read();
		return dan;
	}
	public void danOutput(int dan) {
		for(int i=1; i<10; i++) {
			System.out.println(dan+"*"+i+"=\t"+(dan*i));
		}
	}
	public char danContinue() throws IOException {
		char con;
		do{
			System.out.print("����Ͻðڽ��ϱ� (y/n) => ");
			con = (char)System.in.read();
			System.in.read();
			System.in.read();
			if(!(con=='y'||con=='Y'||con=='n'||con=='N'))
//				con!='y'&&con!='Y'&&con!='n'&&con!='N'
				System.out.println("#�߸��� �Է��Դϴ�.\n");
			else
				break;
		}while(true);
		return con;
	}

}
