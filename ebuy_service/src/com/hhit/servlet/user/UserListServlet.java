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

@WebServlet(name = "UserListServlet", value = "/userList.do")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();

        Integer pageNo = 0;
        // 创建页码变量
        try {
            pageNo = Integer.valueOf(request.getParameter("pageNo"));
        } catch (NumberFormatException e) {
            pageNo = 1;
        }
        //创建数据条目
        final int PAGESIZE = 2;
        int userCount = iuBiz.findUserCount();
        int sumPage = 0;
        if(userCount % PAGESIZE == 0) {
            sumPage	= userCount / PAGESIZE;
        }else {
            sumPage	= userCount / PAGESIZE + 1;
        }

        List<User> userList = iuBiz.getUserDetails(pageNo,PAGESIZE);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("sumPage", sumPage);
        request.setAttribute("mesCount", userCount);
        request.setAttribute("size", PAGESIZE);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("userList.jsp").forward(request,response);
        return ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
