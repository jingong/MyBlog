package cn.edu.ldu.action.user;

import cn.edu.ldu.POJO.Blog;
import cn.edu.ldu.POJO.Comment;
import cn.edu.ldu.POJO.Type;
import cn.edu.ldu.POJO.User;
import cn.edu.ldu.dao.user.LoginRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiajingong on 2017/4/15.
 */
public class LoginRegisterAction extends ActionSupport implements SessionAware{
    private User user;
    private Map<String, Object> session;
    private List<User> list;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //用户登录
    public String login(){
        String mess = "error";
        LoginRegisterInfo info = new LoginRegisterInfo();
        list = info.selectUser(user);
        if (list != null){
            user = list.get(0);
            mess = SUCCESS;
            if (mess.equals(SUCCESS)){
                List<Type> tlist = new ArrayList<>();
                tlist = info.selectAllType(user.getUserName());
                int typeCount = tlist.size();
                int blogCount = info.selectBlogCount();
                int visitorCount = info.selectVisitorCount();
                int commentCount = info.selectCommentCount();
                session.put("tlist",tlist);//把博客类型保存到session中
                session.put("typeCount",typeCount);
                session.put("blogCount",blogCount);
                session.put("visitorCount",visitorCount);
                session.put("commentCount",commentCount);
                session.put("user",user);
            }
        }
        return mess;
    }


    private void updatJsonFile() {

        String path = ServletActionContext.getServletContext().getRealPath("/") + "user/info/myinfo.json";
        File file = new File(path);
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String info = getJson(user);//得到json字符串
        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(file));
            ps.println(info);// 往文件里写入字符串
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            ps.close();
        }

    }
    //利用User类生成json字符串
    private String getJson(User user){
        JSONObject info = new JSONObject();
        info.put("total",7);
        JSONArray row = new JSONArray();
        //把下面的7个JSONObject存入到row中
        JSONObject item = new JSONObject();
        //1
        item.put("name","Name");
        item.put("value",user.getUserName());
        item.put("group","ID Settings");
        item.put("editor","text");
        row.add(item);
        //2
        item.put("name","Address");
        item.put("value",user.getAddress());
        item.put("group","ID Settings");
        item.put("editor","text");
        row.add(item);
        //3
        item.put("name","Age");
        item.put("value","");
        item.put("group","ID Settings");
        item.put("editor","numberbox");
        row.add(item);
        //4
        item.put("name","Birthday");
        item.put("value",user.getBirth().toString());
        item.put("group","ID Settings");
        item.put("editor","datebox");
        row.add(item);
        //5
        item.put("name","SSN");
        item.put("value","111111");
        item.put("group","ID Settings");
        item.put("editor","text");
        row.add(item);
        //6
        item.put("name","Email");
        item.put("value","jiajingong@163.com");
        item.put("group","Marketing Settings");
        JSONObject item1 = new JSONObject();
        item1.put("type","validatebox");
        JSONObject item2 = new JSONObject();
        item2.put("validType","email");
        item1.put("options",item2);
        item.put("editor",item1);
        row.add(item);
        //7
        item.put("name","FrequentBuyer");
        item.put("value","false");
        item.put("group","Marketing Settings");
        item1 = new JSONObject();
        item1.put("type","checkbox");
        item2 = new JSONObject();
        item2.put("on",true);
        item2.put("off",false);
        item1.put("options",item2);
        item.put("editor",item1);
        row.add(item);
        info.put("rows",row);
        return info.toString();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
