// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BmemberDao.java

package work.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import work.model.dto.Bmember;

// Referenced classes of package work.model.dao:
//            FactoryDao

public class BmemberDao
{

    private BmemberDao()
    {
        factory = FactoryDao.getinstance();
    }

    public static BmemberDao getInstance()
    {
        return instance;
    }

    public boolean isM_id(String id)
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT M_ID FROM BMEMBER WHERE M_ID=?";
        boolean flag;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
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
        return false;
    }

    public boolean isM_nick(String nick)
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT M_NICK FROM BMEMBER WHERE M_NICK=?";
        boolean flag;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, nick);
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

    public int insert(Bmember DTO)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "INSERT INTO BMEMBER VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, DTO.getmId());
        pst.setString(2, DTO.getmPw());
        pst.setString(3, DTO.getmName());
        pst.setString(4, DTO.getmNick());
        pst.setString(5, DTO.getmBirth());
        pst.setString(6, DTO.getmPhone());
        pst.setString(7, DTO.getmMail());
        pst.setString(8, DTO.getmGender());
        pst.setString(9, DTO.getmAddress());
        pst.setInt(10, DTO.getmQuest());
        pst.setString(11, DTO.getmAnswer());
        i = pst.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        e.getMessage();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_211;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public int delete(String m_id)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "DELETE FROM BMEMBER WHERE m_id=?";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, m_id);
        i = pst.executeUpdate();
        factory.close(pst, con);
        return i;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(pst, con);
        break MISSING_BLOCK_LABEL_86;
        Exception exception;
        exception;
        factory.close(pst, con);
        throw exception;
        return 0;
    }

    public HashMap selectlogin(String id)
    {
        HashMap hm;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        hm = new HashMap();
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT m_id, m_pw, m_nick FROM BMEMBER WHERE m_id=?";
        HashMap hashmap;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        String sid;
        String spw;
        String snick;
        for(rs = pst.executeQuery(); rs.next(); hm.put(sid, new Bmember(sid, spw, snick)))
        {
            sid = rs.getString("m_id");
            spw = rs.getString("m_pw");
            snick = rs.getString("m_nick");
        }

        hashmap = hm;
        factory.close(rs, pst, con);
        return hashmap;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_179;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return hm;
    }

    public ArrayList selectId(String name)
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
        sql = "SELECT m_id, m_name, to_char(m_birth,'yyyyMMdd')\"m_birth\", m_answer FROM BMEMBER WHERE m_name=?";
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, name);
        String sid;
        String sname;
        String sbirth;
        String sanswer;
        for(rs = pst.executeQuery(); rs.next(); al.add(new Bmember(sid, sname, sbirth, sanswer)))
        {
            sid = rs.getString("m_id");
            sname = rs.getString("m_name");
            sbirth = rs.getString("m_birth");
            sanswer = rs.getString("m_answer");
        }

        arraylist = al;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_190;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return al;
    }

    public ArrayList selectPw(String id)
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
        sql = "SELECT m_id, m_pw, m_name, to_char(m_birth,'yyyyMMdd')\"m_birth\", m_answer FROM BMEMBER WHERE m_id=?";
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        String sid;
        String spw;
        String sname;
        String sbirth;
        String sanswer;
        for(rs = pst.executeQuery(); rs.next(); al.add(new Bmember(sid, spw, sname, sbirth, sanswer)))
        {
            sid = rs.getString("m_id");
            spw = rs.getString("m_pw");
            sname = rs.getString("m_name");
            sbirth = rs.getString("m_birth");
            sanswer = rs.getString("m_answer");
        }

        arraylist = al;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_203;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return al;
    }

    public Bmember selectinfor(String id)
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT m_id, m_pw, m_name, m_nick, to_char(m_birth,'yyyy/MM/dd')\"m_birth\",m_phone, m_mail, m_gender, m_address, m_quest, m_answer FROM BMEMBER WHERE m_id=?";
        Bmember bmember;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
        rs = pst.executeQuery();
        if(!rs.next())
            break MISSING_BLOCK_LABEL_260;
        String sid = rs.getString("m_id");
        String spw = rs.getString("m_pw");
        String sname = rs.getString("m_name");
        String snick = rs.getString("m_nick");
        String sbirth = rs.getString("m_birth");
        String sphone = rs.getString("m_phone");
        String smail = rs.getString("m_mail");
        String sgender = rs.getString("m_gender");
        String saddress = rs.getString("m_address");
        int squestion = Integer.parseInt(rs.getString("m_quest"));
        String sanswer = rs.getString("m_answer");
        bmember = new Bmember(sid, spw, sname, snick, sbirth, sphone, smail, sgender, saddress, squestion, sanswer);
        factory.close(rs, pst, con);
        return bmember;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_271;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        factory.close(rs, pst, con);
        return null;
    }

    public ArrayList alllist()
    {
        ArrayList list;
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql;
        list = new ArrayList();
        con = null;
        pst = null;
        rs = null;
        sql = "SELECT m_id, m_name, m_nick, m_gender FROM BMEMBER";
        ArrayList arraylist;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        Bmember member;
        for(rs = pst.executeQuery(); rs.next(); list.add(member))
        {
            String sid = rs.getString("m_id");
            String sname = rs.getString("m_name");
            String snick = rs.getString("m_nick");
            String sgender = rs.getString("m_gender");
            member = new Bmember();
            member.setmId(sid);
            member.setmName(sname);
            member.setmNick(snick);
            member.setmGender(sgender);
        }

        arraylist = list;
        factory.close(rs, pst, con);
        return arraylist;
        Exception e;
        e;
        e.printStackTrace();
        factory.close(rs, pst, con);
        break MISSING_BLOCK_LABEL_199;
        Exception exception;
        exception;
        factory.close(rs, pst, con);
        throw exception;
        return null;
    }

    private FactoryDao factory;
    private static BmemberDao instance = new BmemberDao();

}
