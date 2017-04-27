package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Comment;
import cn.edu.ldu.bean.PageBean;
import cn.edu.ldu.dao.user.BlogInfo;
import cn.edu.ldu.dao.user.CommentInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by jiajingong on 2017/4/26.
 */
public class LookCommentAction extends ActionSupport implements SessionAware{
    private int page;
    private Map<String, Object> session;
    private String keywords;
    private int[] delid;
    private String mess = "error";
    private int id;//Blog的id，主要是用于根据此id查找出所有的评论

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getDelid() {
        return delid;
    }

    public void setDelid(int[] delid) {
        this.delid = delid;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    //普通的查看
    public String lookByPage(){
        PageBean commentPageBean = getPageBean(5,page);
        if (commentPageBean != null){
            session.put("commentPageBean",commentPageBean);
            mess = SUCCESS;
        }
        return mess;
    }
    //模糊查询
    public String fuzzyQuery() throws Exception{
        System.out.println("模糊查询的Action已经执行...");
        PageBean commentPageBean = getFuzzyPageBean(5,page,keywords);
        if (commentPageBean != null){
            session.put("commentPageBean",commentPageBean);
            mess = SUCCESS;
        }
        return mess;
    }
    //根据Blog的id查看它的评论
    public String lookComments() throws Exception{
        PageBean pageBeanById = getPageBeanById(5,page);
        if (pageBeanById != null){
            session.put("pageBeanById",pageBeanById);
            mess = SUCCESS;
        }
        return mess;
    }
    //根据Blog的id得到PageBean
    public PageBean getPageBeanById(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();
        String hql = "from Comment as c where c.blog.id=" + getId();
        CommentInfo info = new CommentInfo();
        int allRows = info.getFuzzyAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Comment> clist1 = info.queryByPage(hql, offset, pageSize);
        pageBean.setClist1(clist1);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
    //得到模糊查询的PageBean
    public PageBean getFuzzyPageBean(int pageSize, int page,String keywords)
    {
        PageBean pageBean = new PageBean();
        String hql = "from Comment as c where c.content like '%"+keywords+"%'";
        CommentInfo info = new CommentInfo();
        int allRows = info.getFuzzyAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Comment> clist = info.queryByPage(hql, offset, pageSize);
        pageBean.setClist(clist);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
    //把选中的评论删除
    public String deleteComments() throws Exception{
        CommentInfo info = new CommentInfo();
        mess = info.deleteCommentById(delid);
        return mess;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public PageBean getPageBean(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();
        String hql = "from Comment";
        CommentInfo info = new CommentInfo();
        int allRows = info.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Comment> list = info.queryByPage(hql, offset, pageSize);
        pageBean.setClist(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
