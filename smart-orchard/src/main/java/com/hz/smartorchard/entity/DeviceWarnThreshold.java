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
@TableName("soms_device_warn_threshold")
@ApiModel(value = "DeviceWarnThreshold对象", description = "")
public class DeviceWarnThreshold implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备预警的阈值id")
    @TableId("deviceThresholdId")
    private Long deviceThresholdId;

    @ApiModelProperty("设备预警的阈值(最小值)")
    @TableField("deviceThresholdMin")
    private Integer deviceThresholdMin;

    @ApiModelProperty("设备预警的阈值(最大值)")
    @TableField("deviceThresholdMax")
    private Integer deviceThresholdMax;

    @ApiModelProperty("创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
