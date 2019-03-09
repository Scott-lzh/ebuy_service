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

@WebServlet(name = "UserViewServlet", value = "/userView.do")
public class UserViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();
        String name = request.getParameter("name");
        int flag = Integer.valueOf(request.getParameter("flag"));
        User user = iuBiz.findUserByName(name);

        request.setAttribute("user", user);
        if(1 == flag) {
            request.getRequestDispatcher("userView.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("userUpdate.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
