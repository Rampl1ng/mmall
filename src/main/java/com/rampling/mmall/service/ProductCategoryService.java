package com.rampling.mmall.service;

import com.rampling.mmall.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rampling.mmall.vo.ProductCategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Rampling
 * @since 2021-02-06
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    List<ProductCategoryVO> getAllProductCategoryVO();
}
