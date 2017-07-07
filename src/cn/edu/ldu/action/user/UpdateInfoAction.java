package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.User;
import cn.edu.ldu.dao.user.UpdateUserInfo;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by jiajingong on 2017/4/18.
 */
public class UpdateInfoAction extends ActionSupport implements SessionAware {
    private Map<String, Object> session;
    private User user;
    private String mess;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //更新用户的信息
    public String update(){
        mess = "error";
        UpdateUserInfo info = new UpdateUserInfo();
        int id = ((User)session.get("user")).getId();
        user.setId(id);
        mess = info.updateUser(user);
        if (mess.equals(SUCCESS)){//如果数据更新成功，更新session里面保存的user
            session.put("user",user);
        }
        return mess;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
