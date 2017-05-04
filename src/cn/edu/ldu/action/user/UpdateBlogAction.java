package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.dao.user.BlogInfo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by jiajingong on 2017/4/25.
 */
public class UpdateBlogAction extends ActionSupport{
    private Blog blog;
    private String mess;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getUpdateBlog() throws Exception{
        BlogInfo info = new BlogInfo();
        blog = info.getBlog(id);//得到要更新的博客
        System.out.println("要更新的博客id:" + blog.getId());
        if (blog != null) {
            mess = SUCCESS;
        }
        return mess;
    }
    @Override
    public String execute() throws Exception {
        BlogInfo info = new BlogInfo();
        mess = info.updateBlog(blog);
        return mess;
    }
}
