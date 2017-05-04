package cn.edu.ldu.action.visitor;

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
 * Created by jiajingong on 2017/5/2.
 */
public class LookBlogAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private int page;
    private String mess = "error";
    private int tid;
    private int id;//此id是用于查看查看当前id下的所有评论用的
    private List<Comment> clist;//
    private Blog blog;//存放当前查看的博客的信息

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getClist() {
        return clist;
    }

    public void setClist(List<Comment> clist) {
        this.clist = clist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String lookBlogsByPage() throws Exception{
        tid = Integer.parseInt(session.get("type").toString());
        PageBean blogPage = getPageBean(2,page);
        if (blogPage != null){
            session.put("blogPage",blogPage);
            mess = SUCCESS;
        }
        return mess;
    }
    public String lookBlogByType() throws Exception{
        session.put("type",tid);//把要查看的博客类型保存到session中
        PageBean blogPage = getPageBean(2,page);
        if (blogPage != null){
            session.put("blogPage",blogPage);
            mess = SUCCESS;
        }
        return mess;
    }

    public String lookCommentsById(){
        CommentInfo info = new CommentInfo();
        clist = info.selectComments(getId());
        BlogInfo info1 = new BlogInfo();
        blog = info1.getBlog(getId());
        if (blog != null)
            mess = SUCCESS;
        return mess;
    }

    public PageBean getPageBean(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();
        String hql = "from Blog as b where b.userName=:userName and b.type.tid=:tid";
        BlogInfo info = new BlogInfo();
        int allRows = info.getAllRowCountVis(hql,"jia",getTid());
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Blog> list = info.queryByPageVis(hql, offset, pageSize,"jia",getTid());
        pageBean.setBloglist(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
