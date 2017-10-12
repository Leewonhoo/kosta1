package com.kosta.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kosta.person.model.PersonModel;
import com.kosta.person.view.PersonInput;
import com.kosta.person.view.PersonUpdate;
import com.kosta.person.view.PersonView;

public class PersonControll implements ActionListener{

	PersonView pv;
	PersonInput pi;
	PersonUpdate pu;
	PersonModel pm;

	Vector<PersonModel> infor;

	int modinum;
	int num11;

	public PersonControll() {
		pi = new PersonInput();
		pu = new PersonUpdate();
		pm = new PersonModel();
		pv = new PersonView();
		infor = new Vector<>();
		
		loadP();
		print();

		pi.setVisible(false);
		pu.setVisible(false);

		action();
	}

	public static void main(String[] args) {
		new PersonControll();
	}

	private void action() {
		pv.bt_add.addActionListener(this);       //personview button
		pv.bt_na.addActionListener(this);
		pv.bt_findALL.addActionListener(this);
		pv.bt_up.addActionListener(this);
		pv.bt_del.addActionListener(this);
		pv.bt_exit.addActionListener(this);

		pi.bt_submit.addActionListener(this);    //personinput button
		pi.bt_cancel.addActionListener(this);

		pu.bt_submit.addActionListener(this);    //personupdate button
		pu.bt_cancel.addActionListener(this);

		pv.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				print();
				saveP();
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pv.bt_add) {              //입력
			pi.setVisible(true);
			pv.setVisible(false);
		}else if(e.getSource()==pv.bt_na) {
			printn();
		}else if(e.getSource()==pv.bt_findALL) {        //불러오기
			print();
		}else if(e.getSource()==pv.bt_up) {         //수정
			previous();			
		}else if(e.getSource()==pv.bt_del) {         //삭제
			delete();
		}else if(e.getSource()==pv.bt_exit) {        //종료
			print();
			saveP();
			System.exit(0);
		}else if(e.getSource()==pi.bt_submit) {      //입력의 입력
			input();
			pv.setVisible(true);
			pi.setVisible(false);
		}else if(e.getSource()==pi.bt_cancel) {
			pv.setVisible(true);
			pi.setVisible(false);
		}else if(e.getSource()==pu.bt_submit) {      //수정의 수정
			update();
		}else if(e.getSource()==pu.bt_cancel) {
			pv.setVisible(true);
			pu.setVisible(false);
		}

	}

	private void input() {
		int ppp=0;
		for(int i=0; i<infor.size(); i++) {
			ppp = infor.get(i).getNum();
		}
		
		int nai=Integer.parseInt(pi.tf_age.getText());
		String name = pi.tf_name.getText();
		String job = pi.tf_job.getText();
		infor.add(new PersonModel(++ppp, name, nai, job));
		System.out.println("--insert--\n");
		pi.initForm();
		return;
	}
	
	private void printn() {
		pv.dtm.setRowCount(0);
		String name = pv.inmessage("검색할 이름 입력");
		String search=null;
		for(int i=0; i<infor.size(); i++) {
			PersonModel sel = infor.get(i);
			search = infor.get(i).getName();
			System.out.println(search.contains(name));
			/*
			 * contain : 포함 true		startsWith : 시작하면 true
			 * endsWith : 끝나면 true
			 */
			if(search.contains(name)==true) {
				Object[] rowData = {sel.getNum(), sel.getName(), sel.getAge(), sel.getJob()};
				pv.dtm.addRow(rowData);
			}else {
				if(i==(infor.size()-1))
					pv.message("일치하는 이름이 없습니다.");
			}
		}
	}

	private void print() {
		pv.dtm.setRowCount(0);
		//for(int i=pv.dtm.getRowCount(); i>0; i--) {   //dtm 초기화
		//	pv.dtm.removeRow(0);
		//}

		for(int i=0; i<infor.size(); i++) {
			PersonModel sel = infor.get(i);

			Object[] rowData = {sel.getNum(), sel.getName(), sel.getAge(), sel.getJob()};
			pv.dtm.addRow(rowData);
		}
		return;
	}

	private void previous() {
		int num;
		String c1 = "";
		String c2 = "1";

		String delin = pv.inmessage("수정할 번호 입력");

		if(c1.equals(delin)) {
			pv.message("번호를 입력하세요");
			return;
		}else if(c2.equals(delin)) {
			int dd = Integer.parseInt(delin);

			for(int i=0; i<infor.size(); i++) {
				PersonModel sel = infor.get(i);
				//int num = infor.getValueAt(i,0);
				num = sel.getNum();

				if(num==dd) {
					int con = pv.conmessage("수정할거임?");
					if(con==0) {
						String aa = String.valueOf(sel.getAge());
						modinum=num;
						pu.tf_name.setText(sel.getName());
						pu.tf_age.setText(aa);
						pu.tf_job.setText(sel.getJob());
						pu.setVisible(true);
						pv.setVisible(false);
						return;
					}else {
						pv.message("취소하였습니다.");
						return;
					}
				}
			}
			pv.message("일치하는 번호가 없습니다.");
		}else {
			pv.message("취소하였습니다.");
		}
	}

	private void update() {
		for(int i=0; i<infor.size(); i++) {
			PersonModel sel = infor.get(i);
			if(modinum==sel.getNum()) {
				sel.setAge(Integer.parseInt(pu.tf_age.getText()));
				sel.setJob(pu.tf_job.getText());
				pv.message("수정되었습니다.");
				print();
				pv.setVisible(true);
				pu.setVisible(false);
				return;
			}
		}
	}

	private void delete() {
		int num;
		String c1 = "";

		String delin = pv.inmessage("삭제할 번호 입력");

		if(c1.equals(delin)) {
			pv.message("번호를 입력하세요.");
			return;
		}else if(!delin.equals(null)) {
			int dd = Integer.parseInt(delin);

			for(int i=0; i<infor.size(); i++) {
				PersonModel sel = infor.get(i);
				num = sel.getNum();

				if(num==dd) {
					int con = pv.conmessage("삭제할거임?");
					if(con==0) {
						infor.remove(i);
						print();
						return;
					}else {
						pv.message("취소하였습니다.");
						return;
					}
				}
			}
			pv.message("일치하는 번호가 없습니다.");
		}else {
			pv.message("취소하였습니다.");
		}
	}

	private void saveP() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
			oos.writeObject(infor);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos!=null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void loadP() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data.ser"));
			infor = (Vector<PersonModel>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois!=null)
					ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
