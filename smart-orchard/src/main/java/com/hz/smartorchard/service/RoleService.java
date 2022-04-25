package com.hz.smartorchard.service;

import com.hz.smartorchard.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.smartorchard.exception.SmartOrchardException;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
public interface RoleService extends IService<Role> {


    public List<Role> getRoleListByIds(List<Long> ids) ;

}
