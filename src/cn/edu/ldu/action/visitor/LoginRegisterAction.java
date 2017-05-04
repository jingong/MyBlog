package cn.edu.ldu.action.visitor;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Skills;
import cn.edu.ldu.POJO.User;
import cn.edu.ldu.POJO.Visitor;
import cn.edu.ldu.dao.visitor.LoginRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by jiajingong on 2017/4/14.
 */
public class LoginRegisterAction extends ActionSupport implements SessionAware{
    private Visitor visitor;
    private String mess = "";
    private Map<String, Object> session;
    private List<Skills> slists;
    private List<Blog> bloglists;

    public List<Blog> getBloglists() {
        return bloglists;
    }

    public void setBloglists(List<Blog> bloglists) {
        this.bloglists = bloglists;
    }

    public List<Skills> getSlists() {
        return slists;
    }

    public void setSlists(List<Skills> slists) {
        this.slists = slists;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
    //游客登录方法
    public String login(){
        LoginRegisterInfo info = new LoginRegisterInfo();
        mess = info.selectVisitor(visitor);
        if (mess.equals(SUCCESS)){
            User user = info.selectUser("jia");
            slists = info.selectSkills("jia");
            bloglists = info.selectBlogs("jia");
            session.put("slist",slists);
            session.put("user",user);
            session.put("bloglists",bloglists);
            session.put("type",1);//登录成功时，把session保存的博客类型设置成1
        }
        return mess;
    }
    //游客注册方法
    public String register(){
        System.out.println("注册成功：" + visitor.getVisName() + "," + visitor.getVisPassword() + "," + visitor.getVisPassword1());
        LoginRegisterInfo info = new LoginRegisterInfo();
        mess = info.saveInfo(visitor);
        return mess;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
