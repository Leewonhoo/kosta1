package work.model.service;

import java.util.ArrayList;
import java.util.Iterator;

import work.model.dao.BboardDao;
import work.model.dto.Bboard;
import work.model.dto.Bmember;

public class BboardService {
	private BboardDao bbdao = BboardDao.getInstance();
	
	/**
	 * <pre>
	 * �г��� Ȯ��
	 * </pre>
	 * @param id
	 * @param nick
	 * @return ����: ���̵�, ���� : null
	 */
	public boolean nickcheck(String id, String nick) {
		String result = bbdao.isM_nick(nick);
		if (id.equals(result)) {
			return true;
		}
		if (result == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <pre>
	 * �Խ��� �ۼ�
	 * </pre>
	 * @param Dto
	 * @return
	 */
	public int bboardAdd(Bboard Dto) {
		return bbdao.insert(Dto);
	}
	
	/**
	 * <pre>
	 * �Խ��� ����
	 * </pre>
	 * @param Dto
	 * @return
	 */
	public int bboardDelete(Bboard Dto) {
		if(bbdao.isB_nick(Dto.getbNick(), Dto.getbNum())) {
			return bbdao.delete(Dto.getbNick(), Dto.getbPw(), Dto.getbNum());
		}
		return 0;
	}
	
	/**
	 * <pre>
	 * ȸ�� ���� Ȯ��
	 * </pre>
	 * @param Dto
	 * @return ȸ������
	 */
	public String bmemberinfor(Bboard Dto) {
		ArrayList al;
		al = bbdao.selectinfor(Dto.getbId(), Dto.getbNick());
		Iterator line = al.iterator();
		line.hasNext();
		String str = line.next().toString();
		String st[] = str.split(",");
		String result = "";
		for (int i = 0; i < st.length; i++) {
			result += (st[i].trim() + ",");
		}
		return result;
	}
	
	/**
	 * <pre>
	 * ȸ������ ������Ʈ
	 * </pre>
	 * @param Dto
	 * @return ������Ʈ ���
	 */
	public int bmemupdate(Bmember Dto) {
		return bbdao.bmemupdate(Dto);
	}
	
	/**
	 * <pre>
	 * �Խñ� �г��� ����
	 * </pre>
	 * @param Dto
	 * @return ����1, ����0
	 */
	public int bnickupdate(String id, String nick) {
		return bbdao.bnickupdate(id, nick);
	}

	/**
	 * <pre>
	 * �Խ��� ��� ���� ȣ��
	 * </pre>
	 * @param num
	 * @return �Խ��� ����
	 */
	public ArrayList bboardSelectAll(int num, int page) {
		ArrayList al;
		al = bbdao.selectAll(num, page);
		if (al.size() > 0) {
			return al;
		}
		return null;
	}
	
	/**
	 * <pre>
	 * ���� �ۼ��� ���� ȣ��
	 * </pre>
	 * @param num
	 * @param nick
	 * @return ���� �ۼ��� �Խ��� ����
	 */
	public ArrayList bboardSelectmy(int num, String nick) {
		ArrayList al;
		al = bbdao.selectmy(num, nick);
		if (al.size() > 0) {
			return al;
		}
		return null;
	}
	
	/**
	 * <pre>
	 * �Խ��� ������ ��ȣ
	 * </pre>
	 * @return �Խ��� ������ ��ȣ
	 */
	public int bboardLast() {
		return bbdao.selectLast();
	}
	
	/**
	 * <pre>
	 * �Խ��� ���λ���
	 * </pre>
	 * @param num
	 * @return ������ �Խ��� ��������
	 */
	public ArrayList bbetail(int num) {
		if (bbdao.isB_num(num)) {
			return bbdao.bdeatil(num);
		}
		return null;
	}
	
	/**
	 * <pre>
	 * ��ȸ�� ����
	 * </pre>
	 * @param num
	 * @return ���� true ���� false
	 */
	public boolean bvisitup(int num) {
		if (bbdao.bborupdate(num) == 1) {
			return true;
		}
		return false;
	}
	
}
