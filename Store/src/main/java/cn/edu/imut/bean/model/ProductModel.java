package cn.edu.imut.bean.model;


/**
 * Created by di_dong on 2017/6/14.
 */
public class ProductModel {

    private String identification;//产品编号
    private String name;//产品名称
    private String price;//价格
    private String Image;//商品图片

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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "identification='" + identification + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", Image='" + Image + '\'' +
                '}';
    }
}
