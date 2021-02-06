package com.rampling.mmall.service.impl;

import com.rampling.mmall.entity.User;
import com.rampling.mmall.mapper.UserMapper;
import com.rampling.mmall.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
