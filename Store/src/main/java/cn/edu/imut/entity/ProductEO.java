package cn.edu.imut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by di_dong on 2017/6/14.
 */
@Entity
@Table(name = "T_PRODUCTS")
public class ProductEO implements Serializable {

    private final static long serialVersionUID =1L;

    @Id
    @Column(name = "IDENTIFICATION")
    private Long identification;//产品编号
    @Column(name = "NAME")
    private String name;//产品名称
    @Column(name="ADDEDDATE")
    private Date addedDate;//上架日期
    @Column(name = "PRICE")
    private BigDecimal price;//价格
    @Column(name = "TYPE")
    private Long type;//产品所属类型
    @Column(name = "BRAND")
    private  String brand;//品牌
    @Column(name = "REPERTORY")
    private  Long repertory;//商品库存
    @Column(name = "DETAIL")
    private  String detail;//详情信息


    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getRepertory() {
        return repertory;
    }

    public void setRepertory(Long repertory) {
        this.repertory = repertory;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    @Override
    public String toString() {
        return "Product{" +
                "identification=" + identification +
                ", name='" + name + '\'' +
                ", addedDate=" + addedDate +
                ", price=" + price +
                ", type=" + type +
                ", brand='" + brand + '\'' +
                ", repertory=" + repertory +
                ", detail='" + detail + '\'' +
                '}';
    }
}
