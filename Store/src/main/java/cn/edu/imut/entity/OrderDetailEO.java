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
@Table(name = "T_ORDERDETAIL")
public class OrderDetailEO implements Serializable{

    private final static long serialVersionUID =1L;

    @Id
    @Column(name="IDENTIFICATION")
    private String identification;//商品
    @Column(name = "ORDERID")
    private BigDecimal orderId;//订单编号

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }
}
