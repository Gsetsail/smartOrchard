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
@TableName("soms_device_plan_corn")
@ApiModel(value = "DevicePlanCorn对象", description = "")
public class DevicePlanCorn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("计划id")
    @TableId("planId")
    private Long planId;

    @ApiModelProperty("计划名称")
    @TableField("planName")
    private String planName;

    @ApiModelProperty("计划描述")
    @TableField("planDescribe")
    private String planDescribe;

    @ApiModelProperty("创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty("计划开始时间")
    @TableField("planBegin")
    private LocalDateTime planBegin;

    @ApiModelProperty("计划结束时间")
    @TableField("planEnd")
    private LocalDateTime planEnd;

    @ApiModelProperty("修改时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除1(true)显示,0(false)不显示")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("园区id外键")
    @TableField("orchardId")
    private Long orchardId;

    @ApiModelProperty("创建人id（用户id）外键")
    @TableField("userId")
    private Long userId;

    @ApiModelProperty("0（低）1（中）2（最高）")
    @TableField("planLevel")
    private Integer planLevel;


}
