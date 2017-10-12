// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BmemberService.java

package work.model.service;

import java.util.*;
import work.model.dao.BmemberDao;
import work.model.dto.Bmember;

public class BmemberService
{

    public BmemberService()
    {
        bdao = BmemberDao.getInstance();
    }

    public boolean idCheck(String id)
    {
        return bdao.isM_id(id);
    }

    public boolean nickcheck(String nick)
    {
        return bdao.isM_nick(nick);
    }

    public int bmemberAdd(Bmember controlDto)
    {
        if(!bdao.isM_id(controlDto.getmId()))
            return bdao.insert(controlDto);
        else
            return 0;
    }

    public int bmemberDelete(String controlDto)
    {
        if(!bdao.isM_id(controlDto))
            return bdao.delete(controlDto);
        else
            return 0;
    }

    public String bmemberlogin(String id, String pw)
    {
        HashMap map = bdao.selectlogin(id);
        Set a = map.keySet();
        for(Iterator b = a.iterator(); b.hasNext();)
        {
            String mapa[] = map.get(b.next()).toString().split(",");
            for(int i = 0; i < mapa.length; i++)
                if(pw.equals(mapa[i].trim()))
                    return (new StringBuilder(String.valueOf(mapa[0].trim()))).append(",").append(mapa[mapa.length - 2].trim()).toString();

        }

        return null;
    }

    public String bmemberid(Bmember dto)
    {
        ArrayList al = bdao.selectId(dto.getmName());
        Iterator round = al.iterator();
        for(int count = 0; round.hasNext(); count = 0)
        {
            String str = round.next().toString();
            String st[] = str.split(",");
            for(int i = 0; i < st.length; i++)
            {
                if(st[i].trim().equals(dto.getmBirth()) || st[i].trim().equals(dto.getmAnswer()))
                    count++;
                if(count == 2)
                    return st[0];
            }

        }

        return null;
    }

    public String bmemberpw(Bmember dto)
    {
        ArrayList al = bdao.selectPw(dto.getmId());
        Iterator round = al.iterator();
        for(int count = 0; round.hasNext(); count = 0)
        {
            String str = round.next().toString();
            String st[] = str.split(",");
            for(int i = 0; i < st.length; i++)
            {
                if(st[i].trim().equals(dto.getmName()) || st[i].trim().equals(dto.getmBirth()) || st[i].trim().equals(dto.getmAnswer()))
                    count++;
                if(count == 3)
                    return st[1];
            }

        }

        return null;
    }

    public Bmember bmemberinfor(String id)
    {
        return bdao.selectinfor(id);
    }

    public ArrayList bmemberList()
    {
        return bdao.alllist();
    }

    private BmemberDao bdao;
}
