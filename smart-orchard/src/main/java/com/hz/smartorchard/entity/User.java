package com.hz.smartorchard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("soms_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id唯一标识")
    @TableId(value = "userId")
    private Long userId;

    @ApiModelProperty("用户姓名")
    @TableField("userName")
    private String userName;

    @ApiModelProperty("用户密码")
    @TableField("userPassword")
    private String userPassword;

    @ApiModelProperty("用户使用头像")
    @TableField("userSalt")
    private String userSalt;

    @ApiModelProperty("最后一次登录时间")
    @TableField("userLasttime")
    private LocalDateTime userLasttime;

    @ApiModelProperty("最后一次登录ip地址")
    @TableField("userLoginIp")
    private Long userLoginIp;

    @ApiModelProperty("状态 0启用 1禁用")
    @TableField("userState")
    private Integer userState;

    @ApiModelProperty("用户手机号")
    @TableField("userMobile")
    private String userMobile;

    @ApiModelProperty("用户性别 1 代表男 0代表女")
    @TableField("userSex")
    private Integer userSex;

    @ApiModelProperty("用户地址")
    @TableField("userAddress")
    private String userAddress;

    @ApiModelProperty("创建时间")
    @TableField("creatTime")
    private LocalDateTime creatTime;

    @ApiModelProperty("修改时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除1(true)显示,0(false)不显示")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
