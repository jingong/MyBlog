package cn.edu.ldu.action.visitor;

import cn.edu.ldu.POJO.Visitor;
import cn.edu.ldu.dao.visitor.LoginRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by jiajingong on 2017/4/14.
 */
public class LoginRegisterAction extends ActionSupport{
    private Visitor visitor;
    private String mess = "";
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
        return mess;
    }
    //游客注册方法
    public String register(){
        System.out.println("注册成功：" + visitor.getVisName() + "," + visitor.getVisPassword() + "," + visitor.getVisPassword1());
        LoginRegisterInfo info = new LoginRegisterInfo();
        mess = info.saveInfo(visitor);
        return mess;
    }
}
