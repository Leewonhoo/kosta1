package com.kosta.j0817;

import java.io.Serializable;

public class Person implements Serializable{
	//�� Ŭ������ ����ȭ�� ����
	String name = "�̿�ȣ";
	transient int age = 25;           //��ü ����ȭ�� ������ ���� X
	String job = "�л�";
}
