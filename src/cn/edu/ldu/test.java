package cn.edu.ldu;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Comment;
import cn.edu.ldu.POJO.Type;
import cn.edu.ldu.POJO.User;
import cn.edu.ldu.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by jiajingong on 2017/4/25.
 */
public class test {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        Type type = new Type();
        type.setType("测试");
        session.save(type);
        transaction.commit();
    }
}
