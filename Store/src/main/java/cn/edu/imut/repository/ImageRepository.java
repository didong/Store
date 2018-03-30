package cn.edu.imut.repository;

import cn.edu.imut.entity.ImageEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by di_dong on 2017/5/22.
 */
public interface ImageRepository extends JpaRepository<ImageEO,String> {
    /**
     *   通过商品id获取图片信息
     */
    List<ImageEO> findByProductId(Long productId);

}

