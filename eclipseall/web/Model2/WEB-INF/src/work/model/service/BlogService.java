// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BlogService.java

package work.model.service;

import java.util.ArrayList;
import work.model.dao.BlogDao;
import work.model.dto.Blogin;

public class BlogService
{

    public BlogService()
    {
        blogdao = BlogDao.getInstance();
    }

    public int loginmemo(String id)
    {
        return blogdao.insert(id);
    }

    public int updatememo(String status, String id)
    {
        return blogdao.loupdate(status, id);
    }

    public ArrayList lastmemo(Blogin Dto)
    {
        return null;
    }

    private BlogDao blogdao;
}
