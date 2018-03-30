package cn.edu.imut.repository;

import cn.edu.imut.bean.dto.ProductRequest;
import cn.edu.imut.entity.ProductEO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by di_dong on 2017/5/22.
 */
public interface ProductRepository extends JpaRepository<ProductEO,Long> {
    /**
     * 获取最新的八条商品信息
     */
    @Query("FROM ProductEO product  WHERE ROWNUM<=8")
    List<ProductEO> findNewProducts8();


    /**
     *   获取最新的商品信息
     */
    @Query("FROM ProductEO product ORDER BY product.addedDate DESC")
    List<ProductEO> findNewProducts();

    /**
     * 通过商品id获取商品
     */
    ProductEO findByIdentification(Long identification);

}
