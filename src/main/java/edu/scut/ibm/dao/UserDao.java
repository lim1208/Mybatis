package edu.scut.ibm.dao;

import edu.scut.ibm.bean.User;

import java.util.List;

/**
 * Created by limin on 2017/4/3.
 */
public interface UserDao {
    /**
     * 根据用户ID号查询用户信息
     * @param id
     * @return
     */
    public User selectUserByID(int id);

    /**
     * 根据用户名获取所有用户信息
     * @param userName
     * @return
     */
    public List<User> selectUsers(String userName);

    /**
     * 增加用户信息
     * @param user
     */
    public void addUser(User user);

    /**
     * 根据用户ID号删除用户信息
     * @param id
     */
    public void deleteUser(int id);
}
