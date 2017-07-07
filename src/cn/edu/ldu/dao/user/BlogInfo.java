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
 * Created by jiajingong on 2017/4/19.
 */
public class BlogInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    public BlogInfo() {
    }
    //保存信息
    public String addBlog(Blog blog){
        String mess = "error";
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            String hql = "from User as u where u.userName=:userName";
            query = session.createQuery(hql);
            query.setParameter("userName",blog.getUser().getUserName());
            int id = ((User)query.list().get(0)).getId();
            blog.getUser().setId(id);
            session.save(blog);
            transaction.commit();
            mess = "success";
            return mess;
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            message("addBlog.error:" + e.getMessage());
            e.printStackTrace();
        }
        return mess;
    }
    //得到总条数
    public int getAllRowCountVis(String hql,String userName,int tid)
    {
        session = HibernateSessionFactory.getSession();
        int allRows = 0;
        try
        {
            transaction = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("userName",userName);
            query.setParameter("tid",tid);
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
    }//使用hibernate提供的分页功能，得到分页显示的数据
    public List<Blog> queryByPage(String hql,int offset,int pageSize)
    {
        session = HibernateSessionFactory.getSession();
        List<Blog> list = null;
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
    //使用hibernate提供的分页功能，得到分页显示的数据
    public List<Blog> queryByPageVis(String hql,int offset,int pageSize,String userName,int tid)
    {
        session = HibernateSessionFactory.getSession();
        List<Blog> list = null;
        try
        {
            transaction = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("userName",userName);
            query.setParameter("tid",tid);
            query.setFirstResult(offset).setMaxResults(pageSize);
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
    //更新博客
    public String updateBlog(Blog blog){
        session = HibernateSessionFactory.getSession();
        String mess = "error";
        try {
            transaction = session.beginTransaction();
            Blog b = (Blog)session.load(Blog.class,blog.getId());
            b.setContent(blog.getContent());
            b.setPicture(blog.getPicture());
            b.setTime(blog.getTime());
            b.setTitle(blog.getTitle());
            b.setType(blog.getType());
            b.setUser(blog.getUser());
            session.update(b);
            transaction.commit();
            mess = "success";
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            message("updateStudnet.error" + e.getMessage());
            e.printStackTrace();
        }
        return mess;
    }
    //得到要更新的博客
    public Blog getBlog(int id){
        session = HibernateSessionFactory.getSession();
        try {
            transaction = session.beginTransaction();
            Blog blog = (Blog)session.get(Blog.class,id);
            transaction.commit();
            return blog;
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
            message("getUpdateBlog.error:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    //模糊查询
    public List<Blog> fuzzyQuery(String keywords){
        session = HibernateSessionFactory.getSession();
        try {
            String hql = "from Blog as b where b.title like '%"+keywords+"%'";
            transaction = session.beginTransaction();
            query = session.createQuery(hql);
            List<Blog> list = query.list();
            transaction.commit();
            return list;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            message("fuzzyQuery.error" + e.getMessage());
            return null;
        }
    }
    //根据id删除博客
    public String deleteBlogById(int[] delid){
        session = HibernateSessionFactory.getSession();
        String mess = "";
        try {
            transaction = session.beginTransaction();
            for (int i = 0;i < delid.length;i ++){
                Blog blog = (Blog)session.get(Blog.class,delid[i]);
                session.delete(blog);
            }
            transaction.commit();
            mess = "success";
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            message("deleteBlogById.error" + e.getMessage());
            mess = "error";
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
