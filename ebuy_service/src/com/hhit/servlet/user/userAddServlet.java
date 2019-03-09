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
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "userAddServlet", value = "/userAdd.do")
public class userAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        IUserBiz iuBiz = new UserBizImpl();
        User user = new User();

//        if()前台js
        String pwd = request.getParameter("userpassword");
        String rpwd = request.getParameter("userRemi");
        if (pwd.equals(rpwd)) {
            user.setPwd(request.getParameter("userpassword"));
        } else {
            response.sendRedirect("");
        }
        user.setId(Integer.valueOf(request.getParameter("userId")));
        user.setName(request.getParameter("userName"));
        user.setSex(request.getParameter("sex"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取日期转换为age
        int age = 0;
        Date d = null;
        Date d1 = null;
        try {
            d = sdf.parse(request.getParameter("data"));

            d1 = new java.sql.Date(d.getTime());
//            System.out.println("d" + d );
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(d);
            c2.setTime(new Date());
            user.setBirth(d);
            age = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setAge(age);
        user.setBirth(d1);
        user.setTel(request.getParameter("userphone"));
        user.setAddress(request.getParameter("userAddress"));
//        System.out.println(request.getParameter("userAddress"));
        user.setType(Integer.valueOf(request.getParameter("userlei")));
//        System.out.println(user.toString());
        iuBiz.insertUser(user);

        request.getRequestDispatcher("userList.do").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
