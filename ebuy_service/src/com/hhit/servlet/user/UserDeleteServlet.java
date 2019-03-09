package com.hhit.servlet.user;

import com.hhit.biz.user.IUserBiz;
import com.hhit.biz.user.impl.UserBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", value = "/userDelete.do")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();
        int id = Integer.valueOf(request.getParameter("id"));
        int i = iuBiz.delUser(id);

        request.getRequestDispatcher("userList.do").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
