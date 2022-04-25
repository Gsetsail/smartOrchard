package com.hz.smartorchard.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hz.smartorchard.common.ResponseState;
import com.hz.smartorchard.common.SomsConstants;
import com.hz.smartorchard.entity.Permission;
import com.hz.smartorchard.entity.Role;
import com.hz.smartorchard.entity.User;
import com.hz.smartorchard.entity.UserRoleRelation;
import com.hz.smartorchard.exception.SmartOrchardException;
import com.hz.smartorchard.security.entity.SecurityUser;
import com.hz.smartorchard.service.PermissionService;
import com.hz.smartorchard.service.RoleService;
import com.hz.smartorchard.service.UserRoleRelationService;
import com.hz.smartorchard.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    自定义的UserDetailService,通过自定义类去数据库通过用户名去查询用户相关信息,查询到之后,封装到自定义的SecurityUser中返回
    然后会进入AuthenticationManager.authenticate()来认证.
 */

@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleRelationService userRoleRelationService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        log.info("进入到了loadUserByUsername()方法........");
        if(!StringUtils.isNotBlank(username)){
            throw new SmartOrchardException(ResponseState.SERVER_ERROR,"用户名为空");
        }
        // 查询用户
        System.out.println("****************"+username+"-------------->"+SomsConstants.UserConstants.USER_STATE_ENABLE.getCode());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName",username);
        User userinfo = userService.getOne(wrapper);
        if(null == userinfo){
            log.error("数据库当中无此用户:{}",username);
            throw new UsernameNotFoundException("用户名不存在或用户已经被禁用,登录失败");
        }
        // 通过用户id查询到对应的角色id.
        Long userId = userinfo.getUserId();
        List<UserRoleRelation> relations = userRoleRelationService.list(new QueryWrapper<UserRoleRelation>().eq("userId", userId));
        if(relations.size() <= 0){

            throw new SmartOrchardException(ResponseState.SERVER_ERROR,"此用户无角色,请分配");
        }

        /*
                遍历用户角色关系表,获得角色id,封装到id集合,查出对应的所有角色.
         */
         List<Long> roleIds = new ArrayList<>();

          relations.forEach(item ->{
              roleIds.add(item.getRoleId());
          });

          /*
                通过角色id获取到所有角色信息,方便后续使用;
                通过用户id获取到此用户所对应的所有权限,都封装到userDetails中,后续security封装到Authentication对象中.
           */
        List<Role> roleInfoList = roleService.getRoleListByIds(roleIds);
        List<String> permissionsList = permissionService.getPermissionByUserId(userId);
        SecurityUser user = new SecurityUser();
        user.setUsername(userinfo.getUserName());
        user.setPassword(userinfo.getUserPassword());
        user.setRoleInfo(roleInfoList);
        user.setPermissions(permissionsList);


            return user;
    }
}
