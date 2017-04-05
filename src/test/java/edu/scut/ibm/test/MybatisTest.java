package edu.scut.ibm.test;

import edu.scut.ibm.bean.User;
import edu.scut.ibm.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created by limin on 2017/4/2.
 */
public class MybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public void getAllUser(String username){
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.selectUsers(username);
        for(User user : users){
            System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserAddress());
        }
    }

    public void addUser(){
        User user=new User();
        user.setUserAddress("人民广场");
        user.setUserName("飞鸟");
        user.setUserAge(80);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserDao userDao=session.getMapper(UserDao.class);
            userDao.addUser(user);
            session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }

    public void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        userDao.deleteUser(id);
        session.commit();
        System.out.println("删除用户ID为"+id+"的用户");
    }

    public static void main(String[] args) {
        MybatisTest mybatisTest = new MybatisTest();
        mybatisTest.getAllUser("s%");
//        mybatisTest.addUser();
        mybatisTest.deleteUser(6);
//        SqlSession session = sqlSessionFactory.openSession();
//        try {
//            UserDao userDao = session.getMapper(UserDao.class);
//            User user = userDao.selectUserByID(1);
//            System.out.println(user.getUserAddress());
//            System.out.println(user.getUserName());
//        } finally {
//            session.close();
//        }
    }
}
