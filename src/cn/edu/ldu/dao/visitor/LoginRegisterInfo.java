package cn.edu.ldu.dao.visitor;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Skills;
import cn.edu.ldu.POJO.User;
import cn.edu.ldu.POJO.Visitor;
import cn.edu.ldu.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

/**
 * Created by jiajingong on 2017/4/14.
 */
public class LoginRegisterInfo {
    private Session session;
    private Transaction transaction;
    private Query query;

    public LoginRegisterInfo() {
    }

    public String selectVisitor(Visitor visitor){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "from Visitor as v where v.visName=:visName and v.visPassword=:visPassword";
            query = session.createQuery(hqlsql);
            query.setParameter("visName", visitor.getVisName());
            query.setParameter("visPassword",visitor.getVisPassword());
            List list = query.list();
            transaction = session.beginTransaction();
            transaction.commit();
            if (list.size() > 0){
                mess = "success";
            }
        } catch (Exception e) {
            message("selectVisitor.error" + e.getMessage());
            e.printStackTrace();
        }
        return mess;
    }
    public User selectUser(String userName){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hqlsql = "from User as u where u.userName=:userName";
            query = session.createQuery(hqlsql);
            query.setParameter("userName", userName);
            List<User> list = query.list();
            transaction.commit();
            return list.get(0);
        } catch (Exception e) {
            message("selectUser.error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Skills> selectSkills(String userName){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hqlsql = "from Skills as s where s.user.userName=:userName";
            query = session.createQuery(hqlsql);
            query.setParameter("userName", userName);
            List<Skills> slist = query.list();
            transaction.commit();
            return slist;
        } catch (Exception e) {
            message("selectUser.error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public List<Blog> selectBlogs(String userName){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hqlsql = "from Blog as b where b.userName=:userName";
            query = session.createQuery(hqlsql).setFirstResult(0).setMaxResults(6);
            query.setParameter("userName", userName);
            List<Blog> slist = query.list();
            transaction.commit();
            return slist;
        } catch (Exception e) {
            message("selectBlogs.error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    //保存信息
    public String saveInfo(Visitor visitor){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            session.save(visitor);
            transaction.commit();
            mess = "success";
            return mess;
        } catch (Exception e) {
            message("saveInfo.error:" + e.getMessage());
            e.printStackTrace();
        }
        return mess;
    }

    //出错的提示方法
    public void message(String mess) {
        int type = JOptionPane.YES_NO_OPTION;
        String title = "提示信息";
        JOptionPane.showMessageDialog(null, mess, title, type);
    }
}
