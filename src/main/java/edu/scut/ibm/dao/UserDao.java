package edu.scut.ibm.dao;

import edu.scut.ibm.bean.User;

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
}
