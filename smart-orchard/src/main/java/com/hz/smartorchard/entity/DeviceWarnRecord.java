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
@TableName("soms_device_warn_record")
@ApiModel(value = "DeviceWarnRecord对象", description = "")
public class DeviceWarnRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("预警记录id")
    @TableId("warnRecordId")
    private Long warnRecordId;

    @ApiModelProperty("预警记录所属设备id")
    @TableField("deviceId")
    private Long deviceId;

    @ApiModelProperty("所属园区id")
    @TableField("orchardId")
    private Long orchardId;

    @ApiModelProperty("设备名称")
    @TableField("deviceName")
    private String deviceName;

    @ApiModelProperty("错误内容")
    @TableField("deviceWarnContent")
    private String deviceWarnContent;

    @ApiModelProperty("0电话 1短信")
    @TableField("deviceWarnState")
    private Integer deviceWarnState;

    @ApiModelProperty("触发类型 0故障 1阈值")
    @TableField("deviceWarnType")
    private String deviceWarnType;

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
