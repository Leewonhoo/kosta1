// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BlogDao.java

package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

// Referenced classes of package work.model.dao:
//            FactoryDao

public class BlogDao
{

    private BlogDao()
    {
        factory = FactoryDao.getinstance();
    }

    public static BlogDao getInstance()
    {
        return instance;
    }

    public int insert(String id)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "INSERT INTO blogin(l_id, l_start, l_status, l_ip) VALUES (?,sysdate,'R','192.168.0.1')";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, id);
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

    public int loupdate(String status, String id)
    {
        Connection con;
        PreparedStatement pst;
        String sql;
        con = null;
        pst = null;
        sql = "UPDATE blogin SET l_end=sysdate, l_status=? WHERE l_id=? AND l_end IS NULL";
        int i;
        con = factory.getConnection();
        pst = con.prepareStatement(sql);
        pst.setString(1, status);
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

    private FactoryDao factory;
    private static BlogDao instance = new BlogDao();

}
