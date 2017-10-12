// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BboardDao.java

package work.model.dao;

import java.sql.*;
import java.util.ArrayList;
import work.model.dto.Bboard;
import work.model.dto.Bmember;

// Referenced classes of package work.model.dao:
//            FactoryDao

public class BboardDao
{

    private BboardDao()
    {
        factory = FactoryDao.getinstance();
    }

    public static BboardDao getInstance()
    {
        return instance;
    }

    public boolean isB_num(int num)
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT b_num FROM BBOARD WHERE B_NUM=?";
        boolean flag;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setInt(1, num);
        rs = pst.executeQuery();
        flag = rs.next();
        factory.close(rs, pst, con);
        return flag;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_104;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return true;
    }

    public boolean isB_nick(String nick, int num)
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT B_NICK FROM BBOARD WHERE B_NICK=? AND B_NUM=?";
        boolean flag;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nick);
        pst.setInt(2, num);
        rs = pst.executeQuery();
        flag = rs.next();
        factory.close(rs, pst, con);
        return flag;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_120;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return true;
    }

    public int insert(Bboard DTO)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "INSERT INTO BBOARD(B_ID, B_NICK, B_PW, B_TITLE, B_MEMO, B_TIME, B_TAG, B_NUM)VALUES (?,?,?,?,?,sysdate,?,bbor_seq.nextval)";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, DTO.getbId());
        pst.setString(2, DTO.getbNick());
        pst.setString(3, DTO.getbPw());
        pst.setString(4, DTO.getbTitle());
        pst.setString(5, DTO.getbMemo());
        pst.setString(6, DTO.getbTag());
        i = pst.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_145;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public int bnickupdate(String id, String nick)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "UPDATE BBOARD SET b_nick=? WHERE b_id=?";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nick);
        pst.setString(2, id);
        i = pst.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_102;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public int delete(String nick, String pw, int num)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "DELETE FROM BBOARD WHERE b_nick=? AND b_pw=? AND b_num=?";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nick);
        pst.setString(2, pw);
        pst.setInt(3, num);
        i = pst.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_117;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public ArrayList selectinfor(String id, String nick)
    {
        ArrayList al;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        al = new ArrayList();
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT m_id, m_pw, m_name, m_name, m_nick, to_char(m_birth,'yyyyMMdd')\"m_birth\",m_phone, m_mail, m_gender, m_address, m_answer FROM BMEMBER WHERE m_id=? AND m_nick=?";
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        pst.setString(2, nick);
        String sid;
        String spw;
        String sname;
        String snick;
        String sbirth;
        String sphone;
        String smail;
        String sgender;
        String saddress;
        String sanswer;
        for(rs = pst.executeQuery(); rs.next(); al.add(new Bmember(sid, spw, sname, snick, sbirth, sphone, smail, sgender, saddress, sanswer)))
        {
            sid = rs.getString("m_id");
            spw = rs.getString("m_pw");
            sname = rs.getString("m_name");
            snick = rs.getString("m_nick");
            sbirth = rs.getString("m_birth");
            sphone = rs.getString("m_phone");
            smail = rs.getString("m_mail");
            sgender = rs.getString("m_gender");
            saddress = rs.getString("m_address");
            sanswer = rs.getString("m_answer");
            if(sphone == null)
                sphone = "";
            if(smail == null)
                smail = "";
            if(saddress == null)
                saddress = "";
        }

        arraylist = al;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_310;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return null;
    }

    public int bborupdate(int num)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        String sql1;
        con = null;
        pst = null;
        PreparedStatement pst1 = null;
        ResultSet rs = null;
        sql = "SELECT b_visit FROM bboard WHERE b_num=?";
        sql1 = "UPDATE bboard SET b_visit=? WHERE b_num=?";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setInt(1, num);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int count = rs.getInt("b_visit") + 1;
        PreparedStatement pst1 = con.prepareStatement(sql1);
        pst1.setInt(1, count);
        pst1.setInt(2, num);
        i = pst1.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_155;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public String isM_nick(String nick)
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT M_ID FROM BMEMBER WHERE M_NICK=?";
        String s;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nick);
        rs = pst.executeQuery();
        if(!rs.next())
            break MISSING_BLOCK_LABEL_79;
        s = rs.getString("m_id");
        factory.close(rs, pst, con);
        return s;
        factory.close(rs, pst, con);
        return null;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_129;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return null;
    }

    public int bmemupdate(Bmember DTO)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "UPDATE BMEMBER SET m_pw=?, m_nick=?, m_birth=?, m_phone=?, m_mail=?,m_gender=?, m_address=?, m_answer=? WHERE m_id=?";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, DTO.getmPw());
        pst.setString(2, DTO.getmNick());
        pst.setString(3, DTO.getmBirth());
        pst.setString(4, DTO.getmPhone());
        pst.setString(5, DTO.getmMail());
        pst.setString(6, DTO.getmGender());
        pst.setString(7, DTO.getmAddress());
        pst.setString(8, DTO.getmAnswer());
        pst.setString(9, DTO.getmId());
        i = pst.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_181;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public ArrayList selectAll(int num)
    {
        ArrayList al;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        al = new ArrayList();
        con = null;
        pst = null;
        rs = null;
        String sql1 = "(SELECT * FROM BBOARD ORDER BY b_num DESC)";
        sql = (new StringBuilder("SELECT rownum, b_nick, b_num, b_title, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit FROM ")).append(sql1).append(" WHERE rownum <= ?").toString();
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setInt(1, num * 5);
        for(rs = pst.executeQuery(); rs.next();)
        {
            int a = rs.getInt("rownum");
            if(a > (num - 1) * 5 && a <= num * 5)
            {
                String bnick = rs.getString("b_nick");
                int bnum = rs.getInt("b_num");
                String btitle = rs.getString("b_title");
                String btime = rs.getString("b_time");
                int bvisit = rs.getInt("b_visit");
                al.add(new Bboard(bnick, bnum, btitle, btime, bvisit));
            }
        }

        arraylist = al;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_264;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return null;
    }

    public ArrayList selectmy(int num, String nick)
    {
        ArrayList al;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        al = new ArrayList();
        con = null;
        pst = null;
        rs = null;
        String sql1 = "(SELECT * FROM BBOARD WHERE b_nick=? ORDER BY b_num DESC)";
        sql = (new StringBuilder("SELECT rownum, b_nick, b_num, b_title, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit FROM ")).append(sql1).append(" WHERE rownum <= ?").toString();
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nick);
        pst.setInt(2, num * 5);
        for(rs = pst.executeQuery(); rs.next();)
        {
            int a = rs.getInt("rownum");
            if(a > (num - 1) * 5 && a <= num * 5)
            {
                String bnick = rs.getString("b_nick");
                int bnum = rs.getInt("b_num");
                String btitle = rs.getString("b_title");
                String btime = rs.getString("b_time");
                int bvisit = rs.getInt("b_visit");
                al.add(new Bboard(bnick, bnum, btitle, btime, bvisit));
            }
        }

        arraylist = al;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_280;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return null;
    }

    public int selectLast()
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT b_num FROM BBOARD ORDER BY b_num DESC";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        rs.next();
        i = rs.getInt("b_num");
        factory.close(rs, pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_101;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return 0;
    }

    public ArrayList bdeatil(int num)
    {
        ArrayList al;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        al = new ArrayList();
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT b_nick, b_title, b_memo, to_char(b_time,'yyyy.MM.dd')\"b_time\", b_visit, b_tag FROM bboard WHERE b_num=?";
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setInt(1, num);
        rs = pst.executeQuery();
        rs.next();
        al.add(rs.getString("b_nick"));
        al.add(rs.getString("b_title"));
        al.add(rs.getString("b_memo"));
        al.add(rs.getString("b_time"));
        al.add(rs.getString("b_visit"));
        al.add(rs.getString("b_tag"));
        arraylist = al;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_211;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return null;
    }

    private FactoryDao factory;
    private static BboardDao instance = new BboardDao();

}
