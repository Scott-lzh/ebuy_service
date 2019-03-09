package com.hhit.biz.user;

import com.hhit.vo.user.User;

import java.util.List;

public interface IUserBiz {
    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> getUserDetails();
    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> getUserDetails(int pageNo, int pageSize);

    /**
     * 根据姓名模糊查询用户
     *
     * @param name
     * @return
     */
    List<User> getUserByName(String name);

    /**
     * 根据用户名找到User对象
     *
     * @param name
     * @return
     */
    User findUserByName(String name);

    /**
     * 根据登录信息判断登录
     *
     * @param name
     * @param pwd
     * @return
     */
    String getUserByWher(String name, String pwd);

    /**
     * 根据用户对象添加用户
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户对象修改用户
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int delUser(int id);

    /**
     * 计算用户数量
     * @return
     */
    int findUserCount();
}
