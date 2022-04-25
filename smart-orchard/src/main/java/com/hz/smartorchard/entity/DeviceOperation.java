package com.hz.smartorchard.entity;

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
@TableName("soms_device_operation")
@ApiModel(value = "DeviceOperation对象", description = "")
public class DeviceOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备操作id")
    @TableId("operationId")
    private Long operationId;

    @ApiModelProperty("操作描述")
    @TableField("operationDescribe")
    private String operationDescribe;

    @ApiModelProperty("操作人（用户id）")
    @TableField("userId")
    private Long userId;

    @ApiModelProperty("接口id")
    @TableField("InterfaceId")
    private Long interfaceId;

    @ApiModelProperty("操作结果 0 成功 1失败")
    @TableField("operationResult")
    private Integer operationResult;

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
