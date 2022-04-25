package com.hz.smartorchard.service.Impl;

import com.hz.smartorchard.common.ResponseState;
import com.hz.smartorchard.entity.Role;
import com.hz.smartorchard.dao.RoleDao;
import com.hz.smartorchard.exception.SmartOrchardException;
import com.hz.smartorchard.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> getRoleListByIds(List<Long> ids)  {

        List<Role> roles = roleDao.selectBatchIds(ids);

        if(roles.size() <= 0){

            throw new SmartOrchardException(ResponseState.SERVER_ERROR,"当前id当中没有此角色");
        }



        return roles;
    }
}
