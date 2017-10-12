package com.kosta.j0816;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePad extends JFrame implements ActionListener{

	JTextArea ta;
	JScrollPane sp;

	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem mi1, mi2, mi3;

	FileInputStream fis;
	FileOutputStream fos;

	Vector<Byte> v;

	public NotePad() {

		ta = new JTextArea();
		sp = new JScrollPane(ta);

		mb = new JMenuBar();
		m1 = new JMenu("All");
		m2 = new JMenu("Help");
		mi1 = new JMenuItem("Open");
		mi2 = new JMenuItem("Save");
		mi3 = new JMenuItem("Exit");

		m1.add(mi1);
		m1.add(mi2);		
		m1.addSeparator();
		m1.add(mi3);
		mb.add(m1);
		mb.add(m2);
		add("North", mb);
		add("Center", sp);

		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
	}

	public static void main(String[] args) {
		new NotePad();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==mi1) {       //Open
			OpenMeth();
		}else if(e.getSource()==mi2) {      //Save
			SaveMeth();
		}else if(e.getSource()==mi3) {
			int i = JOptionPane.showConfirmDialog(this, "종료?");
			System.out.println(i);
			if(i==0) {
				System.exit(0);
			}
		}
	}

	private void OpenMeth() {
		JFileChooser fc = new JFileChooser("I:\\");
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "gif");
		//fc.setFileFilter(filter);
		int result = fc.showOpenDialog(this);
		int i;
		if(result==0) {      //result==JFileChooser.APPROVE_OPTION
			String a=fc.getSelectedFile().getAbsolutePath();
			try {
				fis = new FileInputStream(a);				
				ta.setText("");
				while((i=fis.read())!=-1) {
					ta.append(String.valueOf((char)i));
				}

			}catch(Exception e1) {
				System.out.println("no");
			}finally {
				try {
					if(fis!=null) {
						fis.close();
						System.out.println("닫기 성공:Open");
					}
				} catch (IOException e) {
					System.out.println("닫기 실패:Open");
					e.printStackTrace();
				}
			}
		}else {
			JOptionPane.showMessageDialog(this, "취소하였습니다.");
		}
	}

	private void SaveMeth() {
		try {
			fos = new FileOutputStream("I:\\b.txt");
			//for(int i=0; i<ta.getText().length(); i++) {
			//	String sa = ta.getText().substring(i, i+1).replace("\n", "\r\n");
				String sa = ta.getText().replace("\n", "\r\n");
				byte[] b = sa.getBytes();
				try {
					//fos.write(b);
					fos.write(sa.getBytes());
				} catch (IOException e1) {
					System.out.println("파일 저장 실패2");
					e1.printStackTrace();
				}
			//}		
		} catch (FileNotFoundException e1) {
			System.out.println("파일 저장 실패1");
			e1.printStackTrace();
		}finally {
			try {
				if(fos!=null) {
					JOptionPane.showMessageDialog(this, "저장되었습니다.");
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
