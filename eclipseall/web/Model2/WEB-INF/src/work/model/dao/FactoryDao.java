// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FactoryDao.java

package work.model.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class FactoryDao
{

    private FactoryDao()
    {
        try
        {
            Context context = new InitialContext();
            ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle");
        }
        catch(NamingException namingexception) { }
    }

    public static FactoryDao getinstance()
    {
        return instance;
    }

    public Connection getConnection()
    {
        try
        {
            return ds.getConnection();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void close(Statement st, Connection con)
    {
        try
        {
            if(st != null)
                st.close();
            if(con != null)
                con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void close(ResultSet rs, Statement st, Connection con)
    {
        try
        {
            if(rs != null)
                rs.close();
            if(st != null)
                st.close();
            if(con != null)
                con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static FactoryDao instance = new FactoryDao();
    private DataSource ds;

}
