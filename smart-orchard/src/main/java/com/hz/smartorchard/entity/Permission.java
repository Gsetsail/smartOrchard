package com.hz.smartorchard.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 第五组
 * @since 2022-04-23
 */
@Getter
@Setter
@TableName("soms_permission")
@ApiModel(value = "Permission对象", description = "")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限唯一标识id")
    @TableId("permissionId")
    private Long permissionId;

    @ApiModelProperty("权限所属上级")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty("权限名称")
    @TableField("permissionName")
    private String permissionName;

    @ApiModelProperty("权限类型0是菜单;1是按钮")
    @TableField("permissionType")
    private Integer permissionType;

    @ApiModelProperty("权限值（拥有哪些增删改查的权限）")
    @TableField("permissionValue")
    private String permissionValue;

    @ApiModelProperty("路由跳转路径(跳转的页面html)")
    @TableField("permissionPath")
    private String permissionPath;

    @ApiModelProperty(value = "下级")
    @TableField(exist = false)
    private List<Permission> children = new ArrayList<>();

    @ApiModelProperty("创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除1(true)显示,0(false)不显示")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
