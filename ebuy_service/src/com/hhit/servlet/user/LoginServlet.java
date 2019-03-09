package com.hhit.servlet.user;

import com.hhit.biz.user.IUserBiz;
import com.hhit.biz.user.impl.UserBizImpl;
import com.hhit.vo.user.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = iuBiz.findUserByName(username);

        String uname = iuBiz.getUserByWher(username, password);

        if(null != uname){
            HttpSession session = request.getSession();
            session.setAttribute("uname", uname);
            session.setAttribute("type", user.getType());
            request.getRequestDispatcher("public.jsp").forward(request, response);
        }else{
            response.sendRedirect("login.jsp");
            return;
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
