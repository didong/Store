package cn.edu.imut.service;

import cn.edu.imut.bean.dto.ProductRequest;
import cn.edu.imut.bean.model.ProductDetailModel;
import cn.edu.imut.bean.model.ProductModel;
import cn.edu.imut.entity.ImageEO;
import cn.edu.imut.entity.ProductEO;
import cn.edu.imut.interfaces.ProductService;
import cn.edu.imut.repository.ImageRepository;
import cn.edu.imut.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by di_dong on 2017/5/22.
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<ProductModel> loadNewestProduct() {
            try {
                List<ProductModel> productModels = new ArrayList<ProductModel>();
                List<ProductEO> productEOs = productRepository.findNewProducts8();
                for(ProductEO productEO:productEOs) {
                    ProductModel productModel = new ProductModel();
                    productModel.setIdentification(productEO.getIdentification() + "");
                    productModel.setName(productEO.getName());
                    productModel.setPrice(productEO.getPrice().toString());
                    ImageEO image = imageRepository.findByProductId(productEO.getIdentification()).get(0);
                    FileInputStream fileInputStream = new FileInputStream(image.getPath());
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    int len = 0;
                    byte b[] = new byte[1024];
                    while ((len = fileInputStream.read(b)) != -1) {
                        out.write(b,0,len);
                    }
                    BASE64Encoder base64Encoder = new BASE64Encoder();
                    productModel.setImage(base64Encoder.encode(out.toByteArray()));
                    productModels.add(productModel);
                }
                return productModels;
            }catch (Exception e){
                logger.info("获取失败!"+e.getMessage());
                return null;
            }
    }

    @Override
    public List<ProductModel> loadProductByPageAndType(String type, String page) {
        try {
            List<ProductModel> productModels = new ArrayList<ProductModel>();
            List<ProductEO> productEOs = productRepository.findNewProducts8();
            for(ProductEO productEO:productEOs) {
                ProductModel productModel = new ProductModel();
                productModel.setIdentification(productEO.getIdentification() + "");
                productModel.setName(productEO.getName());
                productModel.setPrice(productEO.getPrice().toString());
                ImageEO image = imageRepository.findByProductId(productEO.getIdentification()).get(0);
                FileInputStream fileInputStream = new FileInputStream(image.getPath());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int len = 0;
                byte b[] = new byte[1024];
                while ((len = fileInputStream.read(b)) != -1) {
                    out.write(b,0,len);
                }
                BASE64Encoder base64Encoder = new BASE64Encoder();
                productModel.setImage(base64Encoder.encode(out.toByteArray()));
                productModels.add(productModel);
            }
            return productModels;
        }catch (Exception e){
            logger.info("获取失败!"+e.getMessage());
            return null;
        }
    }

    @Override
    public ProductDetailModel loadProductDetail(Long productId) {
        try {
            ProductEO productEO = productRepository.findByIdentification(productId);
            ProductDetailModel productDetailModel = new ProductDetailModel();
            productDetailModel.setPrice(productEO.getPrice()+"");
            productDetailModel.setIdentification(productEO.getIdentification()+"");
            productDetailModel.setName(productEO.getName());
            List<String> images = new ArrayList<String>();
            List<ImageEO> imageEOList= imageRepository.findByProductId(productId);
            for (ImageEO imageEO:imageEOList){
                FileInputStream fileInputStream = new FileInputStream(imageEO.getPath());
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int len = 0;
                byte b[] = new byte[1024];
                while ((len = fileInputStream.read(b)) != -1) {
                    out.write(b,0,len);
                }
                BASE64Encoder base64Encoder = new BASE64Encoder();
                images.add(base64Encoder.encode(out.toByteArray()));
            }
            productDetailModel.setImages(images);
            return productDetailModel;
        }catch (Exception e){
            logger.info("获取失败!"+e.getMessage());
            return null;
        }
    }

    @Override
    public void save(ProductRequest productRequest) {
        try {
            ProductEO productEO = new ProductEO();
            ImageEO imageEO = new ImageEO();
            productEO.setName(productRequest.getName());
            productEO.setAddedDate(new Date());
            productEO.setDetail(productRequest.getDetail());
            productEO.setBrand(productRequest.getBrand());
            productEO.setIdentification(Long.parseLong(productRequest.getIdentification()));
            productEO.setType(Long.parseLong(productRequest.getType()));
            productEO.setPrice(new BigDecimal(productRequest.getPrice()));
            productEO.setRepertory(Long.parseLong(productRequest.getRepertory()));

            imageEO.setImageId(UUID.randomUUID()+"");
            imageEO.setPath(productRequest.getImagePath());
            imageEO.setProductId(Long.parseLong(productRequest.getIdentification()));
            imageRepository.save(imageEO);
            productRepository.save(productEO);
        }catch (Exception e){
            logger.info("获取失败!"+e.getMessage());
        }
    }


}
