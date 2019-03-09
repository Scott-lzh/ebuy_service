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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserUpdateServlet", value = "/userUpdate.do")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();
        User user = new User();

        user.setName(request.getParameter("userName"));
        user.setSex(request.getParameter("sex"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(request.getParameter("birth"));
            user.setBirth(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(d);
        user.setTel(request.getParameter("userphone"));
        user.setAddress(request.getParameter("userAddress"));
        user.setType(Integer.valueOf(request.getParameter("userlei")));

        System.out.println(Integer.valueOf(request.getParameter("userlei")));

        User u = iuBiz.findUserByName(request.getParameter("userName"));

        user.setId(u.getId());
        user.setAge(u.getId());
        user.setPwd(u.getPwd());
        user.setCredit(u.getCredit());

        int i = iuBiz.updateUser(user);
//        System.out.println(user.toString());
        request.getRequestDispatcher("userList.do").forward(request, response);
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
