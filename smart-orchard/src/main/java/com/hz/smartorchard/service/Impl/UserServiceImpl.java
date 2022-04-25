package com.hz.smartorchard.service.Impl;

import com.hz.smartorchard.entity.User;
import com.hz.smartorchard.dao.UserDao;
import com.hz.smartorchard.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
