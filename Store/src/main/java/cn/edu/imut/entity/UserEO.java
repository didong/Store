package cn.edu.imut.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by di_dong on 2017/5/22.
 */
@Entity
@Table(name = "T_USER")
//@SequenceGenerator(name = "userSequence" , sequenceName = "SEQ_T_USER",allocationSize = 1)
public class UserEO implements Serializable{

    private final static long serialVersionUID =1L;


   @Id
    @Column(name = "USERNAME")
    private String userName;//用户名
    @Column(name = "PASSWORD")
    private String passWord;//密码
    @Column(name="NICKNAME")
    private String nickName;//昵称
    @Column(name = "EMAIL")
    private String email;//邮箱地址
    @Column(name = "PHONE")
    private String phoneNumber;//电话号码
    @Column(name = "ROLE_ID")
    private  Long roleId;//角色外键


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
