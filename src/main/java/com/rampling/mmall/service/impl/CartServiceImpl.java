package com.rampling.mmall.service.impl;

import com.rampling.mmall.entity.Cart;
import com.rampling.mmall.mapper.CartMapper;
import com.rampling.mmall.service.CartService;
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
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

}
