package com.hz.smartorchard.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("soms_device_type_description")
@ApiModel(value = "DeviceTypeDescription对象", description = "")
public class DeviceTypeDescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备类型id")
    @TableId("deviceTypeId")
    private Long deviceTypeId;

    @ApiModelProperty("设备类型的描述")
    @TableField("deviceTypeDescription")
    private String deviceTypeDescription;


}
