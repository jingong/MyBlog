package cn.edu.ldu.action.user;

import cn.edu.ldu.dao.user.BlogInfo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by jiajingong on 2017/4/25.
 */
public class DeleteBlogAction extends ActionSupport {
    private int[] delid;
    private String mess = "error";
    public int[] getDelid() {
        return delid;
    }

    public void setDelid(int[] delid) {
        this.delid = delid;
    }

    @Override
    public String execute() throws Exception {
        BlogInfo info = new BlogInfo();
        mess = info.deleteBlogById(delid);
        return mess;
    }
}
