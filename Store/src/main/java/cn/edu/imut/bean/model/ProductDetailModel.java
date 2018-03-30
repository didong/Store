package cn.edu.imut.bean.model;

import java.util.List;

/**
 * Created by di_dong on 2017/6/14.
 */
public class ProductDetailModel {

    private String identification;//产品编号
    private String name;//产品名称
    private String price;//价格
    private List<String> images;//商品图片
    private String detail;//商品详情

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ProductDetailModel{" +
                "identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", images=" + images +
                ", detail='" + detail + '\'' +
                '}';
    }
}
