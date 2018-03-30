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
@Table(name = "T_CART")
public class CartEO implements Serializable{

    private final static long serialVersionUID =1L;

    @Id
    @Column(name="USERNAME")
    private String userName;//用户名
    @Column(name = "IDENTIFICATION")
    private Long identification;//商品编号
    @Column(name = "COUNT")
    private Long count;//数量

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
