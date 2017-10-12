package pro.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pro.controller.BmemberController;
import pro.model.dto.Bmember;

public class BmemberView {

	BufferedReader br;
	Menu m;

	public BmemberView() {
		br = new BufferedReader(new InputStreamReader(System.in));
		m = new Menu();
		m.menu();
	}

	public static void main(String[] args) {
		new BmemberView();
	}
}
