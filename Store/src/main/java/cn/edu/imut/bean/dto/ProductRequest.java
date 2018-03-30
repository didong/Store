package cn.edu.imut.bean.dto;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by di_dong on 2017/6/14.
 */
public class ProductRequest {
    private String identification;//产品编号
    private String name;//产品名称
    private String price;//价格
    private String type;//产品所属类型
    private  String brand;//品牌
    private  String repertory;//商品库存
    private  String detail;//详情信息
    private String imagePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRepertory() {
        return repertory;
    }

    public void setRepertory(String repertory) {
        this.repertory = repertory;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", repertory='" + repertory + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
