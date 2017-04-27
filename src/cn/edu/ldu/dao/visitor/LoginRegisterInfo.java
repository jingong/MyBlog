package cn.edu.ldu.dao.visitor;

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
