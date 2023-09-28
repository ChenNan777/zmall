package com.cn.zmall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cn.zmall.product.valid.AddGroup;
import com.cn.zmall.product.valid.ListValue;
import com.cn.zmall.product.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 品牌
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 08:56:37
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @Null(message = "新增不能指定ID", groups = {AddGroup.class})
    @NotNull(message = "修改必须指定ID", groups = {UpdateGroup.class})
    @TableId
    private Long brandId;
    /**
     * 品牌名
     */
    @NotBlank(message = "品牌名称必须提交")
    private String name;
    /**
     * 品牌logo地址
     */
    @NotBlank(message = "logo不能为空")
    @URL(message = "logo必须是一个合法的url地址")
    private String logo;
    /**
     * 介绍
     */
    private String descript;
    /**
     * 显示状态[0-不显示；1-显示]
     */
    @NotNull(message = "状态不能为空")
    @ListValue(vals = {0, 1}, message = "只能提交0或1")
    private Integer showStatus;
    /**
     * 检索首字母
     */
    @NotBlank(message = "首字母不能为空")
    @Pattern(regexp = "^[a-zA-Z]$", message = "检索字母必须为单个字母")
    private String firstLetter;
    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    @Min(value = 0, message = "排序必须大于等于0")
    private Integer sort;

}
