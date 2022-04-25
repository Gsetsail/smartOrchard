package com.hz.smartorchard.service;

import com.hz.smartorchard.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.smartorchard.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
public interface PermissionService extends IService<Permission> {

    List<String> getPermissionByUserId(Long userId);
}
