package com.hz.smartorchard.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("soms_text_type")
@ApiModel(value = "TextType对象", description = "")
public class TextType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章类型id")
    @TableId(value = "articleTypeId")
    private Long articleTypeId;

    @ApiModelProperty("文章类型")
    @TableField("articleType")
    private String articleType;

    @ApiModelProperty("添加时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty("逻辑删除1(true)显示,0(false)不显示")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
