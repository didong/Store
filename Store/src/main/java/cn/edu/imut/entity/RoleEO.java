package cn.edu.imut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by di_dong on 2017/5/22.
 */
@Entity
@Table(name = "T_ROLE")
public class RoleEO implements Serializable{

    private final static long serialVersionUID =1L;

   @Id
    @Column(name = "ROLEID")
    private String roleId;//用户名
    @Column(name = "NAME")
    private String name;//密码


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
