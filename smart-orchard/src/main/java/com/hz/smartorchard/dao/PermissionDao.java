package com.hz.smartorchard.dao;

import com.hz.smartorchard.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
public interface PermissionDao extends BaseMapper<Permission> {

    List<String> findPermissionPathByUserId(Long userId);
}
