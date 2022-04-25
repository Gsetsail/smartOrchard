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
@TableName("soms_device_image")
@ApiModel(value = "DeviceImage对象", description = "")
public class DeviceImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备图片id")
    @TableId("id")
    private Long id;

    @ApiModelProperty("所属设备的id")
    @TableField("deviceId")
    private Long deviceId;

    @ApiModelProperty("设备图片路径")
    @TableField("deviceImageUrl")
    private String deviceImageUrl;


}
