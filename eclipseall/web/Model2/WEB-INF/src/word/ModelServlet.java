// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ModelServlet.java

package work.controller;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.*;
import javax.servlet.http.*;
import work.model.dto.Bmember;
import work.model.service.BmemberService;

public class ModelServlet extends HttpServlet
{

    public ModelServlet()
    {
        bs = new BmemberService();
        dto = new Bmember();
    }

    public void init(ServletConfig config)
        throws ServletException
    {
        String initname = config.getInitParameter("webname");
        String initage = config.getInitParameter("webage");
        System.out.println((new StringBuilder("initname : ")).append(initname).append(", initage : ").append(initage).toString());
        ServletContext initinfor = config.getServletContext();
        initinfor.setAttribute("webname", initname);
        initinfor.setAttribute("webage", initage);
    }

    public void destroy()
    {
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
label0:
        {
            System.out.println(request.getMethod());
            String action = request.getParameter("action");
            System.out.println((new StringBuilder("action : ")).append(action).toString());
            String s;
            switch((s = action).hashCode())
            {
            default:
                break;

            case -1097329270: 
                if(!s.equals("logout"))
                    break;
                logout(request, response);
                break label0;

            case -912398881: 
                if(!s.equals("allList"))
                    break;
                allinforlist(request, response);
                break label0;

            case -690213213: 
                if(!s.equals("register"))
                    break;
                register(request, response);
                break label0;

            case 100348292: 
                if(!s.equals("infor"))
                    break;
                information(request, response);
                break label0;

            case 103149417: 
                if(s.equals("login"))
                {
                    login(request, response);
                    break label0;
                }
                break;

            case 1399540326: 
                if(!s.equals("memdetail"))
                    break;
                memberdetail(request, response);
                break label0;
            }
            System.out.println("Error!!!!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String id = request.getParameter("memberId");
        String pw = request.getParameter("memberPw");
        if(id == null || id.trim().length() == 0)
        {
            System.out.println("id \uC5C6\uC74C");
            request.setAttribute("errorMessage", "id X");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if(pw == null || pw.trim().length() == 0)
        {
            System.out.println("pw \uC5C6\uC74C");
            response.sendRedirect("Login.jsp");
            return;
        }
        String service = bs.bmemberlogin(id, pw);
        if(service != null)
        {
            System.out.println("\uC131\uACF5");
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", id);
            response.sendRedirect("Service.jsp");
        } else
        {
            System.out.println("\uC2E4\uD328");
            request.setAttribute("errorMessage", "\uC2E4\uD328");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean sessionCheck(HttpServletRequest request)
    {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute("userId") != null;
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        session.removeAttribute("userId");
        session.invalidate();
        response.sendRedirect("Login.jsp");
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        System.out.println("\uD68C\uC6D0\uAC00\uC785");
        String id = request.getParameter("rId");
        String pw = request.getParameter("rPw");
        String name = request.getParameter("rName");
        String nick = request.getParameter("rNick");
        String gender = request.getParameter("rGender");
        int question = Integer.parseInt(request.getParameter("rQuestion"));
        String answer = request.getParameter("rAnswer");
        String birth = (new StringBuilder(String.valueOf(request.getParameter("rYear")))).append("/").append(request.getParameter("rMonth")).append("/").append(request.getParameter("rDay")).toString();
        String email = (new StringBuilder(String.valueOf(request.getParameter("rEmail1")))).append(request.getParameter("rEmail2")).toString();
        String address = (new StringBuilder(String.valueOf(request.getParameter("rPostal")))).append(":").append(request.getParameter("rAddress1")).append(request.getParameter("rAddress2")).toString();
        String mobile = (new StringBuilder(String.valueOf(request.getParameter("rMobile1")))).append(request.getParameter("rMobile2")).append(request.getParameter("rMobile3")).toString();
        if(id == null || pw == null || name == null || nick == null || birth == null || gender == null || answer == null)
            return;
        if(id.length() > 6 || pw.length() > 10 || name.length() > 7 || nick.length() > 10 || gender.length() > 1 || answer.length() > 25)
            return;
        if(address.length() == 1)
            address = "";
        dto = new Bmember(id, pw, name, nick, birth, mobile, email, gender, address, question, answer);
        if(bs.bmemberAdd(dto) == 1)
            request.setAttribute("Message", "\uD68C\uC6D0\uAC00\uC785 \uC131\uACF5");
        else
            request.setAttribute("Message", "\uD68C\uC6D0\uAC00\uC785 \uC2E4\uD328");
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
    }

    protected void information(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("userId") != null)
        {
            Bmember list = bs.bmemberinfor(session.getAttribute("userId").toString());
            request.setAttribute("dto", list);
        } else
        {
            request.setAttribute("dto", null);
        }
        request.getRequestDispatcher("/Myinfor.jsp").forward(request, response);
    }

    protected void allinforlist(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        java.util.ArrayList list = bs.bmemberList();
        request.setAttribute("dto", list);
        request.getRequestDispatcher("/Allinforlist.jsp").forward(request, response);
    }

    protected void memberdetail(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        Bmember list = bs.bmemberinfor(request.getParameter("id"));
        request.setAttribute("dto", list);
        request.getRequestDispatcher("/Allinfor.jsp").forward(request, response);
    }

    private BmemberService bs;
    private Bmember dto;
}
