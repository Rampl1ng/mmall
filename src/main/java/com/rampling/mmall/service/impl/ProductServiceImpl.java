package com.rampling.mmall.service.impl;

import com.rampling.mmall.entity.Product;
import com.rampling.mmall.mapper.ProductMapper;
import com.rampling.mmall.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rampling
 * @since 2021-02-06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
