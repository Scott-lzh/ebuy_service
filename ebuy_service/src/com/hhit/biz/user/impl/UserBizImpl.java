package com.hhit.biz.user.impl;

import com.hhit.biz.user.IUserBiz;
import com.hhit.dao.user.IUserDao;
import com.hhit.dao.user.impl.UserDaoImpl;
import com.hhit.vo.user.User;

import java.util.List;

public class UserBizImpl implements IUserBiz {
    //创建UserDao对象
    IUserDao iudao = new UserDaoImpl();

    @Override
    public List<User> getUserDetails() {
        List<User> userList = iudao.findAllUser();
        return userList;
    }

    @Override
    public List<User> getUserDetails(int pageNo, int pageSize) {
        List<User> userList = iudao.findAllUser(pageNo, pageSize);
        return userList;
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> userList = iudao.findUserByName(name);
        return userList;
    }

    @Override
    public User findUserByName(String name) {
        User user = iudao.getUserByName(name);
        return user;
    }

    @Override
    public String getUserByWher(String name, String pwd) {
        String uname = iudao.getUserByWher(name, pwd);
        return uname;
    }

    @Override
    public int insertUser(User user) {
        int i = iudao.addUser(user);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = iudao.updateUser(user);
        return i;
    }

    @Override
    public int delUser(int id) {
        int i = iudao.deleteUserById(id);
        return i;
    }

    @Override
    public int findUserCount() {
        int userNumer = iudao.findUserNumer();
        return userNumer;
    }
}
