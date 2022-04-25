package com.hz.smartorchard.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.smartorchard.common.ResponseState;
import com.hz.smartorchard.entity.RolePermissionRelation;
import com.hz.smartorchard.dao.RolePermissionRelationDao;
import com.hz.smartorchard.exception.SmartOrchardException;
import com.hz.smartorchard.service.RolePermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class RolePermissionRelationServiceImpl extends ServiceImpl<RolePermissionRelationDao, RolePermissionRelation> implements RolePermissionRelationService {

    @Autowired
    private RolePermissionRelationDao rolePermissionRelationDao;


    /*
        通过角色id来查询对应的权限id
     */
    @Override
    public List<Long> selectPermissionIdsListByRoleId(Long roleId) {
            log.info("进入到了selectPermissionListByRoleId方法");
        if(roleId == null){

            throw new SmartOrchardException(ResponseState.SERVER_ERROR,"角色id出现错误");
        }

        List<RolePermissionRelation> relations = rolePermissionRelationDao.selectList(new QueryWrapper<RolePermissionRelation>()
                .eq("roleId", roleId));

        if(relations.size() <= 0){
            throw new SmartOrchardException(ResponseState.WITHOUT_PERMISSION,"用户没有对应的权限");
        }

         // 拿到角色对应的所有权限id,收集成一个集合返回

        List<Long> permissionIds = relations.stream().map(item -> {

            return item.getPermissionId();
        }).collect(Collectors.toList());


            return permissionIds;
    }
}
