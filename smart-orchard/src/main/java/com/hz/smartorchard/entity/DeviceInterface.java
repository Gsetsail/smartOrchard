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
@TableName("soms_device_interface")
@ApiModel(value = "DeviceInterface对象", description = "")
public class DeviceInterface implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("设备接口Id")
    @TableId("interfaceId")
    private Long interfaceId;

    @ApiModelProperty("设备类型id外键")
    @TableField("deviceTypeid")
    private Long deviceTypeid;

    @ApiModelProperty("设备id外键")
    @TableField("deviceId")
    private Long deviceId;

    @ApiModelProperty("请求接口描述")
    @TableField("interfaceDescription")
    private String interfaceDescription;

    @ApiModelProperty("请求协议")
    @TableField("requestProtocol")
    private String requestProtocol;

    @ApiModelProperty("接口路径")
    @TableField("intefaceUrl")
    private String intefaceUrl;

    @ApiModelProperty("队列名称")
    @TableField("queuedName")
    private String queuedName;

    @ApiModelProperty("交换机类型")
    @TableField("switchType")
    private String switchType;

    @ApiModelProperty("交换机名称")
    @TableField("switchName")
    private String switchName;


}
