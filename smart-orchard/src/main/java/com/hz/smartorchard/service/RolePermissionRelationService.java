package com.hz.smartorchard.service;

import com.hz.smartorchard.entity.RolePermissionRelation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
public interface RolePermissionRelationService extends IService<RolePermissionRelation> {

    List<Long> selectPermissionIdsListByRoleId(Long roleId);
}
