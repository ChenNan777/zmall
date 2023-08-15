package com.cn.zmall.product.dao;

import com.cn.zmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 08:56:37
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
