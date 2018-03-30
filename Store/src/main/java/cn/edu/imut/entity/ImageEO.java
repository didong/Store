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
@Table(name = "T_IMAGE")
public class ImageEO implements Serializable{

    private final static long serialVersionUID =1L;

    @Id
    @Column(name="IMAGER_ID")
    private String imageId;//图片id
    @Column(name = "PATH")
    private String path;//图片保存路径
    @Column(name = "PRODUCT_ID")
    private Long productId;//图片所属商品编号

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
