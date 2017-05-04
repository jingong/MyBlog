package cn.edu.ldu.POJO;

import javax.persistence.*;

/**
 * Created by jiajingong on 2017/4/28.
 */
@Entity
public class Skills {
    private int id;
    private String skill;
    private User user;
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "skill", nullable = true, length = 255)
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        if (id != skills.id) return false;
        if (skill != null ? !skill.equals(skills.skill) : skills.skill != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        return result;
    }
}
