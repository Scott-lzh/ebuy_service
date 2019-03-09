package com.hhit.dao.user.impl;

import com.hhit.dao.BaseDao;
import com.hhit.dao.user.IUserDao;
import com.hhit.vo.user.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl extends BaseDao implements IUserDao {
    @Override
    public List<User> findAllUser() {
        //创建用户对象
        User user = null;
        //创建用户列表集合
        List<User> userList = new ArrayList<>();
        //编写SQL命令
        String sql = "select eb_userid, eb_username,eb_userpwd, eb_usersex, eb_userage, eb_usertel," +
                " eb_usertype, eb_usercredit from eb_user";
        //创建参数数组
        Object[] params = null;
        // 调用查询方法获得结果集
        res = super.executeSelect(sql, params);
        // 解析结果集
        try {
            while (res.next()) {
                // 封装数据对象
                user = new User();
                user.setId(res.getInt("eb_userid"));
                user.setName(res.getString("eb_username"));
                user.setPwd(res.getString("eb_userpwd"));
                user.setSex(res.getString("eb_usersex"));
                user.setAge(res.getInt("eb_userage"));
                user.setTel(res.getString("eb_usertel"));
                user.setType(res.getInt("eb_usertype"));
                user.setCredit(res.getInt("eb_usercredit"));
                //将对象放入集合
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return userList;
    }

    @Override
    public List<User> findAllUser(int pageNo, int pageSize) {
        //创建用户对象
        User user = null;
        //创建用户列表集合
        List<User> userList = new ArrayList<>();
        //编写SQL命令
        String sql = "select * FROM( " +
                "select u.*,ROWNUM rn FROM ( " +
                "select eb_userid, eb_username,eb_userpwd, eb_usersex, eb_userage," +
                " eb_usertel,eb_usertype, eb_usercredit " +
                "FROM eb_user ) u" +
                " where rownum<=(?*?) ) where rn>(?-1)*?";
        Object[] params = {pageNo, pageSize, pageNo, pageSize};
        res = super.executeSelect(sql, params);
        // 解析结果集
        try {
            while (res.next()) {
                // 封装数据对象
                user = new User();
                user.setId(res.getInt("eb_userid"));
                user.setName(res.getString("eb_username"));
                user.setPwd(res.getString("eb_userpwd"));
                user.setSex(res.getString("eb_usersex"));
                user.setAge(res.getInt("eb_userage"));
                user.setTel(res.getString("eb_usertel"));
                user.setType(res.getInt("eb_usertype"));
                user.setCredit(res.getInt("eb_usercredit"));
                //将对象放入集合
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return userList;
    }

    @Override
    public List<User> findUserByName(String name) {
        //创建用户对象
        User user = null;
        //创建用户列表集合
        List<User> userList = new ArrayList<>();
        //编写SQL命令
        String sql = " select eb_userid, eb_username, eb_userpwd, eb_usersex, eb_userage," +
                " eb_usertel, eb_usertype, eb_usercredit " +
                " from eb_user where eb_username like CONCAT('%', CONCAT(?,'%'))";
        //创建参数数组
        Object[] params = {name};
        // 调用查询方法获得结果集
        res = super.executeSelect(sql, params);
        // 解析结果集
        try {
            while (res.next()) {
                // 封装数据对象
                user = new User();
                user.setId(res.getInt("eb_userid"));
                user.setName(res.getString("eb_username"));
                user.setPwd(res.getString("eb_userpwd"));
                user.setSex(res.getString("eb_usersex"));
                user.setAge(res.getInt("eb_userage"));
                user.setTel(res.getString("eb_usertel"));
                user.setType(res.getInt("eb_usertype"));
                user.setCredit(res.getInt("eb_usercredit"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return userList;
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        //编写SQL命令
        String sql = "select eb_userid, eb_username, eb_userpwd, eb_usersex, eb_userage, " +
                " eb_usertel, eb_usertype, eb_usercredit, eb_userbirth, eb_useraddress " +
                "from eb_user where eb_username = ?";
        //创建参数数组
        Object[] params = {name};
        // 调用查询方法获得结果集
        res = super.executeSelect(sql, params);
        // 解析结果集
        try {
            while (res.next()) {
                user = new User();
                user.setId(res.getInt("eb_userid"));
                user.setName(res.getString("eb_username"));
                user.setPwd(res.getString("eb_userpwd"));
                user.setSex(res.getString("eb_usersex"));
                user.setAge(res.getInt("eb_userage"));
                user.setTel(res.getString("eb_usertel"));
                user.setType(res.getInt("eb_usertype"));
                user.setCredit(res.getInt("eb_usercredit"));
                user.setBirth(res.getDate("eb_userbirth"));
                user.setAddress(res.getString("eb_useraddress"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        return user;
    }

    @Override
    public String getUserByWher(String name, String pwd) {
        User user = null;
        Object[] params = {name, pwd};
        String sql = "select eb_username name from eb_user where eb_username = ? and eb_userpwd = ? and eb_usertype != 3";
        res = super.executeSelect(sql, params);
        try {
            if (res.next()) {
                return res.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into eb_user " +
                "(eb_userid, eb_username, eb_userpwd, eb_usersex, eb_userage, " +
                "eb_usertel, eb_usertype, eb_usercredit, eb_userbirth, eb_useraddress) " +
                " values(?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        Object[] params = {user.getId(), user.getName(), user.getPwd(), user.getSex(), user.getAge(), user.getTel(), user.getType(), user.getCredit(), user.getBirth(), user.getAddress()};
        int i = super.executeEit(sql, params);
        return i;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update eb_user set " +
                " eb_username = ?, eb_usersex = ?, eb_userbirth = ?, eb_usertel = ?, " +
                " eb_usertype = ?, EB_USERADDRESS = ? where eb_userid = ?";
        Date d = new java.sql.Date(user.getBirth().getTime());
        Object[] params = {user.getName(), user.getSex(), d, user.getTel(), user.getType(), user.getAddress(), user.getId()};
        int i = super.executeEit(sql, params);
        return i;
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "delete from eb_user where eb_userid = ?";
        Object[] params = {id};
        int i = super.executeEit(sql, params);
        return i;
    }

    @Override
    public int findUserNumer() {
        int count = 0;
        String sql = "select count(1) count from eb_user";
        Object[] params = null;
        res = super.executeSelect(sql, params);
        try {
            if (res.next()) {
                count = res.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
