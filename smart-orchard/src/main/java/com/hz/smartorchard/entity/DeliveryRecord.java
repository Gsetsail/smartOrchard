package com.hz.smartorchard.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("soms_delivery_record")
@ApiModel(value = "DeliveryRecord对象", description = "")
public class DeliveryRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("记录ID")
    @TableId("recordId")
    private Long recordId;

    @ApiModelProperty("记录描述")
    @TableField("recordDescribe")
    private String recordDescribe;

    @ApiModelProperty("用户ID外键")
    @TableField("userId")
    private Long userId;

    @ApiModelProperty("创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty("领取物品ID外键")
    @TableField("goodsId")
    private Long goodsId;

    @ApiModelProperty("出库数量")
    @TableField("goodsAmount")
    private Integer goodsAmount;


}
