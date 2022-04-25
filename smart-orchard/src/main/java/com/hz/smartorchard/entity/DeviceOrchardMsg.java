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
@TableName("soms_device_orchard_msg")
@ApiModel(value = "DeviceOrchardMsg对象", description = "")
public class DeviceOrchardMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("果园Id")
    @TableId("orchardId")
    private Long orchardId;

    @ApiModelProperty("A区 B区 C区")
    @TableField("orchardName")
    private String orchardName;

    @ApiModelProperty("园区描述 简介")
    @TableField("orchardDescription")
    private String orchardDescription;

    @ApiModelProperty("园区状态（1启用 0禁用）")
    @TableField("orchardState")
    private Integer orchardState;

    @ApiModelProperty("园区面积 占地多少亩")
    @TableField("orchardArea")
    private Double orchardArea;

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

    @ApiModelProperty("外键")
    @TableField("userId")
    private Long userId;


}
