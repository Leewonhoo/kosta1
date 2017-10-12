// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BboardService.java

package work.model.service;

import java.util.ArrayList;
import java.util.Iterator;
import work.model.dao.BboardDao;
import work.model.dto.Bboard;
import work.model.dto.Bmember;

public class BboardService
{

    public BboardService()
    {
        bbdao = BboardDao.getInstance();
    }

    public boolean nickcheck(String id, String nick)
    {
        String result = bbdao.isM_nick(nick);
        if(id.equals(result))
            return true;
        return result == null;
    }

    public int bboardAdd(Bboard Dto)
    {
        return bbdao.insert(Dto);
    }

    public int bboardDelete(Bboard Dto)
    {
        if(bbdao.isB_nick(Dto.getbNick(), Dto.getbNum()))
            return bbdao.delete(Dto.getbNick(), Dto.getbPw(), Dto.getbNum());
        else
            return 0;
    }

    public String bmemberinfor(Bboard Dto)
    {
        ArrayList al = bbdao.selectinfor(Dto.getbId(), Dto.getbNick());
        Iterator line = al.iterator();
        line.hasNext();
        String str = line.next().toString();
        String st[] = str.split(",");
        String result = "";
        for(int i = 0; i < st.length; i++)
            result = (new StringBuilder(String.valueOf(result))).append(st[i].trim()).append(",").toString();

        return result;
    }

    public int bmemupdate(Bmember Dto)
    {
        return bbdao.bmemupdate(Dto);
    }

    public int bnickupdate(String id, String nick)
    {
        return bbdao.bnickupdate(id, nick);
    }

    public ArrayList bboardSelectAll(int num)
    {
        ArrayList al = bbdao.selectAll(num);
        if(al.size() > 0)
            return al;
        else
            return null;
    }

    public ArrayList bboardSelectmy(int num, String nick)
    {
        ArrayList al = bbdao.selectmy(num, nick);
        if(al.size() > 0)
            return al;
        else
            return null;
    }

    public int bboardLast()
    {
        return bbdao.selectLast();
    }

    public ArrayList bbetail(int num)
    {
        if(bbdao.isB_num(num))
            return bbdao.bdeatil(num);
        else
            return null;
    }

    public boolean bvisitup(int num)
    {
        return bbdao.bborupdate(num) == 1;
    }

    private BboardDao bbdao;
}
