package cn.edu.ldu.dao.visitor;

import cn.edu.ldu.POJO.*;
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

    public Visitor selectVisitor(Visitor visitor){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "from Visitor as v where v.visName=:visName and v.visPassword=:visPassword";
            query = session.createQuery(hqlsql);
            query.setParameter("visName", visitor.getVisName());
            query.setParameter("visPassword",visitor.getVisPassword());
            List<Visitor> list = query.list();
            transaction = session.beginTransaction();
            transaction.commit();
            return list.get(0);
        } catch (Exception e) {
            message("selectVisitor.error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    //得到博主的信息
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
    //得到博主的技能
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
    //得到博主的所有博客类型
    public List<Type> selectTypes(String userName){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hqlsql = "from Type as t where t.userName=:userName";
            query = session.createQuery(hqlsql);
            query.setParameter("userName", userName);
            List<Type> typelists = query.list();
            transaction.commit();
            return typelists;
        } catch (Exception e) {
            message("selectTypes.error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    //查询博主最前面的六个博客
    public List<Blog> selectBlogs(String userName){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hqlsql = "from Blog as b where b.user.userName=:userName";
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
