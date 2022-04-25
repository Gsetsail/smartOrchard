package com.hz.smartorchard.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.smartorchard.common.ResponseState;
import com.hz.smartorchard.dao.RolePermissionRelationDao;
import com.hz.smartorchard.entity.Permission;
import com.hz.smartorchard.dao.PermissionDao;
import com.hz.smartorchard.entity.Role;
import com.hz.smartorchard.entity.RolePermissionRelation;
import com.hz.smartorchard.entity.User;
import com.hz.smartorchard.exception.SmartOrchardException;
import com.hz.smartorchard.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hz.smartorchard.service.RolePermissionRelationService;
import com.hz.smartorchard.service.RoleService;
import com.hz.smartorchard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
@Service
@Slf4j
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission> implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    /**
     *  通过角色来获取权限
     * @param userId 此用户
     * @return
     */
    @Override
    public List<String> getPermissionByUserId(Long userId) {

        log.info("进入到了getPermissionByUserId()方法...");
        if(userId == null){

            throw new SmartOrchardException(ResponseState.WITHOUT_PERMISSION,"此用户还未分配角色");
        }

        List<String> permissionPath = permissionDao.findPermissionPathByUserId(userId);

        if (permissionPath.size() <= 0){;
            throw new SmartOrchardException(ResponseState.WITHOUT_PERMISSION,"此用户无权限");
        }

            return permissionPath;
    }


}
