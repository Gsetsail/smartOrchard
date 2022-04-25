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
@TableName("soms_warehouse_item_type")
@ApiModel(value = "WarehouseItemType对象", description = "")
public class WarehouseItemType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("物品类型ID")
    @TableId("warehouseGoodsId")
    private Long warehouseGoodsId;

    @ApiModelProperty("类型名称")
    @TableField("goodsTypeName")
    private String goodsTypeName;

    @ApiModelProperty("类型父级")
    @TableField("typeUpperId")
    private Integer typeUpperId;

    @ApiModelProperty("物品描述")
    @TableField("goodsDescribe")
    private String goodsDescribe;


}
