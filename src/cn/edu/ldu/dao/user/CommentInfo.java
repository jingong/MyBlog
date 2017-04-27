package cn.edu.ldu.dao.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Comment;
import cn.edu.ldu.factory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by jiajingong on 2017/4/26.
 */
public class CommentInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    public CommentInfo() {
    }
    //得到总条数
    public int getAllRowCount(String hql)
    {
        session = HibernateSessionFactory.getSession();
        int allRows = 0;
        try
        {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            allRows = query.list().size();
            transaction.commit();

        }
        catch (Exception e)
        {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return allRows;
    }
    //得到模糊查询的总条数
    public int getFuzzyAllRowCount(String hql)
    {
        session = HibernateSessionFactory.getSession();
        int allRows = 0;
        try
        {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            allRows = query.list().size();
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return allRows;
    }
    //根据id删除博客
    public String deleteCommentById(int[] delid){
        session = HibernateSessionFactory.getSession();
        String mess = "";
        try {
            transaction = session.beginTransaction();
            for (int i = 0;i < delid.length;i ++){
                Comment comment = (Comment)session.get(Comment.class,delid[i]);
                session.delete(comment);
            }
            transaction.commit();
            mess = "success";
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            mess = "error";
        }
        return mess;
    }
    //使用hibernate提供的分页功能，得到分页显示的数据
    public List<Comment> queryByPage(String hql, int offset, int pageSize)
    {
        session = HibernateSessionFactory.getSession();
        List<Comment> list = null;
        try
        {
            transaction = session.beginTransaction();
            query = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize);
            list = query.list();
            transaction.commit();
        }
        catch (Exception e)
        {
            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
