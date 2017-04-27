package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.User;
import cn.edu.ldu.dao.user.BlogInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.*;
import java.util.Map;

/**
 * Created by jiajingong on 2017/4/19.
 */
public class AddBlogAction extends ActionSupport implements SessionAware {
    private Blog blog;
    private Map<String, Object> session;
    private String mess = "error";
    private File upload;
    private String uploadFileName; //文件名称

    public Blog getBlog() {
        return blog;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = session;
    }
    //增加博客
    public String addBlog() throws Exception{
        //User user = (User)session.get("user");
        String filePath = ServletActionContext.getServletContext().getRealPath("/upload/") + "jia";
        File f = new File(filePath);
        if (!f.exists() || !f.isDirectory()) {
            f.mkdir();
        }
        InputStream is = new FileInputStream(upload);
        OutputStream os = new FileOutputStream(new File(filePath, getUploadFileName()));
        byte[] buffer = new byte[1024];
        int length = 0;
        while((length = is.read(buffer)) > 0)
        {
            os.write(buffer,0,length);
        }
        os.close();
        is.close();
        BlogInfo info = new BlogInfo();
        blog.setPicture(getUploadFileName());
        mess = info.addBlog(blog);
        return mess;
    }
}
