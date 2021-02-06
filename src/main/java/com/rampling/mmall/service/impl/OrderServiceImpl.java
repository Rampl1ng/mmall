package com.rampling.mmall.service.impl;

import com.rampling.mmall.entity.Order;
import com.rampling.mmall.mapper.OrderMapper;
import com.rampling.mmall.service.OrderService;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
