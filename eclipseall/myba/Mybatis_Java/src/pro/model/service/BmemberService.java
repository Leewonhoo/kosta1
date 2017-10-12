package pro.model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import pro.model.dao.BmemberDao;
import pro.model.dto.Bmember;

public class BmemberService {
	private BmemberDao bdao = BmemberDao.getInstance();
	
	/**
	 * <pre>
	 * ���̵� Ȯ��
	 * </pre>
	 * @param id
	 * @return ����:1, ����:0
	 */
	public boolean idCheck(String id) {
		return bdao.isM_id(id);
	}
	
	/**
	 * <pre>
	 * �г��� Ȯ��
	 * </pre>
	 * @param nick
	 * @return ����:1, ����:0
	 */
	public boolean nickcheck(String nick) {
		return bdao.isM_nick(nick);
	}
	
	/**
	 * <pre>
	 * ȸ������
	 * </pre>
	 * @param controlDto
	 * @return �Է� ���
	 */
	public int bmemberAdd(Bmember controlDto) {
		if(!bdao.isM_id(controlDto.getmId())) {
			return bdao.insert(controlDto);
		}
		return 0;
	}
	
	/**
	 * <pre>
	 * ȸ�� Ż��
	 * </pre>	
	 * @param controlDto
	 * @return Ż�� ���
	 */
	public int bmemberDelete(String controlDto) {
		if(!bdao.isM_id(controlDto)) {
			return bdao.delete(controlDto);
		}
		return 0;
	}
	
	/**
	 * <pre>
	 * �α���
	 * </pre>
	 * @param id
	 * @param pw
	 * @return ��ġ�� �α��� �ƴҰ�� null
	 */
	public String bmemberlogin(String id, String pw) {
		return bdao.selectlogin(id, pw);
//		Map<String, String> map = bdao.selectlogin(id);
//		if ((map != null) && (map.isEmpty())){
//			Set a = map.keySet();
//			Iterator b = a.iterator();
//			while (b.hasNext()) {
//				String[] mapa = map.get(b.next()).toString().split(",");
//				for (int i = 0; i < mapa.length; i++) {
//					if (pw.equals(mapa[i].trim())) {
//						return mapa[0].trim()+","+mapa[mapa.length-2].trim();
//					}				
//				}
//			}
//		}
//		return null;
	}
	
	/**
	 * <pre>
	 * ���̵� ã��
	 * </pre>
	 * @param dto
	 * @return ��ġ �� ���̵� ȣ��
	 */
	public String bmemberid(Bmember dto) {
		return bdao.selectselectId(dto.getmName());
//		ArrayList<Bmember> al = bdao.selectId(dto.getmName());
//		if ((al != null) && (al.isEmpty())) {
//			Iterator round = al.iterator();
//			int count = 0;
//			while (round.hasNext()) {
//				String str = round.next().toString();
//				String[] st = str.split(",");
//				for (int i = 0; i < st.length; i++) {
//					if (st[i].trim().equals(dto.getmBirth()) || st[i].trim().equals(dto.getmAnswer())) {
//						count++;
//					}
//					if (count == 2) {
//						return st[0];
//					}				
//				}
//				count = 0;
//			}
//		}
//		return null;
	}
	
	/**
	 * <pre>
	 * ��й�ȣ ã��
	 * </pre>
	 * @param dto
	 * @return ��ġ�� ��й�ȣ ȣ��
	 */
	public String bmemberpw(Bmember dto) {
		ArrayList<Bmember> al = bdao.selectPw(dto.getmId());
		if ((al != null) && (al.isEmpty())) {
			Iterator round = al.iterator();
			int count = 0;
			while (round.hasNext()) {
				String str = round.next().toString();
				String[] st = str.split(",");
				for (int i = 0; i < st.length; i++) {
					if (st[i].trim().equals(dto.getmName()) || st[i].trim().equals(dto.getmBirth()) || st[i].trim().equals(dto.getmAnswer())) {
						count++;
					}
					if (count == 3) {
						return st[1];
					}				
				}
				count = 0;
			}
		}
		return null;
	}
	
}