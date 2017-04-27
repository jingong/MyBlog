package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.bean.PageBean;
import cn.edu.ldu.dao.user.BlogInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by jiajingong on 2017/4/19.
 */
public class LookBlogAction extends ActionSupport implements SessionAware,RequestAware{
    private int page;
    private Map<String, Object> session;
    private Map<String, Object> request;
    private String mess = "error";
    private String keywords;

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

    @Override
    public String execute() throws Exception {
        int page = Integer.parseInt(request.get("page").toString());
        PageBean pageBean = getPageBean(5, page);
        if (pageBean != null){
            session.put("pageBean",pageBean);
            mess = SUCCESS;
        }
        return mess;
    }
    //模糊查询
    public String fuzzyQueryBlog() throws Exception{
        System.out.println("模糊查询的Action已经执行...");
        PageBean pageBean = getFuzzyPageBean(5,page,keywords);
        if (pageBean != null){
            session.put("pageBean",pageBean);
            mess = SUCCESS;
        }
        return mess;
    }

    public PageBean getFuzzyPageBean(int pageSize, int page,String keywords)
    {
        PageBean pageBean = new PageBean();
        String hql = "from Blog as b where b.title like '%"+keywords+"%'";
        BlogInfo info = new BlogInfo();
        int allRows = info.getFuzzyAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Blog> list = info.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
    public PageBean getPageBean(int pageSize, int page)
    {
        PageBean pageBean = new PageBean();
        String hql = "from Blog";
        BlogInfo info = new BlogInfo();
        int allRows = info.getAllRowCount(hql);
        int totalPage = pageBean.getTotalPages(pageSize, allRows);
        int currentPage = pageBean.getCurPage(page);
        int offset = pageBean.getCurrentPageOffset(pageSize, currentPage);
        List<Blog> list = info.queryByPage(hql, offset, pageSize);
        pageBean.setList(list);
        pageBean.setAllRows(allRows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
}
