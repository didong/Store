package cn.edu.imut.Contorller;

import cn.edu.imut.bean.dto.PageRequest;
import cn.edu.imut.bean.dto.ProductRequest;
import cn.edu.imut.bean.model.ProductDetailModel;
import cn.edu.imut.bean.model.ProductModel;
import cn.edu.imut.interfaces.ProductService;
import cn.edu.imut.utils.WebReturnUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by di_dong on 2017/5/16.
 */
@Controller
@RequestMapping("/api/product")
public class ProductContorlloer {

    private Logger logger = LoggerFactory.getLogger(ProductContorlloer.class);

    @Autowired
    private ProductService productService;

    /**
     * 获取最新商品信息
     */
    @RequestMapping(value = "/loadNewestProduct",method = RequestMethod.POST)
    public @ResponseBody JSONObject loadNewestProduct(){
        List<ProductModel> products =  productService.loadNewestProduct();
        if(CollectionUtils.isEmpty(products)){
            return   WebReturnUtils.failure("无商品信息");
        }
        return WebReturnUtils.success(products);
    }

    /**
     * 通过商品编号获取商品详情
     */
    @RequestMapping(value = "/loadProductDetail",method = RequestMethod.POST)
    public @ResponseBody JSONObject loadProductDetail(@RequestBody ProductRequest productRequest){
        String identification = productRequest.getIdentification();
        ProductDetailModel productsDetail =  productService.loadProductDetail(Long.parseLong(identification));
        if(productsDetail == null){
            return   WebReturnUtils.failure("无该商品详情信息");
        }
        return WebReturnUtils.success(productsDetail);
    }


    /**
     * 根据信息跳转页面
     */
    @RequestMapping(value = "/loadProductByPage",method = RequestMethod.POST)
    public @ResponseBody JSONObject loadProductDetail(@RequestBody PageRequest pageRequest){

        List<ProductModel> products =  productService.loadProductByPageAndType(pageRequest.getType(),pageRequest.getPageNumber());
        if(CollectionUtils.isEmpty(products)){
            return   WebReturnUtils.failure("无商品信息");
        }
        return WebReturnUtils.success(products);
    }
}
