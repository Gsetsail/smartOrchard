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
@TableName("soms_device_video")
@ApiModel(value = "DeviceVideo对象", description = "")
public class DeviceVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("摄像头设备Id")
    @TableId("videoId")
    private Long videoId;

    @ApiModelProperty("视频设备名称")
    @TableField("videoName")
    private String videoName;

    @ApiModelProperty("视频品牌")
    @TableField("videoBrand")
    private String videoBrand;

    @ApiModelProperty("播放密钥")
    @TableField("accessToken")
    private String accessToken;

    @ApiModelProperty("设备号")
    @TableField("deviceSerial")
    private String deviceSerial;

    @ApiModelProperty("视频播放频道")
    @TableField("channelNo")
    private Integer channelNo;

    @ApiModelProperty("视频所属园区")
    @TableField("orchardId")
    private Long orchardId;

    @ApiModelProperty("摄像头类型 (枪机 球机...)")
    @TableField("videoType")
    private String videoType;

    @ApiModelProperty("视频状态(1启用 0禁用)")
    @TableField("state")
    private Integer state;

    @ApiModelProperty("视频播放地址")
    @TableField("videoUrl")
    private String videoUrl;

    @ApiModelProperty("maybe..根据appKey和secret获取accessToken接口")
    @TableField("appKey")
    private String appKey;

    @ApiModelProperty("maybe..根据appKey和secret获取accessToken接口")
    @TableField("appSecret")
    private String appSecret;

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
