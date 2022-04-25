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
@TableName("soms_device")
@ApiModel(value = "Device对象", description = "")
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备id")
    @TableId("deviceId")
    private Long deviceId;

    @ApiModelProperty("设备唯一序列编号")
    @TableField("deviceSn")
    private String deviceSn;

    @ApiModelProperty("设备名称")
    @TableField("deviceName")
    private String deviceName;

    @ApiModelProperty("所属设备类型id")
    @TableField("deviceTypeId")
    private Long deviceTypeId;

    @ApiModelProperty("所属果园id")
    @TableField("orchardId")
    private Long orchardId;

    @ApiModelProperty("设备位置")
    @TableField("deviceLocation")
    private String deviceLocation;

    @ApiModelProperty("设备启用状态 1代表启用 0代表禁用")
    @TableField("deviceState")
    private Integer deviceState;

    @ApiModelProperty("设备生产厂家")
    @TableField("deviceManuFacturer")
    private String deviceManuFacturer;

    @ApiModelProperty("参数描述")
    @TableField("deviceSoftwareVersion")
    private String deviceSoftwareVersion;

    @ApiModelProperty("设备的备注")
    @TableField("deviceRemark")
    private String deviceRemark;

    @ApiModelProperty("设备预警阈值 外键")
    @TableField("deviceThresholdId")
    private Long deviceThresholdId;

    @ApiModelProperty("设备调用接口")
    @TableField("deviceController")
    private String deviceController;

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
