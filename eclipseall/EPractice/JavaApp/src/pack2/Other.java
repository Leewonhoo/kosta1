package pack2;

import pack1.Parent;   //�ٸ� ��Ű���� Ŭ������ ��� �ޱ� ���ؼ� import ������ ���ش�.
                       //parent Ŭ������ public�� �ƴ� �� ��� �Ұ�

public class Other {
	void callTest() {
		Parent p = new Parent();
		p.m1();   //�ٸ� Ŭ���� �� ����� ���� ���� ��� public ���� ��� ����
//		p.m2();   //protected : ���� ��Ű�� �� ��� ���踸 ��� ����
//		p.m3();   //���� ��Ű�� ������ ��� ����
//		p.m4();   //private : ���� Ŭ���� ������ ��� ����
	}
}
