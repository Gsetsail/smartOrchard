package com.hz.smartorchard.controller;

import com.hz.smartorchard.common.CommonResult;
import com.hz.smartorchard.entity.User;
import com.hz.smartorchard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/smartorchard/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    @PreAuthorize("hasAuthority('sys:list')")
    public CommonResult getUerList(){

        List<User> list = userService.list();

        return CommonResult.ok().data("data",list);
    }
}
