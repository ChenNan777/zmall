package com.cn.zmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 08:56:36
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

