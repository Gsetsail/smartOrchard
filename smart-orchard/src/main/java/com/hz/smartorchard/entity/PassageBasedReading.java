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
@TableName("soms_passage_based_reading")
@ApiModel(value = "PassageBasedReading对象", description = "")
public class PassageBasedReading implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章ID")
    @TableId("articleId")
    private Long articleId;

    @ApiModelProperty("文章名称")
    @TableField("articleName")
    private String articleName;

    @ApiModelProperty("文章路径")
    @TableField("articleUrl")
    private String articleUrl;

    @ApiModelProperty("文章类型id外键")
    @TableField("articleTypeId")
    private Long articleTypeId;

    @ApiModelProperty("内容")
    @TableField("articleMsg")
    private String articleMsg;

    @ApiModelProperty("标题")
    @TableField("articleTitle")
    private String articleTitle;

    @ApiModelProperty("文章等级设置置顶显示")
    @TableField("articleLv")
    private Integer articleLv;

    @ApiModelProperty("添加时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty("逻辑删除")
    @TableField("isDelete")
    @TableLogic
    private Integer isDelete;


}
