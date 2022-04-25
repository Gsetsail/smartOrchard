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
@TableName("soms_warehouse_items")
@ApiModel(value = "WarehouseItems对象", description = "")
public class WarehouseItems implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物品ID")
    @TableId("goodsId")
    private Long goodsId;

    @ApiModelProperty("物品名称")
    @TableField("goodsName")
    private String goodsName;

    @ApiModelProperty("物品类型id外键")
    @TableField("warehouseGoodsId")
    private Long warehouseGoodsId;

    @ApiModelProperty("物品描述")
    @TableField("goodsDescribe")
    private String goodsDescribe;

    @ApiModelProperty("库存数")
    @TableField("stockNumber")
    private Integer stockNumber;

    @ApiModelProperty("物品单位")
    @TableField("goodsUnit")
    private String goodsUnit;

    @ApiModelProperty("图片路径")
    @TableField("imgpath")
    private String imgpath;


}
