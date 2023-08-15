package com.cn.zmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 08:56:37
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

