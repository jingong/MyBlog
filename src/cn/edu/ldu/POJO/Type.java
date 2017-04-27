package cn.edu.ldu.POJO;

import javax.persistence.*;

/**
 * Created by jiajingong on 2017/4/19.
 */
@Entity
@Table(name = "type")
public class Type {
    private int tid;
    private String userName;
    private String type;

    @Id
    @Column(name = "tid", nullable = false)
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type1 = (Type) o;
        if (tid != type1.tid) return false;
        if (userName != null ? !userName.equals(type1.userName) : type1.userName != null) return false;
        if (type != null ? !type.equals(type1.type) : type1.type != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
