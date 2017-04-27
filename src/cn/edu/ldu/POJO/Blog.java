package cn.edu.ldu.POJO;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by jiajingong on 2017/4/25.
 */
@Entity
public class Blog {
    private int id;
    private String userName;
    private String title;
    private String content;
    private String picture;
    private Date time;
    private Type type;
    @ManyToOne
    @JoinColumn
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 255)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blog blog = (Blog) o;

        if (id != blog.id) return false;
        if (userName != null ? !userName.equals(blog.userName) : blog.userName != null) return false;
        if (title != null ? !title.equals(blog.title) : blog.title != null) return false;
        if (content != null ? !content.equals(blog.content) : blog.content != null) return false;
        if (picture != null ? !picture.equals(blog.picture) : blog.picture != null) return false;
        if (time != null ? !time.equals(blog.time) : blog.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
