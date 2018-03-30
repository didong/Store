package cn.edu.imut.interfaces;

import cn.edu.imut.bean.dto.ProductRequest;
import cn.edu.imut.bean.model.ProductDetailModel;
import cn.edu.imut.bean.model.ProductModel;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by di_dong on 2017/5/27.
 */
public interface ProductService {
    /**
     * 加载最新商品
     */
    List<ProductModel> loadNewestProduct();

    /**
     * 加载分页商品
     */
    List<ProductModel> loadProductByPageAndType(String type,String page);

    /**
     * 通过商品id加载商品详情
     */
    ProductDetailModel loadProductDetail(Long productId);

    /**
     * 保存商品信息
     */
    void save(ProductRequest productRequest);

}
