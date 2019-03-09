package com.hhit.dao.user;

import com.hhit.vo.user.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> findAllUser();
    /**
     * 分页查找所有用户
     *
     * @return
     */
    List<User> findAllUser(int pageNo, int pageSize);

    /**
     * 根据姓名模糊查询用户
     *
     * @param name
     * @return
     */
    List<User> findUserByName(String name);

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
    int addUser(User user);

    /**
     * 根据用户名获取User对象
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

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
    int deleteUserById(int id);

    /**
     * 查找用户数量
     * @return
     */
    int findUserNumer();
}
