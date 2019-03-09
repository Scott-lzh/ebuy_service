package com.hhit.servlet.user;

import com.hhit.biz.user.IUserBiz;
import com.hhit.biz.user.impl.UserBizImpl;
import com.hhit.vo.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "findUsersByNameServlet", value = "/byname.do")
public class findUsersByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();

        String name = request.getParameter("name");
//        System.out.println(name);
        List<User> userByName = iuBiz.getUserByName(name);

        request.setAttribute("userList", userByName);
        request.getRequestDispatcher("userList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
