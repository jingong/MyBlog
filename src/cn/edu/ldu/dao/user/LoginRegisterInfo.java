package cn.edu.ldu.dao.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Type;
import cn.edu.ldu.POJO.User;
import cn.edu.ldu.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

/**
 * Created by jiajingong on 2017/4/15.
 */
public class LoginRegisterInfo {
    private Session session;
    private Transaction transaction;
    private Query query;

    public LoginRegisterInfo() {
    }
    //查询用户名和密码
    public List<User> selectUser(User user){
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "from User as u where u.userName=:userName and u.password=:password";
            query = session.createQuery(hqlsql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("password",user.getPassword());
            List list = query.list();
            transaction = session.beginTransaction();
            transaction.commit();
            if (list.size() > 0){
                return list;
            }
        } catch (Exception e) {
            message("selectUser.error" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //保存信息
    public String saveUser(User user){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            mess = "success";
            return mess;
        } catch (Exception e) {
            message("saveUser.error:" + e.getMessage());
            e.printStackTrace();
        }
        return mess;
    }
    //查询所有的博客类型
    public List<Type> selectAllType(String userName){
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "from Type as t where t.userName=:userName";
            query = session.createQuery(hqlsql);
            query.setParameter("userName", userName);
            List list = query.list();
            transaction = session.beginTransaction();
            transaction.commit();
            if (list.size() > 0){
                return list;
            }
        } catch (Exception e) {
            message("selectAllType.error" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //查询所有的博客类型
    public List<Blog> selectAllBlog(String userName){
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "from Blog as b where b.userName=:userName";
            query = session.createQuery(hqlsql);
            query.setParameter("userName", userName);
            List list = query.list();
            transaction = session.beginTransaction();
            transaction.commit();
            if (list.size() > 0){
                return list;
            }
        } catch (Exception e) {
            message("selectAllBlog.error" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //查询所有博客的个数
    public int selectBlogCount(){
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hql = "from Blog";
            int count = session.createQuery(hql).list().size();
            transaction.commit();
            return count;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            message("selectBlogCount.error" + e.getMessage());
            return 0;
        }
    }
    //查询所有评论的个数
    public int selectCommentCount(){
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hql = "from Comment";
            int count = session.createQuery(hql).list().size();
            transaction.commit();
            return count;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            message("selectBlogCount.error" + e.getMessage());
            return 0;
        }
    }
    //查询所有游客的个数
    public int selectVisitorCount(){
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hql = "from Visitor ";
            int count = session.createQuery(hql).list().size();
            transaction.commit();
            return count;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            message("selectBlogCount.error" + e.getMessage());
            return 0;
        }
    }
    //出错的提示方法
    public void message(String mess) {
        int type = JOptionPane.YES_NO_OPTION;
        String title = "提示信息";
        JOptionPane.showMessageDialog(null, mess, title, type);
    }
}
