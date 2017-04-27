package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.User;
import cn.edu.ldu.dao.user.UpdateUserInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by jiajingong on 2017/4/18.
 */
public class UpdatePasswordAction extends ActionSupport implements SessionAware {
    private String password;
    private String password1;
    private Map<String, Object> session;
    private String mess = "error";
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    //修改密码
    public String changePass(){
        if (password.equals(password1)){
            UpdateUserInfo info = new UpdateUserInfo();
            int id = ((User)session.get("user")).getId();
            mess = info.updatePassword(id,password);
        }
        return mess;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
