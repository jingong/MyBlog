package cn.edu.ldu.dao.user;

import cn.edu.ldu.POJO.User;
import cn.edu.ldu.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

/**
 * Created by jiajingong on 2017/4/18.
 */
public class UpdateUserInfo {
    private Session session;
    private Transaction transaction;
    private Query query;

    public UpdateUserInfo() {
    }

    public String updateUser(User user){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "update User as u set u.userName=:userName,u.name=:name,u.birth=:birth,u.address=:address,u.work=:work,u.description=:description where u.id=:id";
            transaction = session.beginTransaction();
            query = session.createQuery(hqlsql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("name",user.getName());
            query.setParameter("birth",user.getBirth());
            query.setParameter("address",user.getAddress());
            query.setParameter("work",user.getWork());
            query.setParameter("description",user.getDescription());
            query.setParameter("id",user.getId());
            int flag = query.executeUpdate();
            System.out.println("数据更新成功：" + flag);
            transaction.commit();
            if (flag > 0){
                mess = "success";
            }
        } catch (Exception e) {
            message("updateUser.error" + e.getMessage());
            e.printStackTrace();
        }
        return mess;
    }
    public String updatePassword(int id,String password){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            String hqlsql = "update User as u set u.password=:password where u.id=:id";
            transaction = session.beginTransaction();
            query = session.createQuery(hqlsql);
            query.setParameter("password", password);
            query.setParameter("id",id);
            int flag = query.executeUpdate();
            transaction.commit();
            if (flag > 0){
                mess = "success";
            }
        } catch (Exception e) {
            message("updateUser.error" + e.getMessage());
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
