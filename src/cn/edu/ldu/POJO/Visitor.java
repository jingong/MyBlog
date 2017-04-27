package cn.edu.ldu.POJO;

import javax.persistence.*;
import java.lang.annotation.Retention;

/**
 * Created by jiajingong on 2017/4/14.
 */
@Entity
public class Visitor {
    private int id;
    private String visName;
    private String visPassword;
    private String visPassword1;
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "visName", nullable = true, length = 30)
    public String getVisName() {
        return visName;
    }

    public void setVisName(String visName) {
        this.visName = visName;
    }

    @Basic
    @Column(name = "visPassword", nullable = true, length = 30)
    public String getVisPassword() {
        return visPassword;
    }

    public void setVisPassword(String visPassword) {
        this.visPassword = visPassword;
    }

    @Transient
    public String getVisPassword1() {
        return visPassword1;
    }

    public void setVisPassword1(String visPassword1) {
        this.visPassword1 = visPassword1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        if (id != visitor.id) return false;
        if (visName != null ? !visName.equals(visitor.visName) : visitor.visName != null) return false;
        if (visPassword != null ? !visPassword.equals(visitor.visPassword) : visitor.visPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (visName != null ? visName.hashCode() : 0);
        result = 31 * result + (visPassword != null ? visPassword.hashCode() : 0);
        return result;
    }
}
