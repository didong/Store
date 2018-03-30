package cn.edu.imut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by di_dong on 2017/5/22.
 */
@Entity
@Table(name = "T_INDENT")
public class IndentEO implements Serializable{

    private final static long serialVersionUID =1L;

    @Id
    @Column(name="ORDERID")
    private String orderId;//订单编号
    @Column(name = "PRICE")
    private BigDecimal price;//订单价格
    @Column(name = "USERNAME")
    private String userName;//用户名
    @Column(name = "ADDRESS")
    private String address;//送货地址

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
